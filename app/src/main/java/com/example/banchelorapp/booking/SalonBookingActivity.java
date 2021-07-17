package com.example.banchelorapp.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.banchelorapp.R;
import com.example.banchelorapp.SalonSelectatActivity;
import com.example.banchelorapp.ServiciiActivity;
import com.example.banchelorapp.fragments.DialogFragmentNumeProgramare;
import com.example.banchelorapp.mysql.BackgroundTask;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
//Activitatea in care preiau programarile
public class SalonBookingActivity extends AppCompatActivity {
    public static Context ctx;
    public static final String ORA = "ora";
    public static final String COD_SERVICIU = "codServiciu";
    public static final String DATA_INSERT = "dataInsert";
    View activityBookingView;
    public static boolean inserat;
    public static SalonBookingActivity currentApp;

    Calendar selected_date;
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    HorizontalCalendarView calendarView;
    SimpleDateFormat simpleDateFormat;
    public static SimpleDateFormat simpleDateFormatDB=new SimpleDateFormat("yyyy-MM-dd");
    HashMap<String, ArrayList<Integer>> zile;
    Context context;
    String codServiciu;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_booking);
        ctx=this.getApplicationContext();
        currentApp=this;


        while(!BackgroundTask.programariTerminat){
        }
        activityBookingView=findViewById(R.id.activityBookingView);
        intent =getIntent();
        codServiciu= (String) intent.getSerializableExtra(ServiciiActivity.COD_SERVICIU);
        context=this.getApplicationContext();
        linearLayout1 =findViewById(R.id.linear1);
        linearLayout2 =findViewById(R.id.linear2);
        linearLayout3 =findViewById(R.id.linear3);
        simpleDateFormat=new SimpleDateFormat("dd_MM_yyyy");

        selected_date=Calendar.getInstance();
        selected_date.add(Calendar.DATE,0);
        calendarView=findViewById(R.id.calendarViewBooking);

        init(activityBookingView);

        Calendar date=Calendar.getInstance();
        date.add(Calendar.DATE,0);

    }
    private void loadAvaibleTimeSlot(String zi, String dataInsert) {
        linearLayout1.removeAllViews();
        linearLayout2.removeAllViews();
        linearLayout3.removeAllViews();
        Integer oraInceput;
        Integer oraSfarsit;
        for(String key : zile.keySet()){
            if(zi.equals(key)){
                oraInceput=zile.get(key).get(0);
                oraSfarsit=zile.get(key).get(1);
                int i=0;
                    while(oraInceput<oraSfarsit){
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT);
                        Button btn = new Button(context);
                        btn.setId(oraInceput);
                        final int id_ = btn.getId();
                        String text=oraInceput+":00-"+(oraInceput+1)+":00";
                        oraInceput+=1;
                        btn.setText(text);
                        if(BackgroundTask.oreIndisponibile.containsKey(dataInsert)){
                            for(String programare:BackgroundTask.oreIndisponibile.get(dataInsert)){
                                if(programare.trim().equals(text.trim())){
                                    btn.setBackgroundColor(Color.rgb(238, 86, 86));
                                    btn.setEnabled(false);
                                }
                            }
                        }else{
                            btn.setBackgroundColor(Color.rgb(174, 255, 255));
                        }

                        if(i==0||i==3||i==6){
                            linearLayout1.addView(btn, params);
                        }else if(i==1||i==4||i==7){
                            linearLayout2.addView(btn, params);
                        }else if(i==2||i==5||i==8){
                            linearLayout3.addView(btn, params);
                        }
                        btn = ((Button) findViewById(id_));
                        btn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                //inserare in baza de date
                                inserat=false;
                                String ora=text;

                                DialogFragmentNumeProgramare dialogFragmentNumeProgramare=new DialogFragmentNumeProgramare();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable(ORA, ora);
                                bundle.putSerializable(COD_SERVICIU, codServiciu);
                                bundle.putSerializable(DATA_INSERT, dataInsert);

                                dialogFragmentNumeProgramare.setArguments(bundle);
                                dialogFragmentNumeProgramare.show(getSupportFragmentManager(),"MyDialogFragment");
                            }
                        });
                        if(inserat==true){
                            if(BackgroundTask.oreIndisponibile.containsKey(dataInsert))
                                BackgroundTask.oreIndisponibile.get(dataInsert).add(text);
                            else
                            {
                                ArrayList list=new ArrayList();
                                list.add(text);
                                BackgroundTask.oreIndisponibile.put(dataInsert,list);
                            }
                        }
                        inserat=false;
                        i++;
                }

            }
            }
    }
    private void init(View itemView) {
        calculOrePeZile();
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, 14);

        HorizontalCalendar horizontalCalendar=new HorizontalCalendar.Builder(itemView,R.id.calendarViewBooking)
                .range(startDate,endDate)
                .datesNumberOnScreen(1)
                .mode(HorizontalCalendar.Mode.DAYS)
                .defaultSelectedDate(startDate)
                .build()
                ;
        selected_date=startDate;
        String ziDinSaptamana=getZiDinSaptamana(selected_date);

        loadAvaibleTimeSlot(ziDinSaptamana,simpleDateFormatDB.format(selected_date.getTime()));

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                if(selected_date.getTimeInMillis()!=date.getTimeInMillis()){
                    selected_date=date;
                    String ziDinSaptamana=getZiDinSaptamana(date);
                    loadAvaibleTimeSlot(ziDinSaptamana.trim(),simpleDateFormatDB.format(selected_date.getTime()));
                }
            }
        });
    }

    private String getZiDinSaptamana(Calendar date) {
        String ziDinSaptamanaEng=String.valueOf(date.getTime()).trim().substring(0,4);
        String ziDinSaptamana="";
        if(ziDinSaptamanaEng.trim().toLowerCase().equals("mon")){
            ziDinSaptamana="luni";
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("thu")){
            ziDinSaptamana="marti";
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("wed")){
            ziDinSaptamana="miercuri";
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("tue")){
            ziDinSaptamana="joi";
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("fri")){
            ziDinSaptamana="vineri";
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("sat")){
            ziDinSaptamana="sambata";
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("sun")){
            ziDinSaptamana="duminica";
        }
        else{
            Log.e("Nu a intrat in niciun if","");
        }
        return ziDinSaptamana;
    }
    private void calculOrePeZile() {
        zile=new HashMap<>();
        ArrayList lista;
        for(String zi: SalonSelectatActivity.salonSelectat.getProgram()){
            String ziDinSaptamana=zi.split(" ")[0];
            if(!zi.split(" ")[1].equals("liber")){
                lista=new ArrayList();
                Integer oraInceput= Integer.valueOf(zi.split(" ")[1].split("-")[0].split(":")[0]);
                Integer oraSfarsit= Integer.valueOf(((zi.split(" "))[1]).split("-")[1].split(":")[0]);
                Integer orePeZi=oraSfarsit-oraInceput;
                lista.add(oraInceput);
                lista.add(oraSfarsit);
                lista.add(orePeZi);

                //arrayList-ul contine OraDeInceput si oraSfarsit
                zile.put(ziDinSaptamana,lista);
            }else{
                lista=new ArrayList<>();
                lista.add(0);
                lista.add(0);
                lista.add(0);
                zile.put(ziDinSaptamana,lista);
            }
        }

    }

}
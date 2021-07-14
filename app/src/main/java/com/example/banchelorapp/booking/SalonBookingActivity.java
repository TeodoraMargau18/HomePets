package com.example.banchelorapp.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.banchelorapp.ListaSaloaneActivity;
import com.example.banchelorapp.R;
import com.example.banchelorapp.SalonSelectatActivity;
import com.example.banchelorapp.ServiciiActivity;
import com.example.banchelorapp.calendarulProgramarilor.SpacesItemDecoration;
import com.example.banchelorapp.mysql.BackgroundTask;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class SalonBookingActivity extends AppCompatActivity {

    View activityBookingView;

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

        Log.e("Cate programari am pana acm ?", String.valueOf(BackgroundTask.oreIndisponibile.size()));

        String type="getProgramari";
        BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
        backgroundTask.execute(type, String.valueOf(SalonSelectatActivity.codSalon));


        activityBookingView=findViewById(R.id.activityBookingView);
        intent =getIntent();
        codServiciu= (String) intent.getSerializableExtra(ServiciiActivity.COD_SERVICIU);
        if(codServiciu!=null)
            Log.e("Ce cod am ?",codServiciu);
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

    private void loadAvaibleTimeSlot(String zi,String dataInsert) {
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
                        btn.setBackgroundColor(Color.rgb(174, 255, 255));
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
                                String type="inserareProgramare";
                                String ora=text;
                                Log.e("Ce data inserez",dataInsert);
                                BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
                                backgroundTask.execute(type,ora,"Jaqueline",codServiciu,dataInsert);
                                Toast.makeText(view.getContext(),
                                        "Button clicked index = " + id_, Toast.LENGTH_LONG)
                                        .show();
                            }
                        });
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
        Log.e("Ce data am selectat-data initiala?", simpleDateFormatDB.format(startDate.getTime()));

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                if(selected_date.getTimeInMillis()!=date.getTimeInMillis()){
                    selected_date=date;
                    Log.e("Schimb data","data schimbata");
                    String ziDinSaptamanaEng=String.valueOf(date.getTime()).trim().substring(0,4);
                    Log.e("In functie", ziDinSaptamanaEng+" - "+ziDinSaptamanaEng.trim().toLowerCase().equals("thu"));
                    String ziDinSaptamana=getZiDinSaptamana(date);

                    Log.e("Schimb data",ziDinSaptamana);

                    loadAvaibleTimeSlot(ziDinSaptamana.trim(),simpleDateFormatDB.format(selected_date.getTime()));
                    Log.e("Ce data am selectat?", ziDinSaptamana);
                }
            }
        });
    }

    private String getZiDinSaptamana(Calendar date) {
        String ziDinSaptamanaEng=String.valueOf(date.getTime()).trim().substring(0,4);
        String ziDinSaptamana="";
        if(ziDinSaptamanaEng.trim().toLowerCase().equals("mon")){
            ziDinSaptamana="luni";
            Log.e("In functie", ziDinSaptamana);
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("thu")){
            ziDinSaptamana="marti";
            Log.e("In functie", ziDinSaptamana);
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("wed")){
            ziDinSaptamana="miercuri";
            Log.e("In functie", ziDinSaptamana);
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("tue")){
            ziDinSaptamana="joi";
            Log.e("In functie", ziDinSaptamana);
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("fri")){
            ziDinSaptamana="vineri";
            Log.e("In functie", ziDinSaptamana);
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("sat")){
            ziDinSaptamana="sambata";
            Log.e("In functie", ziDinSaptamana);
        }else if(ziDinSaptamanaEng.trim().toLowerCase().equals("sun")){
            ziDinSaptamana="duminica";
            Log.e("In functie", ziDinSaptamana);
        }
        else{
            Log.e("Nu a intrat in niciun if","E naspa");
        }
        Log.e("In functie", ziDinSaptamana);
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
        Log.e("Finish","Am terminat de incarcat pe zile");

    }

}
package com.example.banchelorapp.calendarulProgramarilor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.banchelorapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class ProgramareSalonActivity extends AppCompatActivity implements ITimeSlotLoadListener {

    View activityProgramareView;

    List<TimeSlot> timeIndisponibil;

    //Aici ar trebui sa fac legatura cu baza de date
    ITimeSlotLoadListener iTimeSlotLoadListener;
//    AlertDialog dialog;

    //Aici lipseste ceva cu Unbinder dar poate e de la Fragment
    LocalBroadcastManager localBroadcastManager;
    Calendar selected_date;

    //
    RecyclerView recyclerView;
    HorizontalCalendarView calendarView;
    SimpleDateFormat simpleDateFormat;


    BroadcastReceiver displayTimeSlot=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Calendar date=Calendar.getInstance();
            date.add(Calendar.DATE,0);
            loadAvaibleTimeSlot(simpleDateFormat.format(date.getTime()));
        }
    };

    private void loadAvaibleTimeSlot(String format) {
        Log.e("Testez on receive din broadcast",format);
        Log.e("Testez loadAvaibleTimeSlot",format);
    }
    static ProgramareSalonActivity instance;
    public static ProgramareSalonActivity getInstance(){
        if(instance==null)
            instance=new ProgramareSalonActivity();
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programare_salon);
        timeIndisponibil=new ArrayList<>();
        iTimeSlotLoadListener=this;

        recyclerView=findViewById(R.id.recycleViewProgramare);
        localBroadcastManager=LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcastManager.registerReceiver(displayTimeSlot,new IntentFilter());
        simpleDateFormat=new SimpleDateFormat("dd_MM_yyyy");

//        dialog=new SpotsDialog.Builder().setContext(getApplicationContext()).setCancelable(false).build();
        selected_date=Calendar.getInstance();
        selected_date.add(Calendar.DATE,0);
        calendarView=findViewById(R.id.calendarView);

//        de aici nu mai e ok ?
        TimeSlot test1=new TimeSlot();
        test1.setSlot((long) 2);
        timeIndisponibil.add(test1);
        onTimeSlotLoadSucces(timeIndisponibil);

        activityProgramareView=findViewById(R.id.activityProgramareView);

        init(activityProgramareView);

        TimeSlotAdapter adapter=new TimeSlotAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);


        Calendar date=Calendar.getInstance();
        Log.e("Aici e problema??","Nu am o instanta");
        date.add(Calendar.DATE,0);
        Log.e("Aici e problema??","Nu am o instanta");

    }

    private void init(View itemView) {
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplication(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(8));

        //Calendar
        Calendar startDate=Calendar.getInstance();
        startDate.add(Calendar.DATE,0);

        Calendar endDate=Calendar.getInstance();
        endDate.add(Calendar.DATE,30);
        HorizontalCalendar horizontalCalendar=new HorizontalCalendar.Builder(itemView,R.id.calendarView)
                .range(startDate,endDate)
                .datesNumberOnScreen(3)
                .mode(HorizontalCalendar.Mode.DAYS)
                .defaultSelectedDate(startDate)
                .build()
                ;
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                if(selected_date.getTimeInMillis()!=date.getTimeInMillis()){
                    selected_date=date;
                    loadAvaibleTimeSlot(simpleDateFormat.format(date.getTime()));
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        localBroadcastManager.unregisterReceiver(displayTimeSlot);
        super.onDestroy();
    }

    @Override
    public void onTimeSlotLoadSucces(List<TimeSlot> timeSlotList) {
        Toast.makeText(this, "onTimeSlotLoadSucces", Toast.LENGTH_SHORT).show();
        TimeSlotAdapter adapter=new TimeSlotAdapter(getApplicationContext(),timeSlotList);
        recyclerView.setAdapter(adapter);
//        dialog.dismiss();
    }

    @Override
    public void onTimeSlotLoadFailed(String mesaj) {
        Toast.makeText(getApplicationContext(), mesaj, Toast.LENGTH_SHORT).show();
//        dialog.dismiss();
    }

    @Override
    public void onTimeSlotLoadEmpty() {
        Toast.makeText(this, "onTimeSlotLoadEmpty", Toast.LENGTH_SHORT).show();
        TimeSlotAdapter adapter=new TimeSlotAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
//        dialog.dismiss();
    }
}
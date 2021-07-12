package com.example.banchelorapp.calendarulProgramarilor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banchelorapp.R;

import java.util.ArrayList;
import java.util.List;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.MyViewHolder> {

    Context context;
    List<TimeSlot> timeSlots;
    public static final int nrTimeSlots=8;

    public TimeSlotAdapter(Context context) {
        this.context = context;
        this.timeSlots = new ArrayList<>();
    }

    public TimeSlotAdapter(Context context, List<TimeSlot> timeSlots) {
        this.context = context;
        this.timeSlots = timeSlots;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView time_slot_stare,time_slot_ora;
        CardView time_slot_card;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            time_slot_card=(CardView)   itemView.findViewById(R.id.time_slot_card);
            time_slot_stare=(TextView)   itemView.findViewById(R.id.time_slot_stare);
            time_slot_ora=(TextView)   itemView.findViewById(R.id.time_slot_ora);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.layout_time_slot,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.time_slot_ora.setText(new StringBuilder(convertTimeSlotToString(position)));
        if(timeSlots.size()==0){
            holder.time_slot_stare.setText("Disponibil");
            holder.time_slot_stare.setTextColor(context.getResources().getColor(android.R.color.black));
            holder.time_slot_ora.setTextColor(context.getResources().getColor(android.R.color.black));
            holder.time_slot_ora.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        }else{
            for(TimeSlot slotItem:timeSlots){
                int slot=Integer.parseInt(slotItem.getSlot().toString());
                if(slot==position){
                    holder.time_slot_card.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
                    holder.time_slot_stare.setText("Indisponibil");
                    holder.time_slot_stare.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));

                    holder.time_slot_ora.setTextColor(context.getResources().getColor(android.R.color.white));
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return TimeSlotAdapter.nrTimeSlots;
    }

    public static String convertTimeSlotToString(int i){
        switch (i){
            case 0 :
                return "9:00-10:00";
            case 1 :
                return "10:00-11:00";
            case 2 :
                return "11:00-12:00";
            case 3 :
                return "12:00-13:00";
            case 4 :
                return "13:00-14:00";
            case 5 :
                return "14:00-15:00";
            case 6 :
                return "15:00-16:00";
            case 7 :
                return "16:00-17:00";
            default:
                return "Inchis";
        }
    }

}

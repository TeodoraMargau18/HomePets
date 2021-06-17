package com.example.banchelorapp;

import java.util.List;

public interface ITimeSlotLoadListener {
    void onTimeSlotLoadSucces(List<TimeSlot> timeSlotList);
    void onTimeSlotLoadFailed(String mesaj);
    void onTimeSlotLoadEmpty();

}

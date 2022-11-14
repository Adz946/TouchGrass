package com.BITS.TouchGrass.reminders;

import java.time.LocalDate;
import java.time.LocalTime;

public class SelfReminder extends Reminder {


//    private int counter;
//    private String generatedId = String.format("s%03d", counter);

    public SelfReminder(String title, boolean allDayReminder, LocalDate startDate,
                        LocalDate endDate, LocalTime time, int repeatFrequency,
                        String priority, String description) {

        super(title, allDayReminder, startDate, endDate, time, repeatFrequency, priority, description);
//        this.setId(generatedId);
//
//        remindersList.add(this);
//        counter++;
    }


}

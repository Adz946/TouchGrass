package com.BITS.TouchGrass.reminders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SelfReminder extends Reminder {

    public SelfReminder(String title, boolean allDayReminder, LocalDate startDate,
                        LocalDate endDate, LocalTime time, int repeatFrequency, String priority) {
        super(title, allDayReminder, startDate, endDate, time, repeatFrequency, priority);

        remindersList.add(this);
    }
}

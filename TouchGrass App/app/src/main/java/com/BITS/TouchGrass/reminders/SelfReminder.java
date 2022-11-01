package com.BITS.TouchGrass.reminders;

import java.time.LocalDate;
import java.time.LocalTime;

public class SelfReminder extends Reminder {
    public SelfReminder(String title, boolean allDayReminder, LocalDate startDate, LocalDate nextDate, LocalDate endDate, LocalTime time, int priority) {
        super(title, allDayReminder, startDate, nextDate, endDate, time, priority);
    }
}

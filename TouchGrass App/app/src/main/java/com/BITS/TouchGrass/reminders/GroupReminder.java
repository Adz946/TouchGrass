package com.BITS.TouchGrass.reminders;

import java.time.LocalDate;
import java.time.LocalTime;

public class GroupReminder extends Reminder {

    // private ArrayList<Friend> invitedFriends;

    public GroupReminder(String title, boolean allDayReminder, LocalDate startDate,
                         LocalDate endDate, LocalTime time, int repeatFrequency,
                         String priority, String description) {
        super(title, allDayReminder, startDate, endDate, time, repeatFrequency, priority, description);

        remindersList.add(this);
    }
}

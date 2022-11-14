package com.BITS.TouchGrass.reminders;

import com.BITS.TouchGrass.profile.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GroupReminder extends Reminder {

    private ArrayList<User> invitedFriends;

    public GroupReminder(String title, boolean allDayReminder, LocalDate startDate,
                         LocalDate endDate, LocalTime time, int repeatFrequency,
                         String priority, String description, ArrayList<User> invitedFriends) {
        super(title, allDayReminder, startDate, endDate, time, repeatFrequency, priority, description);
        this.invitedFriends = invitedFriends;
        remindersList.add(this);
    }
}

package com.BITS.TouchGrass.reminders;

import com.BITS.TouchGrass.profile.Friend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GroupReminder extends Reminder {
    private ArrayList<Friend> invitedFriends;

    public GroupReminder(String title, boolean allDayReminder, LocalDate startDate, LocalDate nextDate, LocalDate endDate, LocalTime time, int priority) {
        super(title, allDayReminder, startDate, nextDate, endDate, time, priority);
    }
}

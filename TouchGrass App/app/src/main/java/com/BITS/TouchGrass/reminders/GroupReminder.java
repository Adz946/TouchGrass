package com.BITS.TouchGrass.reminders;

import com.BITS.TouchGrass.profile.Friend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GroupReminder extends Reminder {

    public static ArrayList<GroupReminder> currentGroupReminders = new ArrayList<>();

    private ArrayList<Friend> invitedFriends;

    public GroupReminder(String title, boolean allDayReminder, LocalDate startDate,
                         LocalDate endDate, LocalTime time, int repeatFrequency, String priority) {
        super(title, allDayReminder, startDate, endDate, time, repeatFrequency, priority);

        currentGroupReminders.add(this);
    }
}

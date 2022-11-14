package com.BITS.TouchGrass.reminders;

import com.BITS.TouchGrass.profile.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GroupReminder extends Reminder {

    private List<String> groupMembers = new ArrayList<>();
//    private int counter;
//    private String generatedId = String.format("g%03d", counter);

    public GroupReminder(String title, boolean allDayReminder, LocalDate startDate,
                         LocalDate endDate, LocalTime time, int repeatFrequency,
                         String priority, String description) {
        super(title, allDayReminder, startDate, endDate, time, repeatFrequency, priority, description);
//        this.setId(generatedId);
//
//        remindersList.add(this);
//        counter++;
    }

    public void addMember(String member) {
        groupMembers.add(member);
    }
}

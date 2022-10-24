package com.BITS.TouchGrass.reminders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Reminder {

    public static ArrayList<Reminder> remindersList = new ArrayList<>();

    private String title;
//    private boolean groupReminder;
//    private boolean allDayReminder;
//    private LocalDate startDate;
//    private LocalDate endDate;
//    private LocalTime time;
//    private String priority;

//    public Reminder(String title, boolean groupReminder, boolean allDayReminder,
//                    LocalDate startDate, LocalDate endDate, LocalTime time, String priority) {
//        this.title = title;
//        this.groupReminder = groupReminder;
//        this.allDayReminder = allDayReminder;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.time = time;
//        this.priority = priority;
//    }

    public Reminder(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public boolean isGroupReminder() {
//        return groupReminder;
//    }
//
//    public void setGroupReminder(boolean groupReminder) {
//        this.groupReminder = groupReminder;
//    }
//
//    public boolean isAllDayReminder() {
//        return allDayReminder;
//    }
//
//    public void setAllDayReminder(boolean allDayReminder) {
//        this.allDayReminder = allDayReminder;
//    }
//
//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(LocalDate startDate) {
//        this.startDate = startDate;
//    }
//
//    public LocalDate getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//    }
//
//    public LocalTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalTime time) {
//        this.time = time;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }

}

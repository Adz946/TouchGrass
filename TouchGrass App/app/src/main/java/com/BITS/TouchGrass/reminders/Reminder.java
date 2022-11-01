package com.BITS.TouchGrass.reminders;

import android.graphics.drawable.Drawable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Reminder {

//    public static ArrayList<Reminder> remindersList = new ArrayList<>();

    private String title;
    private boolean allDayReminder;
    private LocalDate startDate;
    private LocalDate nextDate;
    private LocalDate endDate;
    private LocalTime time;
    private int priority;


    public Reminder(String title, boolean allDayReminder, LocalDate startDate,
                    LocalDate nextDate, LocalDate endDate, LocalTime time, int priority) {
        this.title = title;
        this.allDayReminder = allDayReminder;
        this.startDate = startDate;
        this.nextDate = nextDate;
        this.endDate = endDate;
        this.time = time;
        this.priority = priority;
    }

    public Reminder(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAllDayReminder() {
        return allDayReminder;
    }

    public void setAllDayReminder(boolean allDayReminder) {
        this.allDayReminder = allDayReminder;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public void setNextDate(LocalDate nextDate) {
        this.nextDate = nextDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

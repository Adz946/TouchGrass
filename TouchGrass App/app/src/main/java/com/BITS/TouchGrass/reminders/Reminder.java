package com.BITS.TouchGrass.reminders;

import android.graphics.drawable.Drawable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Reminder {

    public static ArrayList<Reminder> remindersList = new ArrayList<>();
//    public static ArrayList<SelfReminder> currentSelfReminders = new ArrayList<>();
//    public static ArrayList<GroupReminder> currentGroupReminders = new ArrayList<>();


    private String title;
    private boolean allDayReminder;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime time;
    private int repeatFrequency;
    private String priority;
    private String description;


    public Reminder(String title, boolean allDayReminder, LocalDate startDate, LocalDate endDate,
                    LocalTime time, int repeatFrequency, String priority, String description) {
        this.title = title;
        this.allDayReminder = allDayReminder;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.repeatFrequency = repeatFrequency;
        this.priority = priority;
        this.description = description;
    }

    public static ArrayList<Reminder> remindersForDate(LocalDate date) {
        ArrayList<Reminder> reminders = new ArrayList<>();

        for (Reminder reminder : remindersList) {
            if (reminder.getEndDate().equals(date)) {
                reminders.add(reminder);
            }
        }

        return reminders;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getRepeatFrequency() {
        return repeatFrequency;
    }

    public void setRepeatFrequency(int repeatFrequency) {
        this.repeatFrequency = repeatFrequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

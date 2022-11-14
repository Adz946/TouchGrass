package com.BITS.TouchGrass;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ObjectClasses {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Reminder> reminders = new ArrayList<>();

    //------------------------------------------------------------------------------------------

    public static class User {

        private String username, password, image;
        private ArrayList<String> friends = new ArrayList<>();

        public String getUsername() { return this.username; }
        public String getPassword() { return this.password; }
        public String getImage() { return this.image; }
        public ArrayList<String> getFriends() { return this.friends; }

        public void setUsername(String username) { this.username = username; }
        public void setPassword(String password) { this.password = password; }
        public void setImage(String image) { this.image = image; }
        public void setFriend(String userN) { this.friends.add(userN); }
    }

    //------------------------------------------------------------------------------------------

    public static class Reminder {
        private String title, priority, repType, allDay;
        private int repAmount;
        private LocalDate sDate, eDate;
        private LocalTime time;

        public String getTitle() { return this.title; }
        public String getPriority() { return this.priority; }
        public String getRepType() { return this.repType; }
        public String getAllDay() { return this.allDay; }

        public int getRepAmount() { return this.repAmount; }
        public LocalDate get_sDate() { return this.sDate; }
        public LocalDate get_eDate() { return this.eDate; }
        public LocalTime getTime() { return this.time; }

        public void setTitle(String title) { this.title = title; }
        public void setPriority(String priority) { this.priority = priority; }
        public void setRepType(String repType) { this.repType = repType; }

        public void setRepAmount(int repAmount) { this.repAmount = repAmount; }
        public void setAllDay(String allDay) { this.allDay = allDay; }

        public void set_sDate(LocalDate sDate) { this.sDate = sDate; }
        public void set_eDate(LocalDate eDate) { this.eDate = eDate; }
        public void setTime(LocalTime time) { this.time = time; }
    }
}

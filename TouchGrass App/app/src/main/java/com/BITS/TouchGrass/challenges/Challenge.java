package com.BITS.TouchGrass.challenges;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Challenge {
    // stuff about each challenge

    public static ArrayList<Challenge> challengesList = new ArrayList<>();

    String title;
    LocalDate StartDate;
    LocalDate EndDate;
    LocalTime Time;
    ArrayList<String> ActiveDays;
    ArrayList<String> UsersInChallenge;


    public Challenge(String title, LocalDate StartDate, LocalDate EndDate, LocalTime Time,
                     ArrayList<String> ActiveDays, ArrayList<String> UsersInChallenge) {
        this.title = title;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Time = Time;
        this.ActiveDays = ActiveDays;
        this.UsersInChallenge = UsersInChallenge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate StartDate) {
        this.StartDate = StartDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate EndDate) {
        this.EndDate = EndDate;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime Time) {
        this.Time = Time;
    }

    public ArrayList<String> getActiveDays(){return ActiveDays;}

    public void setActiveDays(ArrayList<String> ActiveDays) {
        this.ActiveDays = ActiveDays;
    }

    public ArrayList<String> getUsersInChallenge() {
        return UsersInChallenge;
    }

    public void setUsersInChallenge(ArrayList<String> UsersInChallenge) {
        this.UsersInChallenge = UsersInChallenge;
    }

    class PastChallenge extends Challenge {
        String result;
        public PastChallenge(String title, LocalDate StartDate, LocalDate EndDate, LocalTime Time, ArrayList<String> ActiveDays, ArrayList<String> UsersInChallenge, String win) {
            super(title, StartDate, EndDate, Time, ActiveDays, UsersInChallenge);
        }
        public ArrayList<PastChallenge> ChallengesForDate(LocalDate date) {
            ArrayList<PastChallenge> past_challenges = new ArrayList<>();

            for (Challenge challenge : challengesList) {
                if (challenge.getEndDate().equals(date)) {
                    String title = challenge.title;
                    LocalDate StartDate = challenge.StartDate;
                    LocalDate EndDate = challenge.EndDate;
                    LocalTime Time = challenge.Time;
                    ArrayList<String> ActiveDays = challenge.ActiveDays;
                    ArrayList<String> UsersInChallenge = challenge.UsersInChallenge;

                    PastChallenge pastchallenge = new PastChallenge(title, StartDate, EndDate, Time, ActiveDays, UsersInChallenge, "Win");
                    past_challenges.add(pastchallenge);
                    challengesList.remove(challenge);
                }
            }

            return past_challenges;
        }
    }
}

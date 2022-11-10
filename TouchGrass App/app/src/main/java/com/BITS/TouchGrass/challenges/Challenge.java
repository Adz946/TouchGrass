package com.BITS.TouchGrass.challenges;

import java.util.ArrayList;

public class Challenge {
    // stuff about each challenge

    public static ArrayList<Challenge> challengesList = new ArrayList<>();

    String type;
    String title;


    public Challenge(String type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.BITS.TouchGrass.profile;

public class User {
    private String name;
    private String password;
    private boolean loggedIn;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.loggedIn = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn() {
        this.loggedIn = true;
    }

    public void setLogout() {
        this.loggedIn = false;
    }

    @Override
    public String toString() {
        return this.name + "," + this.password;
    }
}


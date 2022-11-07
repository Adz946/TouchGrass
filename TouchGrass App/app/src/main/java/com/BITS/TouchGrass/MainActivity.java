package com.BITS.TouchGrass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import com.BITS.TouchGrass.calendar.*;
import com.BITS.TouchGrass.reminders.*;
import com.BITS.TouchGrass.challenges.*;
import com.BITS.TouchGrass.profile.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.calendar);

        readProfileList();
    }

    public static List<User> users = new ArrayList<>();
    public static User user = null;

    private void readProfileList() {
        InputStream is = null;
        try {
            is = getAssets().open( "profiles.csv");
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error opening file " + e);
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");

                User user = new User(tokens[0], tokens[1]);
                users.add(user);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }
    }

    public static void logout() {
        for (int i = 0; i < users.size(); i++) {
            if (user.getName().equalsIgnoreCase(users.get(i).getName())) {
                users.get(i).setLogout();
                user = null;
            }
        }
    }



    ChallengesMainFragment challengesMainFragment = new ChallengesMainFragment();
    CalendarMainFragment calendarMainFragment = new CalendarMainFragment();
    RemindersMainFragment remindersMainFragment = new RemindersMainFragment();
    ProfileMainFragment profileMainFragment = new ProfileMainFragment();
    ProfileFriendsFragment profileFriendsFragment = new ProfileFriendsFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                if (user == null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileMainFragment).commit();
                    return true;
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFriendsFragment).commit();
                    return true;
                }


            case R.id.calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, calendarMainFragment).commit();
                return true;

            case R.id.reminders:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, remindersMainFragment).commit();
                return true;

            case R.id.challenges:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, challengesMainFragment).commit();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
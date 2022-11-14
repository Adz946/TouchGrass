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
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    public static String currentTheme;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.calendar);

        readProfileListFromAssets();
        readFriendsListFromAssets();
        readSelfRemindersFromAssets();
        readGroupRemindersFromAssets();


    }




    public static List<User> users = new ArrayList<>();
    public static List<ArrayList<String>> friendsList = new ArrayList<>();
    public static List<String> selfReminderList = new ArrayList<>();
    public static List<GroupReminder> groupReminderList = new ArrayList<>();

    public static User loggedUser = null;

    private void readProfileListFromAssets() {
        InputStream is = null;
        try {
            is = getAssets().open( "profiles.csv");
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error opening file " + e);
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");

                User user = new User(tokens[0].strip(), tokens[1].strip(), tokens[2].strip());
                users.add(user);
            }
            reader.close();
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }
//
//        for (int i= 0; i < users.size(); i++) {
//            Log.d("testing", users.get(i).toString());
//
//        }
    }

    private void readFriendsListFromAssets() {

        InputStream is = null;
        try {
            is = getAssets().open( "friends.csv");
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error opening file " + e);
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );

        String line = "";
        try {
            int counter = 0;

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",");
                friendsList.add(new ArrayList<>());

                for (int j = 0; j < tokens.length; j++) {
                    friendsList.get(counter).add(tokens[j].strip());
                }
                counter++;
            }
            reader.close();
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }

    private void readSelfRemindersFromAssets() {

        InputStream is = null;
        try {
            is = getAssets().open( "selfreminder.csv");
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error opening file " + e);
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );

        String line = "";
        try {

            while ((line = reader.readLine()) != null) {
                selfReminderList.add(line);
            }
            reader.close();
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }

    private void readGroupRemindersFromAssets() {
        InputStream is = null;
        try {
            is = getAssets().open( "groupreminder.csv");
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error opening file " + e);
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",");

                String title = tokens[0];
                boolean allDayReminder = Boolean.parseBoolean(tokens[1]);
                LocalDate startDate = LocalDate.parse(tokens[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate endDate = LocalDate.parse(tokens[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalTime time= LocalTime.parse(tokens[4], DateTimeFormatter.ofPattern("HH:mm"));
                int repeatFrequency = Integer.parseInt(tokens[5]);
                String priority = tokens[6].strip();
                String description = tokens[7];

                GroupReminder gr = new GroupReminder(title,allDayReminder,startDate,endDate,time,repeatFrequency,priority,description);

                for (int i = 8; i < tokens.length; i++) {
                    gr.addMember(tokens[i]);
                }

                groupReminderList.add(gr);

            }
            reader.close();
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }
    }


//    private void addSelfRemindersFromAssets() {
//        InputStream is = null;
//        try {
//            is = getAssets().open( "selfreminder.csv");
//        } catch (IOException e) {
//            Log.wtf("MyActivity", "Error opening file " + e);
//            e.printStackTrace();
//        }
//        BufferedReader reader = new BufferedReader(
//                new InputStreamReader(is, StandardCharsets.UTF_8)
//        );
//
//        String line = "";
//        try {
//            while ((line = reader.readLine()) != null) {
//                String[] tokens = line.split(",");
//
//                if (tokens[0].equalsIgnoreCase(loggedUser.getName())) {
//
//                    String title = tokens[1];
//                    boolean allDayReminder = Boolean.parseBoolean(tokens[2]);
//                    LocalDate startDate = LocalDate.parse(tokens[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//                    LocalDate endDate = LocalDate.parse(tokens[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//                    LocalTime time= LocalTime.parse(tokens[5], DateTimeFormatter.ofPattern("HH:mm"));
//                    int repeatFrequency = Integer.parseInt(tokens[6]);
//                    String priority = tokens[7].strip();
//                    String description = tokens[8];
//
//                    SelfReminder selfReminder = new SelfReminder(title,allDayReminder,startDate,endDate,time,repeatFrequency,priority,description);
//                    selfReminders.add(selfReminder);
//                }
//            }
//            reader.close();
//        } catch (IOException e) {
//            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
//            e.printStackTrace();
//        }
//
//
//
//        for (int i= 0; i < users.size(); i++) {
//            Log.d("testing", users.get(i).toString());
//
//        }
//
//    }




    public static void newUser(User user) {
        users.add(user);
        friendsList.add(new ArrayList<>());
        friendsList.get(friendsList.size()-1).add(user.getName());
    }
//    private void readProfileList() {
//
//        String filename = "profiles.csv";
//        File myExternalFile = new File(getExternalFilesDir("myFileStorage"), filename);
//        //File myExternalFile = new File(Environment.getExternalStorageState() + filename);
//        String myData ="";
//        try {
//            FileInputStream fis = new FileInputStream(myExternalFile);
//            DataInputStream in = new DataInputStream(fis);
//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
//            String strLine;
//            while ((strLine = br.readLine()) != null) {
//                String[] tokens = strLine.split(",");
//
//                User user = new User(tokens[0], tokens[1]);
//                users.add(user);
//            }
//            in.close();
//        } catch (IOException e) {
//            readProfileListFromAssets();
//            Toast.makeText(getApplicationContext(), "Load from File successful", Toast.LENGTH_SHORT).show();
//            Log.d("FFS DID THIS WORK", "LOADED");
//
//        } finally {
//            saveProfiles();
//        }
//    }
//
//    private void saveProfiles() {
//        String filename = "profiles.csv";
//        File myExternalFile = new File(Environment.getExternalStorageState() + filename);
//        String myData ="";
//        try {
//            FileOutputStream fos = new FileOutputStream(myExternalFile);
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < users.size(); i++) {
//                sb.append(users.get(i).toString());
//            }
//            fos.write(sb.toString().getBytes());
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void logout() {
        for (int i = 0; i < users.size(); i++) {
            if (loggedUser.getName().equalsIgnoreCase(users.get(i).getName())) {
                users.get(i).setLogout();
            }
        }
        loggedUser = null;
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
                if (loggedUser == null) {
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
                if (loggedUser == null) {
                    //getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileMainFragment).commit();
                    Toast.makeText(this, "Log in required to access this feature", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, remindersMainFragment).commit();
                    return true;
                }


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
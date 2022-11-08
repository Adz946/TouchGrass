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

        readProfileListFromAssets();
        readFriendsListFromAssets();
    }



    public static List<User> users = new ArrayList<>();
    public static List<List<String>> friendsList = new ArrayList<List<String>>();
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

    private void readFriendsListFromAssets() {

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
            int counter = 0;

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",");
                friendsList.add(new ArrayList<String>());

                for (int j = 0; j < tokens.length; j++) {
                    friendsList.get(counter).add(tokens[j]);
                }
                counter++;
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

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
                loggedUser = null;
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
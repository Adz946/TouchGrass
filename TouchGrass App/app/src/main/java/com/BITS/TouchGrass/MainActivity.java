package com.BITS.TouchGrass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import com.BITS.TouchGrass.calendar.*;
import com.BITS.TouchGrass.reminders.*;
import com.BITS.TouchGrass.challenges.*;
import com.BITS.TouchGrass.profile.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.calendar);
    }


    ChallengesMainFragment challengesMainFragment = new ChallengesMainFragment();
    CalendarMainFragment calendarMainFragment = new CalendarMainFragment();
    RemindersMainFragment remindersMainFragment = new RemindersMainFragment();
    ProfileMainFragment profileMainFragment = new ProfileMainFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileMainFragment).commit();
                return true;

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
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
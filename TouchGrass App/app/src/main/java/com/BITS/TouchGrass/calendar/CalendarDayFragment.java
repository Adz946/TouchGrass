package com.BITS.TouchGrass.calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.BITS.TouchGrass.R;

public class CalendarDayFragment extends Fragment {

    ListView dailyRemindersLV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar_day, container, false);

        initWidgets(view);

        return view;
    }


    private void initWidgets(View view) {
        dailyRemindersLV = view.findViewById(R.id.dailyRemindersLV);
    }


    public void previousDayAction(View view) {

    }

    public void nextDayAction(View view) {

    }

    public void newReminder(View view) {
    }
}
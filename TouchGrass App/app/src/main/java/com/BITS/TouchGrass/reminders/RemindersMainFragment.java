package com.BITS.TouchGrass.reminders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.BITS.TouchGrass.R;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


// https://www.geeksforgeeks.org/android-recyclerview/
public class RemindersMainFragment extends Fragment {

    private final EditReminderFragment editReminderFragment = new EditReminderFragment();

    Button newReminderButton;
    RecyclerView selfReminderRecyclerView, groupReminderRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reminders_main, container, false);

        initWidgets(view);
        setListeners();
        setEventAdapter();

        return view;
    }

    private void initWidgets(View view) {
        selfReminderRecyclerView = (RecyclerView) view.findViewById(R.id.selfRemindersRecyclerView);
        groupReminderRecyclerView = (RecyclerView) view.findViewById(R.id.groupRemindersRecyclerView);
        newReminderButton = view.findViewById(R.id.new_reminder_button);
    }

    private void setListeners() {
        newReminderButton.setOnClickListener(v -> {
            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.flFragment, editReminderFragment);
            fr.addToBackStack("reminder");
            fr.commit();
        });
    }

    public void setEventAdapter() {
//        ArrayList<Reminder> currentReminders = new ArrayList<>();
        ArrayList<SelfReminder> currentSelfReminders = new ArrayList<>();
        ArrayList<GroupReminder> currentGroupReminders = new ArrayList<>();

        currentSelfReminders.add(new SelfReminder("Yo", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentSelfReminders.add(new SelfReminder("What", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentSelfReminders.add(new SelfReminder("Is", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentGroupReminders.add(new GroupReminder("UP!", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentSelfReminders.add(new SelfReminder("Is", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentGroupReminders.add(new GroupReminder("UP!", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentGroupReminders.add(new GroupReminder("UPPER!", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentGroupReminders.add(new GroupReminder("UPPERER!", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentGroupReminders.add(new GroupReminder("MORE UPPER!", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentGroupReminders.add(new GroupReminder("UPPERERER!", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        currentGroupReminders.add(new GroupReminder("MOST UP!", false,
                LocalDate.now(), LocalDate.now(), LocalTime.now(), 0, "low"));

        LinearLayoutManager selfLayoutManager = new LinearLayoutManager(getContext());
        selfReminderRecyclerView.setLayoutManager(selfLayoutManager);

        LinearLayoutManager groupLayoutManager = new LinearLayoutManager(getContext());
        groupReminderRecyclerView.setLayoutManager(groupLayoutManager);

        SelfReminderAdapter selfReminderAdapter = new SelfReminderAdapter(
                requireActivity().getApplicationContext(), currentSelfReminders);
        GroupReminderAdapter groupReminderAdapter = new GroupReminderAdapter(
                requireActivity().getApplicationContext(), currentGroupReminders);

        selfReminderRecyclerView.setAdapter(selfReminderAdapter);
        groupReminderRecyclerView.setAdapter(groupReminderAdapter);
    }
}
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
import android.widget.ListView;

import com.BITS.TouchGrass.R;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;


// https://www.geeksforgeeks.org/android-recyclerview/
public class RemindersMainFragment extends Fragment {

    private final NewReminderFragment newReminderFragment = new NewReminderFragment();
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
        ArrayList<Reminder> currentReminders = new ArrayList<>();

        currentReminders.add(new Reminder("Yo", false, false, LocalDate.now(),
                LocalDate.now(), LocalDate.now(), LocalTime.now(), R.drawable.priority_button_blue));

        currentReminders.add(new Reminder("What", false, false, LocalDate.now(),
                LocalDate.now(), LocalDate.now(), LocalTime.now(), R.drawable.priority_button_red));

        currentReminders.add(new Reminder("Is", false, false, LocalDate.now(),
                LocalDate.now(), LocalDate.now(), LocalTime.now(), R.drawable.priority_button_yellow));

        currentReminders.add(new Reminder("UP!", false, false, LocalDate.now(),
                LocalDate.now(), LocalDate.now(), LocalTime.now(), R.drawable.priority_button_blue));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        selfReminderRecyclerView.setLayoutManager(layoutManager);

        ReminderAdapter reminderAdapter = new ReminderAdapter(requireActivity().getApplicationContext(), currentReminders);

        selfReminderRecyclerView.setAdapter(reminderAdapter);
    }
}
package com.BITS.TouchGrass.reminders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.BITS.TouchGrass.R;

import java.util.ArrayList;

public class RemindersMainFragment extends Fragment {

    private ListView selfReminderListView, groupReminderListView;
    private final NewReminderFragment newReminderFragment = new NewReminderFragment();
    private final EditReminderFragment editReminderFragment = new EditReminderFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reminders_main, container, false);

        Button newReminderButton = view.findViewById(R.id.new_reminder_button);
        newReminderButton.setOnClickListener(v -> {
            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.flFragment, editReminderFragment);
            fr.commit();
        });

        return view;
    }

//    public void onResume() {
//        super.onResume();
//        setEventAdapter();
//    }
//
//    public void setEventAdapter() {
//        ArrayList<Reminder> currentReminders = Reminder.remindersList;
//        ReminderAdapter reminderAdapter = new ReminderAdapter(requireActivity().getApplicationContext(), currentReminders);
//        selfReminderListView.setAdapter(reminderAdapter);
//    }
}
package com.BITS.TouchGrass.reminders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.BITS.TouchGrass.MainActivity;
import com.BITS.TouchGrass.R;
import com.BITS.TouchGrass.profile.User;
import com.bumptech.glide.Glide;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


// https://www.geeksforgeeks.org/android-recyclerview/
public class RemindersMainFragment extends Fragment {

    private final EditReminderFragment editReminderFragment = new EditReminderFragment();

    Button newReminderButton;
    RecyclerView selfReminderRecyclerView, groupReminderRecyclerView;
    SelfReminderAdapter selfReminderAdapter;
    GroupReminderAdapter groupReminderAdapter;
    ImageView profileImg;
    User loggedUser;

    //phi testing
    ArrayList<SelfReminder> selfReminderList = new ArrayList<>();


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

        this.loggedUser = MainActivity.loggedUser;



        initWidgets(view);
        setListeners();
//        try {
//            selfReminderAdapter.notifyDataSetChanged();
//        } catch (Exception ignored) {
//
//        }
        setReminderAdapter();

        Glide.with(this).load(this.loggedUser.getProfileImg()).into(profileImg);

        //phi testing
        createSelfReminderList(loggedUser);



        return view;
    }

    //phi testing - takes data from the master self reminder Array and puts ONLY relevant reminders to the current logged user.
    private void createSelfReminderList(User loggedUser) {
        for (int i = 0; i < MainActivity.selfReminderList.size(); i++) {
            String[] tokens = MainActivity.selfReminderList.get(i).split(",");
            if (tokens[0].equalsIgnoreCase(loggedUser.getName())) {

                String title = tokens[1];
                boolean allDayReminder = Boolean.parseBoolean(tokens[2]);
                LocalDate startDate = LocalDate.parse(tokens[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate endDate = LocalDate.parse(tokens[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalTime time= LocalTime.parse(tokens[5], DateTimeFormatter.ofPattern("HH:mm"));
                int repeatFrequency = Integer.parseInt(tokens[6]);
                String priority = tokens[7].strip();
                String description = tokens[8];

                SelfReminder selfReminder = new SelfReminder(title,allDayReminder,startDate,endDate,time,repeatFrequency,priority,description);
                selfReminderList.add(selfReminder);
            }
        }
    }

//    public static void resetLists() {
//        for (int i = 0; i < MainActivity.selfReminderList.size(); i++) {
//            selfReminderList = null;
//        }
//    }



    private void initWidgets(View view) {
        selfReminderRecyclerView = view.findViewById(R.id.selfRemindersRecyclerView);
        groupReminderRecyclerView = view.findViewById(R.id.groupRemindersRecyclerView);
        newReminderButton = view.findViewById(R.id.new_reminder_button);
        profileImg = view.findViewById(R.id.ReminderProfileImage);
    }

    private void setListeners() {
        newReminderButton.setOnClickListener(v -> {
            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.flFragment, editReminderFragment);
            fr.addToBackStack("reminder");
            fr.commit();
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        setReminderAdapter();
    }

    public void setReminderAdapter() {

//        ArrayList<SelfReminder> currentSelfReminders = SelfReminder.currentSelfReminders;
//        ArrayList<GroupReminder> currentGroupReminders = GroupReminder.currentGroupReminders;


        ArrayList<SelfReminder> currentSelfReminders = new ArrayList<>();
        ArrayList<GroupReminder> currentGroupReminders = new ArrayList<>();

        for (Reminder reminder : Reminder.remindersList) {
            if (reminder instanceof SelfReminder) {
                currentSelfReminders.add((SelfReminder) reminder);
            }
            if (reminder instanceof GroupReminder) {
                currentGroupReminders.add((GroupReminder) reminder);
            }
        }

        LinearLayoutManager selfLayoutManager = new LinearLayoutManager(getContext());
        selfReminderRecyclerView.setLayoutManager(selfLayoutManager);

        LinearLayoutManager groupLayoutManager = new LinearLayoutManager(getContext());
        groupReminderRecyclerView.setLayoutManager(groupLayoutManager);

        selfReminderAdapter = new SelfReminderAdapter(
                requireActivity().getApplicationContext(), selfReminderList);
                //requireActivity().getApplicationContext(), currentSelfReminders);
        groupReminderAdapter = new GroupReminderAdapter(
                requireActivity().getApplicationContext(), currentGroupReminders);

        selfReminderRecyclerView.setAdapter(selfReminderAdapter);
        groupReminderRecyclerView.setAdapter(groupReminderAdapter);
    }
}
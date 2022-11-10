package com.BITS.TouchGrass.challenges;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.graphics.Color;
import com.BITS.TouchGrass.R;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ChallengeCreateFragment extends Fragment {
    Button setTime, startDate, endDate, addFriendsBtn, createChallengeBtn, cancelBtn;
    ToggleButton  mon, tue, wed, thu, fri, sat, sun;
    EditText challengeNameET;
    ArrayList<String> ActiveDays = new ArrayList<>();
    int hour, minute;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
    LocalTime time;
    LocalDate StartDateTime, EndDateTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenge_create, container, false);

        initWidgets(view);

        return view;
    }


    private void initWidgets(View view) {
        mon = view.findViewById(R.id.btnMon);
        tue = view.findViewById(R.id.btnTue);
        wed = view.findViewById(R.id.btnWed);
        thu = view.findViewById(R.id.btnThu);
        fri = view.findViewById(R.id.btnFri);
        sat = view.findViewById(R.id.btnSat);
        sun = view.findViewById(R.id.btnSun);
        setTime = view.findViewById(R.id.btnSetTime);
        startDate = view.findViewById(R.id.btnStartDate);
        endDate = view.findViewById(R.id.btnEndDate);
        createChallengeBtn = view.findViewById(R.id.btnCreateChallenge);
        addFriendsBtn = view.findViewById(R.id.btnAddFriends);
        challengeNameET = view.findViewById(R.id.EnterChallengeName);
        cancelBtn = view.findViewById(R.id.btnCancelChallengeCreation);
        SetListeners();
    }

    private void SetListeners() {
        setTime.setOnClickListener(this::showTimePicker);
        startDate.setOnClickListener(this::showStartDatePicker);
        endDate.setOnClickListener(this::showEndDatePicker);
        cancelBtn.setOnClickListener(this::cancelOperation);
        mon.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked && !ActiveDays.contains("Monday")) {
                ActiveDays.add("Monday");
                mon.setBackgroundColor(Color.GREEN);
            }
            else {
                if (ActiveDays.contains("Monday")) {
                    ActiveDays.remove("Monday");
                }
                mon.setBackgroundColor(Color.LTGRAY);
            }
        });
//        mon.setOnCheckedChangeListener(changeDays(mon));
//        tue.setOnCheckedChangeListener(changeDays(tue));
//        wed.setOnCheckedChangeListener(changeDays(wed));
//        thu.setOnCheckedChangeListener(changeDays(thu));
//        fri.setOnCheckedChangeListener(changeDays(fri));
//        sat.setOnCheckedChangeListener(changeDays(sat));
//        sun.setOnCheckedChangeListener(changeDays(sun));
    }

//    private CompoundButton.OnCheckedChangeListener changeDays(ToggleButton daybtn) {
//        boolean inActiveDays = false;
//        int i;
//            if (daybtn == mon && mon.isChecked()) {
//                for (i = 0; i <= ActiveDays.size() && !inActiveDays; i++) {
//                    if (ActiveDays.get(i).equalsIgnoreCase("Monday")) {
//                        ActiveDays.remove("Monday");
//                        mon.setBackgroundColor(Color.LTGRAY);
//                        inActiveDays = true;
//                    }
//                    else {
//                        ActiveDays.add("Monday");
//                        mon.setBackgroundColor(Color.GREEN);
//                    }
//                }
//            }
//            else if (daybtn == tue && tue.isChecked()) {
//                for (i = 0; i <= ActiveDays.size() && !inActiveDays; i++) {
//                    if (ActiveDays.get(i).equalsIgnoreCase("Tuesday")) {
//                        ActiveDays.remove("Tuesday");
//                        tue.setBackgroundColor(Color.LTGRAY);
//                        inActiveDays = true;
//                    }
//                    else if (i == ActiveDays.size() - 1) {
//                        ActiveDays.add("Tuesday");
//                        tue.setTextColor(Color.GREEN);
//                    }
//                }
//            }
//            else if (daybtn == wed && wed.isChecked()) {
//                for (i = 0; i <= ActiveDays.size() && !inActiveDays; i++) {
//                    if (ActiveDays.get(i).equalsIgnoreCase("Wednesday")) {
//                        ActiveDays.remove("Wednesday");
//                        wed.setBackgroundColor(Color.LTGRAY);
//                        inActiveDays = true;
//                    }
//                    else if (i == ActiveDays.size() - 1) {
//                        ActiveDays.add("Wednesday");
//                        wed.setBackgroundColor(Color.GREEN);
//                    }
//                }
//            }
//            else if (daybtn == thu && thu.isChecked()) {
//                for (i = 0; i <= ActiveDays.size() && !inActiveDays; i++) {
//                    if (ActiveDays.get(i).equalsIgnoreCase("Thursday")) {
//                        ActiveDays.remove("Thursday");
//                        thu.setBackgroundColor(Color.LTGRAY);
//                        inActiveDays = true;
//                    }
//                    else if (i == ActiveDays.size() - 1) {
//                        ActiveDays.add("Thursday");
//                        thu.setBackgroundColor(Color.GREEN);
//                    }
//                }
//            }
//            else if (daybtn == fri && fri.isChecked()) {
//                for (i = 0; i <= ActiveDays.size() && !inActiveDays; i++) {
//                    if (ActiveDays.get(i).equalsIgnoreCase("Friday")) {
//                        ActiveDays.remove("Friday");
//                        fri.setBackgroundColor(Color.LTGRAY);
//                        inActiveDays = true;
//                    }
//                    else if (i == ActiveDays.size() - 1) {
//                        ActiveDays.add("Friday");
//                        fri.setBackgroundColor(Color.GREEN);
//                    }
//                }
//            }
//            else if (daybtn == sat && sat.isChecked()) {
//                for (i = 0; i <= ActiveDays.size() && !inActiveDays; i++) {
//                    if (ActiveDays.get(i).equalsIgnoreCase("Saturday")) {
//                        ActiveDays.remove("Saturday");
//                        sat.setBackgroundColor(Color.LTGRAY);
//                        inActiveDays = true;
//                    }
//                    else if (i == ActiveDays.size() - 1) {
//                        ActiveDays.add("Saturday");
//                        sat.setBackgroundColor(Color.GREEN);
//                    }
//                }
//            }
//            else if (daybtn == sun && sun.isChecked()) {
//                for (i = 0; i <= ActiveDays.size() && !inActiveDays; i++) {
//                    if (ActiveDays.get(i).equalsIgnoreCase("Sunday")) {
//                        ActiveDays.remove("Sunday");
//                        sun.setBackgroundColor(Color.LTGRAY);
//                        inActiveDays = true;
//                    }
//                    else if (i == ActiveDays.size() - 1) {
//                        ActiveDays.add("Sunday");
//                        sun.setBackgroundColor(Color.GREEN);
//                    }
//                }
//            }
//        return null;
//    }

    private void cancelOperation(View view) {
        getParentFragmentManager().popBackStack();
    }

    private void showTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener =
                (timePicker, selectedHour, selectedMinute) -> {

                    hour = selectedHour;
                    minute = selectedMinute;

                    String formattedTimeText;
                    String formattedTime;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");

                    if (hour == 0) {
                        if (minute < 10) {
                            formattedTimeText = String.format(Locale.getDefault(), "%d:0%d am", hour + 12, minute);
                        } else {
                            formattedTimeText = String.format(Locale.getDefault(), "%d:%d am", hour + 12, minute);
                        }
                    } else if (hour > 12) {
                        if (minute < 10) {
                            formattedTimeText = String.format(Locale.getDefault(), "%d:0%d pm", hour - 12, minute);
                        } else {
                            formattedTimeText = String.format(Locale.getDefault(), "%d:%d pm", hour - 12, minute);
                        }
                    } else if (hour == 12) {
                        if (minute < 10) {
                            formattedTimeText = String.format(Locale.getDefault(), "%d:0%d pm", hour, minute);
                        } else {
                            formattedTimeText = String.format(Locale.getDefault(), "%d:%d pm", hour, minute);
                        }
                    } else {
                        if (minute < 10) {
                            formattedTimeText = String.format(Locale.getDefault(), "%d:0%d am", hour, minute);
                        } else {
                            formattedTimeText = String.format(Locale.getDefault(), "%d:%d am", hour, minute);
                        }
                    }

                    formattedTime = String.format(Locale.getDefault(), "%d:%d", hour, minute);
                    time = LocalTime.parse(formattedTime, formatter);
                    setTime.setText(formattedTimeText);
                    setTime.setBackgroundColor(Color.GREEN);
                };

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), onTimeSetListener,
                hour, minute, false);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    private void showStartDatePicker(View view) {
        DatePickerDialog.OnDateSetListener onDateSetListener = (datePicker, year, month, day) -> {
            month = month + 1;
            String date = makeDateString(day, month, year);

            startDate.setText(date);
            StartDateTime = LocalDate.parse(date, dtf);
            startDate.setBackgroundColor(Color.GREEN);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private void showEndDatePicker(View view) {
        DatePickerDialog.OnDateSetListener onDateSetListener = (datePicker, year, month, day) -> {
            month = month + 1;
            String date = makeDateString(day, month, year);

            endDate.setText(date);
            EndDateTime = LocalDate.parse(date, dtf);
            endDate.setBackgroundColor(Color.GREEN);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private String makeDateString(int day, int month, int year) {
        return String.format(Locale.getDefault(), "%d/%d/%d", day, month, year);
    }

}
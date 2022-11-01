package com.BITS.TouchGrass.reminders;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.BITS.TouchGrass.R;
import com.BITS.TouchGrass.profile.Friend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class EditReminderFragment extends Fragment {

    ArrayList<Friend> friendsSharedWith = new ArrayList<Friend>();

    String repeatFrequency, priority, description;
    boolean isGroupReminder, isAllDayReminder;
    LocalDate startDate, endDate;
    Ringtone ringtone;

    ToggleButton priorityLow, priorityModerate, priorityHigh;
    Spinner setRepeatSpinner;
    Button setTimeBtn, setStartDateBtn, setEndDateBtn, setToneBtn, cancelBtn, addReminderBtn;
    EditText title;
    CheckBox allDayCheckBox;
    int hour, minute;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_reminder, container, false);

        // Initialise all the UI elements
        initWidgets(view);

        // Methods to call
        buildRepeatSpinner();  // builds the repeat frequency drop down
        priorityModerate.setChecked(true);  // defaults the priority to 'moderate'
        setStartDateBtn.setText(getTodaysDate());
        setEndDateBtn.setText(getTodaysDate());
        setListeners();  // initialises all element listeners

        return view;
    }

    private void initWidgets(View view) {
        setTimeBtn = (Button) view.findViewById(R.id.set_time_button);
        setStartDateBtn = (Button) view.findViewById(R.id.start_date_button);
        setEndDateBtn = (Button) view.findViewById(R.id.end_date_button);
        cancelBtn = (Button) view.findViewById(R.id.cancel_button);
        addReminderBtn = (Button) view.findViewById(R.id.add_reminder_button);
        setRepeatSpinner = (Spinner) view.findViewById(R.id.spinner_repeat_reminder);
        priorityLow = (ToggleButton) view.findViewById(R.id.priority_low);
        priorityModerate = (ToggleButton) view.findViewById(R.id.priority_moderate);
        priorityHigh = (ToggleButton) view.findViewById(R.id.priority_high);
        setToneBtn = (Button) view.findViewById(R.id.set_tone_button);
        allDayCheckBox = (CheckBox) view.findViewById(R.id.all_day_checkbox);
    }


    private void setListeners() {

        // onClick listeners (buttons)
        setTimeBtn.setOnClickListener(this::showTimePicker);
        setStartDateBtn.setOnClickListener(this::showStartDatePicker);
        setEndDateBtn.setOnClickListener(this::showEndDatePicker);
        cancelBtn.setOnClickListener(this::cancelOperation);
        addReminderBtn.setOnClickListener(this::addReminder);
        setToneBtn.setOnClickListener(this::setTone);
        allDayCheckBox.setOnClickListener(this::toggleAllDayReminder);

        // onCheckChange listeners (toggles)
        priorityLow.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) { // The toggle is enabled
                priorityModerate.setChecked(false);
                priorityHigh.setChecked(false);
                priority = "low";
            }
            // if all the toggles are turned off, turn the moderate setting on
            if (!(priorityLow.isChecked() || priorityModerate.isChecked()
                    || priorityHigh.isChecked())) {
                priorityModerate.setChecked(true);
                priority = "moderate";
            }
        });
        priorityModerate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) { // The toggle is enabled
                priorityLow.setChecked(false);
                priorityHigh.setChecked(false);
                priority = "moderate";
            }
            // if all the toggles are turned off, turn the moderate setting on
            if (!(priorityLow.isChecked() || priorityModerate.isChecked()
                    || priorityHigh.isChecked())) {
                priorityModerate.setChecked(true);
                priority = "moderate";
            }
        });
        priorityHigh.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) { // The toggle is enabled
                priorityLow.setChecked(false);
                priorityModerate.setChecked(false);
                priority = "high";
            }
            // if all the toggles are turned off, turn the moderate setting on
            if (!(priorityLow.isChecked() || priorityModerate.isChecked()
                    || priorityHigh.isChecked())) {
                priorityModerate.setChecked(true);
                priority = "moderate";
            }
        });
    }


    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;  // 'cal' returns january as 0, so add 1 to be normal
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return makeDateString(day, month, year);
    }


    private String makeDateString(int day, int month, int year) {
        return String.format(Locale.getDefault(), "%d/%d/%d", day, month, year);
    }


    private void buildRepeatSpinner() {
        // creates an adapter from the spinner template, and applies to our options in 'repeat_reminder'
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.repeat_reminder, android.R.layout.simple_spinner_item);
        // sets the layout resource
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // applies the adapter to our drop down
        setRepeatSpinner.setAdapter(adapter);
    }


    private void addReminder(View view) {
        Reminder reminder = new Reminder("fix this up");
    }


    private void cancelOperation(View view) {
        getParentFragmentManager().popBackStack();
    }


    private void setTone(View view) {
        // Intent to select Ringtone.
        final Uri currentTone = RingtoneManager.getActualDefaultRingtoneUri(getContext(),
                RingtoneManager.TYPE_NOTIFICATION);
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_RINGTONE);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, currentTone);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
        startActivityForResult(intent, 999);
    }


    private void showStartDatePicker(View view) {
        DatePickerDialog.OnDateSetListener onDateSetListener = (datePicker, year, month, day) -> {
            month = month + 1;
            String date = makeDateString(day, month, year);

            setStartDateBtn.setText(date);
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

            setEndDateBtn.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
        datePickerDialog.show();
    }


    private void showTimePicker(View view) {
        if (!isAllDayReminder) {
            TimePickerDialog.OnTimeSetListener onTimeSetListener =
                (timePicker, selectedHour, selectedMinute) -> {

                    hour = selectedHour;
                    minute = selectedMinute;

                    String formattedTime;

                    if (hour == 0)
                        if (minute < 10)
                            formattedTime = String.format(Locale.getDefault(), "%d:0%d am", hour + 12, minute);
                        else
                            formattedTime = String.format(Locale.getDefault(), "%d:%d am", hour + 12, minute);

                    else if (hour > 12)
                        if (minute < 10)
                            formattedTime = String.format(Locale.getDefault(), "%d:0%d pm", hour - 12, minute);
                        else
                            formattedTime = String.format(Locale.getDefault(), "%d:%d pm", hour - 12, minute);

                    else if (hour == 12)
                        if (minute < 10)
                            formattedTime = String.format(Locale.getDefault(), "%d:0%d pm", hour, minute);
                        else
                            formattedTime = String.format(Locale.getDefault(), "%d:%d pm", hour, minute);

                    else
                        if (minute < 10)
                        formattedTime = String.format(Locale.getDefault(), "%d:0%d am", hour, minute);
                        else
                            formattedTime = String.format(Locale.getDefault(), "%d:%d am", hour, minute);

                    setTimeBtn.setText(formattedTime);
                };

            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), onTimeSetListener,
                    hour, minute, false);

            timePickerDialog.setTitle("Select Time");
            timePickerDialog.show();
        }
    }


    private void toggleAllDayReminder(View view) {
        isAllDayReminder = allDayCheckBox.isChecked();
        if (isAllDayReminder)
            setTimeBtn.setBackgroundColor(Color.LTGRAY);
        else
            setTimeBtn.setBackgroundColor(getResources().getColor(R.color.grass_green));
    }

    private void addReminder() {
        if (isGroupReminder) {
            addGroupReminder();
        } else {
            addSelfReminder();
        }
    }

    private void addSelfReminder() {
//        SelfReminder reminder = new SelfReminder();
    }

    private void addGroupReminder() {

    }


//    public void saveReminderAction(View view) {
//        title
//    }
}

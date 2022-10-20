package com.BITS.TouchGrass.reminders;

import android.app.TimePickerDialog;
import android.media.Ringtone;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.BITS.TouchGrass.R;
import com.BITS.TouchGrass.profile.Friend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class EditReminderFragment extends Fragment {

    ArrayList<Friend> friendsSharedWith = new ArrayList<Friend>();

    String repeatFrequency, priority, description;
    boolean groupReminder, isAllDayReminder;
    LocalDate startDate, endDate;
    Ringtone ringtone;

    ToggleButton priorityLow, priorityModerate, priorityHigh;
    Spinner setToneSpinner;
    Button setTimeBtn, setStartDateBtn, setEndDateBtn, cancelBtn, addReminderBtn;
    EditText title;
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

        setTimeBtn = (Button) view.findViewById(R.id.set_time_button);
        setTimeBtn.setOnClickListener(this::showTimePicker);

        setStartDateBtn = (Button) view.findViewById(R.id.start_date_button);
        setStartDateBtn.setOnClickListener(this::showDatePicker);

        setEndDateBtn = (Button) view.findViewById(R.id.end_date_button);
        setEndDateBtn.setOnClickListener(this::showDatePicker);

        cancelBtn = (Button) view.findViewById(R.id.cancel_button);
        cancelBtn.setOnClickListener(this::cancelOperation);

        addReminderBtn = (Button) view.findViewById(R.id.add_reminder_button);
        addReminderBtn.setOnClickListener(this::addReminder);

        setToneSpinner = (Spinner) view.findViewById(R.id.spinner_repeat_reminder);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.repeat_reminder, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        setToneSpinner.setAdapter(adapter);


        priorityLow = (ToggleButton) view.findViewById(R.id.priority_low);
        priorityModerate = (ToggleButton) view.findViewById(R.id.priority_moderate);
        priorityHigh = (ToggleButton) view.findViewById(R.id.priority_high);
        priorityModerate.setChecked(true);

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


        return view;
    }


    public void addReminder(View view) {
        Reminder reminder = new Reminder("fix this up");
    }


    public void cancelOperation(View view) {
        getParentFragmentManager().popBackStack();
    }


    public void showDatePicker(View view) {

    }


    public void showTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = (timePicker, selectedHour, selectedMinute) -> {

            hour = selectedHour;
            minute = selectedMinute;

            String formattedTime;

            if (hour == 0)
                if (minute < 10)
                    formattedTime = String.format(Locale.getDefault(),"%d:0%d am",hour+12,minute);
                else
                    formattedTime = String.format(Locale.getDefault(),"%d:%d am",hour+12,minute);

            else if (hour > 12)
                if (minute < 10)
                    formattedTime = String.format(Locale.getDefault(),"%d:0%d pm",hour-12,minute);
                else
                    formattedTime = String.format(Locale.getDefault(),"%d:%d pm",hour-12,minute);

            else if (hour == 12)
                if (minute < 10)
                    formattedTime = String.format(Locale.getDefault(),"%d:0%d pm",hour,minute);
                else
                    formattedTime = String.format(Locale.getDefault(),"%d:%d pm",hour,minute);

            else
            if (minute < 10)
                formattedTime = String.format(Locale.getDefault(),"%d:0%d am",hour,minute);
            else
                formattedTime = String.format(Locale.getDefault(),"%d:%d am",hour,minute);

            setTimeBtn.setText(formattedTime);
        };

//        int style = AlertDialog.THEME_HOLO_DARK;
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, false);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

//    public void saveReminderAction(View view) {
//        title
//    }
}

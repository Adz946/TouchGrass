package com.BITS.TouchGrass.reminders;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.BITS.TouchGrass.R;

import java.util.Locale;

public class NewReminderFragment extends Fragment {


    Button setTimeBtn;
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


        setTimeBtn = view.findViewById(R.id.set_time_button);
        setTimeBtn.setOnClickListener(this::popTimePicker);

        return view;
    }


    public void popTimePicker(View v) {
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
}
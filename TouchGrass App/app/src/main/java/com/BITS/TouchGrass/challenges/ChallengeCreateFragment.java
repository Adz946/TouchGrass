package com.BITS.TouchGrass.challenges;

import static android.graphics.Color.parseColor;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.graphics.drawable.DrawableCompat;
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
    public static final int MIDGREY = parseColor("#585B58");

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
        //Creating background maps
        Drawable monBackground = mon.getBackground();
        monBackground = DrawableCompat.wrap(monBackground);
        Drawable finalMonBackground = monBackground;
        Drawable tueBackground = tue.getBackground();
        tueBackground = DrawableCompat.wrap(tueBackground);
        Drawable finalTueBackground = tueBackground;
        Drawable wedBackground = wed.getBackground();
        wedBackground = DrawableCompat.wrap(wedBackground);
        Drawable finalWedBackground = wedBackground;
        Drawable thuBackground = thu.getBackground();
        thuBackground = DrawableCompat.wrap(thuBackground);
        Drawable finalThuBackground = thuBackground;
        Drawable friBackground = fri.getBackground();
        friBackground = DrawableCompat.wrap(friBackground);
        Drawable finalFriBackground = friBackground;
        Drawable satBackground = sat.getBackground();
        satBackground = DrawableCompat.wrap(satBackground);
        Drawable finalSatBackground = satBackground;
        Drawable sunBackground = sun.getBackground();
        sunBackground = DrawableCompat.wrap(sunBackground);
        Drawable finalSunBackground = sunBackground;
        //Day button listeners
        mon.setOnCheckedChangeListener((monView, MonisChecked) -> {
            if (MonisChecked && !ActiveDays.contains("Monday")) {
                ActiveDays.add("Monday");
                DrawableCompat.setTint(finalMonBackground, Color.GREEN);
                mon.setBackground(finalMonBackground);
            } else {
                if (ActiveDays.contains("Monday")) {
                    DrawableCompat.setTint(finalMonBackground, MIDGREY);
                    mon.setBackground(finalMonBackground);
                    ActiveDays.remove("Monday");
                }
            }
        tue.setOnCheckedChangeListener((tueView, TueisChecked) -> {
            if (TueisChecked && !ActiveDays.contains("Tuesday")) {
                ActiveDays.add("Tuesday");
                DrawableCompat.setTint(finalTueBackground, Color.GREEN);
                tue.setBackground(finalTueBackground);
            } else {
                if (ActiveDays.contains("Tuesday")) {
                    DrawableCompat.setTint(finalTueBackground, MIDGREY);
                    tue.setBackground(finalTueBackground);
                    ActiveDays.remove("Tuesday");
                }
            }
        wed.setOnCheckedChangeListener((wedView, WedisChecked) -> {
            if (WedisChecked && !ActiveDays.contains("Wednesday")) {
                ActiveDays.add("Wednesday");
                DrawableCompat.setTint(finalWedBackground, Color.GREEN);
                wed.setBackground(finalWedBackground);
            } else {
                if (ActiveDays.contains("Wednesday")) {
                    DrawableCompat.setTint(finalWedBackground, MIDGREY);
                    wed.setBackground(finalWedBackground);
                    ActiveDays.remove("Wednesday");
                }
            }
        });
        thu.setOnCheckedChangeListener((thuView, ThuisChecked) -> {
            if (ThuisChecked && !ActiveDays.contains("Thursday")) {
                ActiveDays.add("Thursday");
                DrawableCompat.setTint(finalThuBackground, Color.GREEN);
                thu.setBackground(finalThuBackground);
            } else {
                if (ActiveDays.contains("Thursday")) {
                    DrawableCompat.setTint(finalThuBackground, MIDGREY);
                    thu.setBackground(finalThuBackground);
                    ActiveDays.remove("Thursday");
                }
            }
        fri.setOnCheckedChangeListener((friView, FriisChecked) -> {
            if (FriisChecked && !ActiveDays.contains("Friday")) {
                ActiveDays.add("Friday");
                DrawableCompat.setTint(finalFriBackground, Color.GREEN);
                fri.setBackground(finalFriBackground);
            } else {
                if (ActiveDays.contains("Friday")) {
                    DrawableCompat.setTint(finalFriBackground, MIDGREY);
                    fri.setBackground(finalFriBackground);
                    ActiveDays.remove("Friday");
                }
            }
        sat.setOnCheckedChangeListener((satView, SatisChecked) -> {
            if (SatisChecked && !ActiveDays.contains("Saturday")) {
                ActiveDays.add("Saturday");
                DrawableCompat.setTint(finalSatBackground, Color.GREEN);
                sat.setBackground(finalSatBackground);
            } else {
                if (ActiveDays.contains("Saturday")) {
                    DrawableCompat.setTint(finalSatBackground, MIDGREY);
                    sat.setBackground(finalSatBackground);
                    ActiveDays.remove("Saturday");
                }
            }
        sun.setOnCheckedChangeListener((sunView, SunisChecked) -> {
            if (SunisChecked && !ActiveDays.contains("Sunday")) {
                ActiveDays.add("Sunday");
                DrawableCompat.setTint(finalSunBackground, Color.GREEN);
                sun.setBackground(finalSunBackground);
            } else {
                if (ActiveDays.contains("Sunday")) {
                    DrawableCompat.setTint(finalSunBackground, MIDGREY);
                    sun.setBackground(finalSunBackground);
                    ActiveDays.remove("Sunday");
                }
            }
        });
        });
        });
        });
        });
        });
    }

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
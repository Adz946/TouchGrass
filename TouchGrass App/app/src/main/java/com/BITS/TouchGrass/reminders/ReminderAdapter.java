package com.BITS.TouchGrass.reminders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.BITS.TouchGrass.R;

import java.util.List;

public class ReminderAdapter extends ArrayAdapter<Reminder> {

    public ReminderAdapter(@NonNull Context context, List<Reminder> reminders) {
        super(context, 0, reminders);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Reminder reminder = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.reminder_cell, parent, false);


        TextView reminderDateTV, reminderTimeTV = null, reminderTitleTV, colouredPriorityBar;
        String reminderDate, reminderTime, reminderTitle, reminderPriority;

//        reminderDateTV = convertView.findViewById(R.id.reminderDateTV);
//        reminderDate = String.valueOf(reminder.getEndDate());
//        reminderDateTV.setText(reminderDate);

//        if (!reminder.isAllDayReminder())
//            reminderTimeTV = convertView.findViewById(R.id.reminderTimeTV);
//            reminderTime = String.valueOf(reminder.getTime());
//            reminderTimeTV.setText(reminderTime);
//
        reminderTitleTV = convertView.findViewById(R.id.reminderTitleTV);
        reminderTitle = String.valueOf(reminder.getTitle());
        reminderTitleTV.setText(reminderTitle);
//
//        colouredPriorityBar = convertView.findViewById(R.id.colouredPriorityBar);
//        reminderPriority = reminder.getPriority();
//        if (reminderPriority.equalsIgnoreCase("low"))
//            colouredPriorityBar.setBackground(Drawable.createFromPath("@drawable/priority_button_sky_blue"));
//        if (reminderPriority.equalsIgnoreCase("moderate"))
//            colouredPriorityBar.setBackground(Drawable.createFromPath("@drawable/priority_button_yellow"));
//        if (reminderPriority.equalsIgnoreCase("high"))
//            colouredPriorityBar.setBackground(Drawable.createFromPath("@drawable/priority_button_red"));

        return convertView;
    }
}

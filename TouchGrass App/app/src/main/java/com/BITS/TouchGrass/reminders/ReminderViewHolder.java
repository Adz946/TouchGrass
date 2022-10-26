package com.BITS.TouchGrass.reminders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.R;
import com.BITS.TouchGrass.calendar.CalendarAdapter;

public class ReminderViewHolder extends RecyclerView.ViewHolder {
    public final TextView reminderDate, reminderTime, reminderTitle;
    public final View reminderPriorityBar;
    public final Button reminderEditBtn;

    public ReminderViewHolder(@NonNull View view) {
        super(view);
        reminderDate = (TextView) view.findViewById(R.id.reminderDateTV);
        reminderTime = (TextView) view.findViewById(R.id.reminderTimeTV);
        reminderTitle = (TextView) view.findViewById(R.id.reminderTitleTV);
        reminderEditBtn = (Button) view.findViewById(R.id.edit_reminder_button);
        reminderPriorityBar = (View) view.findViewById(R.id.colouredPriorityBar);
    }
}

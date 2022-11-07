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
        reminderDate = view.findViewById(R.id.reminderDateTV);
        reminderTime = view.findViewById(R.id.reminderTimeTV);
        reminderTitle = view.findViewById(R.id.reminderTitleTV);
        reminderEditBtn = view.findViewById(R.id.edit_reminder_button);
        reminderPriorityBar = view.findViewById(R.id.colouredPriorityBar);
    }
}

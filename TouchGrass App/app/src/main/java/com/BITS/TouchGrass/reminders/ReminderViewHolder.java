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
    public final View view;

    public ReminderViewHolder(@NonNull View itemView) {
        super(itemView);
        reminderDate = itemView.findViewById(R.id.reminderDateTV);
        reminderTime = itemView.findViewById(R.id.reminderTimeTV);
        reminderTitle = itemView.findViewById(R.id.reminderTitleTV);
        reminderEditBtn = itemView.findViewById(R.id.edit_reminder_button);
        reminderPriorityBar = itemView.findViewById(R.id.colouredPriorityBar);
//        reminderEditBtn.setOnClickListener(this::onClick);
        view = itemView;
    }

//    @Override
//    public void onClick(View v) {
//        onItemListener.onItemClick(getAdapterPosition(), (String) date.getText(), (String) time.getText(), (String) title.getText(), (View) priorityBar);
//    }
}

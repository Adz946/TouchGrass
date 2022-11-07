package com.BITS.TouchGrass.reminders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.R;

import java.util.ArrayList;

class GroupReminderAdapter extends RecyclerView.Adapter<ReminderViewHolder> {

    private final ArrayList<GroupReminder> currentReminders;
    Context context;

    public GroupReminderAdapter(Context context, ArrayList<GroupReminder> currentReminders) {
        this.context = context;
        this.currentReminders = currentReminders;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.reminder_cell, parent, false);

        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        Reminder currentReminder = this.currentReminders.get(position);
        holder.reminderDate.setText(currentReminder.getEndDate().toString());
        holder.reminderTime.setText(currentReminder.getTime().toString());
        holder.reminderTitle.setText(currentReminder.getTitle());
        holder.reminderPriorityBar.setBackground(getPriorityColor(currentReminder));
    }

    private Drawable getPriorityColor(Reminder currentReminder) {
        String priority = currentReminder.getPriority();
        switch (priority) {
            case "low":
                return Drawable.createFromPath(String.valueOf(R.drawable.priority_button_blue));
            case "moderate":
                return Drawable.createFromPath(String.valueOf(R.drawable.priority_button_yellow));
            case "high":
                return Drawable.createFromPath(String.valueOf(R.drawable.priority_button_red));
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return currentReminders.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
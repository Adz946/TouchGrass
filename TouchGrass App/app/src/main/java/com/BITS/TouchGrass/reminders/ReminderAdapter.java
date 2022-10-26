package com.BITS.TouchGrass.reminders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.R;

import java.util.ArrayList;

class ReminderAdapter extends RecyclerView.Adapter<ReminderViewHolder> {

    private final ArrayList<Reminder> currentReminders;
    Context context;

    public ReminderAdapter(Context context, ArrayList<Reminder> currentReminders) {
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
        holder.reminderDate.setText(currentReminder.getNextDate().toString());
        holder.reminderTime.setText(currentReminder.getTime().toString());
        holder.reminderTitle.setText(currentReminder.getTitle());
        holder.reminderPriorityBar.setBackgroundColor(currentReminder.getPriority());
        holder.reminderEditBtn.setText("Buttone");
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
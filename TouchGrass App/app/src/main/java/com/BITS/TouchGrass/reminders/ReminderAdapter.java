package com.BITS.TouchGrass.reminders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.R;

import java.util.ArrayList;

class ReminderAdapter extends RecyclerView.Adapter<ReminderViewHolder> {


    private final ArrayList<Reminder> remindersData;


    public ReminderAdapter(ArrayList<Reminder> remindersData) {
        this.remindersData = remindersData;
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
        int index = holder.getAdapterPosition();
        Reminder currentReminder = remindersData.get(position);
        holder.reminderDate.setText(currentReminder.getNextDate().toString());
        holder.reminderTime.setText(currentReminder.getTime().toString());
        holder.reminderTitle.setText(currentReminder.getTitle());
        holder.reminderPriorityBar.setBackground(currentReminder.getPriority());
        holder.reminderEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to edit reminder, but with all the details filled in.
            }
        });
    }


    @Override
    public int getItemCount() {
        return remindersData.size();
    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
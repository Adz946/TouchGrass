package com.BITS.TouchGrass.challenges;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.R;

import java.util.ArrayList;

public class CompletedChallengesAdapter extends RecyclerView.Adapter<CompletedChallengesAdapter.CompletedViewHolder> {

    ArrayList<Challenge> completedChallengesList;
    Context context;

    public CompletedChallengesAdapter(Context context, ArrayList<Challenge> completedChallengesList) {
        this.completedChallengesList = completedChallengesList;
        this.context = context;
    }

    public class CompletedViewHolder extends RecyclerView.ViewHolder {

        TextView titleTV;

        public CompletedViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.completed_challenge_title);
        }
    }


    @NonNull
    @Override
    public CompletedChallengesAdapter.CompletedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.previous_challenge_cell,parent,false);

        return new CompletedChallengesAdapter.CompletedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompletedChallengesAdapter.CompletedViewHolder holder, int position) {

        holder.titleTV.setText(completedChallengesList.get(position).getTitle());
        // move the progress bar
    }

    @Override
    public int getItemCount() {
        return completedChallengesList.size();
    }
}



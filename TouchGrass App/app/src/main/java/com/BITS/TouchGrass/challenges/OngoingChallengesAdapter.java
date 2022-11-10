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

public class OngoingChallengesAdapter extends RecyclerView.Adapter<OngoingChallengesAdapter.OngoingViewHolder> {

    ArrayList<Challenge> ongoingChallengesList;
    Context context;

    public OngoingChallengesAdapter(Context context, ArrayList<Challenge> ongoingChallengesList) {
        this.ongoingChallengesList = ongoingChallengesList;
        this.context = context;
    }

    public class OngoingViewHolder extends RecyclerView.ViewHolder {

        Button doneBtn;
        TextView titleTV;
        ProgressBar progressBar;

        public OngoingViewHolder(@NonNull View itemView) {
            super(itemView);
            doneBtn = itemView.findViewById(R.id.done_button);
            titleTV = itemView.findViewById(R.id.challenge_title);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }


    @NonNull
    @Override
    public OngoingChallengesAdapter.OngoingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.current_challenge_cell,parent,false);

        return new OngoingChallengesAdapter.OngoingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingChallengesAdapter.OngoingViewHolder holder, int position) {

        holder.titleTV.setText(ongoingChallengesList.get(position).getTitle());
        // move the progress bar
    }

    @Override
    public int getItemCount() {
        return ongoingChallengesList.size();
    }
}



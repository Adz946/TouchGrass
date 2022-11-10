package com.BITS.TouchGrass.challenges;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.R;

import java.util.ArrayList;

public class IncomingChallengesAdapter extends RecyclerView.Adapter<IncomingChallengesAdapter.IncomingViewHolder> {

    ArrayList<Challenge> incomingChallengesList;
    Context context;

    public IncomingChallengesAdapter(Context context, ArrayList<Challenge> incomingChallengesList) {
        this.incomingChallengesList = incomingChallengesList;
        this.context = context;
    }

    public class IncomingViewHolder extends RecyclerView.ViewHolder {

        Button acceptBtn, rejectBtn;
        TextView titleTV;

        public IncomingViewHolder(@NonNull View itemView) {
            super(itemView);
            acceptBtn = itemView.findViewById(R.id.challenge_accept);
            rejectBtn = itemView.findViewById(R.id.challenge_reject);
            titleTV = itemView.findViewById(R.id.challenge_title_TV);
        }
    }


    @NonNull
    @Override
    public IncomingChallengesAdapter.IncomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incoming_challenge_cell,parent,false);

        return new IncomingChallengesAdapter.IncomingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomingChallengesAdapter.IncomingViewHolder holder, int position) {

        holder.titleTV.setText(incomingChallengesList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return incomingChallengesList.size();
    }
}


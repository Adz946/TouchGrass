package com.BITS.TouchGrass.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<User> friendsList;
    Context context;


    public RecycleViewAdapter(List<User> friendsList, Context context) {
        this.friendsList = friendsList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView friendImg;
        TextView friendName;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            friendImg = itemView.findViewById(R.id.imgFriend);
            friendName = itemView.findViewById(R.id.friendName);
        }
    }


    @NonNull
    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.totally_not_stolen_friend_cell,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder holder, int position) {

        holder.friendName.setText(friendsList.get(position).getName());
        holder.friendImg.setImageResource(R.drawable.ic_profile_black);
        //Glide.with(this.context).load(friendsList.get(position).getProfileImg()).into(holder.friendImg);
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }
}

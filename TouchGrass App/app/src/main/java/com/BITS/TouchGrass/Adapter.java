package com.BITS.TouchGrass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.theViewHolder> {

    private final String type;
    private final Context con;

    public static class theViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView txt;
        private final Button btn;

        public theViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);
            btn = itemView.findViewById(R.id.btn);
        }
    }

    public Adapter(String type, Context con) {
        this.type = type;
        this.con = con;
    }

    @NonNull
    @Override
    public Adapter.theViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new Adapter.theViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull theViewHolder holder, int position) {
        Thread thread = new Thread(() -> {

            if (type.equals("friends")) {
                ObjectClasses.User friend = MainActivity.loggedUser.getFriends().get(position);

                holder.img.setImageResource( findData( con, friend.getImage() ) );
                holder.txt.setText( friend.getUsername() );
                holder.btn.setText(R.string.friendText);
                holder.btn.setOnClickListener( v -> holder.btn.setText("Pressed") );
            }

            else if (type.equals("reminders")) {
                Log.d("bindData Message", "This is for the list of reminders");
            }
        });
        thread.start();
    }

    public int findData(Context context, String data) {
        return con.getResources().getIdentifier(
                "drawable/" + data, null, context.getPackageName());
    }

    @Override
    public int getItemCount() {
        int i = 0;

        if (this.type.equals("friends")) { i = MainActivity.loggedUser.getFriends().size(); }
        else if (this.type.equals("reminders")) { i = ObjectClasses.reminders.size(); }

        return i;
    }
}

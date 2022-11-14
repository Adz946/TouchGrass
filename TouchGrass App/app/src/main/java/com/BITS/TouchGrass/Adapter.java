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

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    private final String type;
    private final Context con;

    public static class myViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView txt;
        private final Button btn;

        public myViewHolder(@NonNull View itemView) {
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
    public Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context con = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new Adapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Thread thread = new Thread(() -> {
            if (type.equals("friends")) {
                addFriends(holder);
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

    public void addFriends(myViewHolder holder) {
        int i = 0;

        while (i < MainActivity.loggedUser.getFriends().size()) {
            Log.d("Friend Name", MainActivity.loggedUser.getFriends().get(i));

            holder.img.setImageResource( findData( con, "idk" ) );
            holder.txt.setText( MainActivity.loggedUser.getFriends().get(i) );
            holder.btn.setText(R.string.friendText);
            holder.btn.setOnClickListener( v -> holder.btn.setText("Pressed") );

            i += 1;
        }
    }

    @Override
    public int getItemCount() {
        int i = 0;

        if (this.type.equals("friends")) { i = ObjectClasses.users.size(); }
        else if (this.type.equals("reminders")) { i = ObjectClasses.reminders.size(); }

        return i;
    }
}

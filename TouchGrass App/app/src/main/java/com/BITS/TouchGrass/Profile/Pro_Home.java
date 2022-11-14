package com.BITS.TouchGrass.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.BITS.TouchGrass.*;
import com.BITS.TouchGrass.databinding.ProHomeLayoutBinding;

public class Pro_Home extends Fragment {

    RecyclerView rec;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProHomeLayoutBinding binding = ProHomeLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        int i = 0;

        while (i < MainActivity.loggedUser.getFriends().size()) {
            String friend = MainActivity.loggedUser.getFriends().get(i);
            Log.d("Friend --", "-- " + friend);
            i += 1;
        }

        rec = view.findViewById(R.id.friendList);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        Adapter adapter = new Adapter("friends", getContext());
        rec.setAdapter(adapter);
    }
}
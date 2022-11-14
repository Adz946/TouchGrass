package com.BITS.TouchGrass.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.BITS.TouchGrass.*;
import com.BITS.TouchGrass.Adapter;
import com.BITS.TouchGrass.databinding.ProHomeLayoutBinding;

public class Pro_Home extends Fragment {

    RecyclerView rec;
    Button button;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProHomeLayoutBinding binding = ProHomeLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        button = view.findViewById(R.id.logOut_button);
        button.setOnClickListener(v -> {
           MainActivity.loggedUser = null;
            NavHostFragment.findNavController(Pro_Home.this).navigate(R.id.profile_logIn);
        });
        feedRecycler(view);
    }

    public void feedRecycler(View view) {
        if (MainActivity.loggedUser != null) {
            int i = 0;

            rec = view.findViewById(R.id.friendList);
            rec.setLayoutManager(new LinearLayoutManager(getContext()));
            Adapter adapter = new Adapter("friends", getContext());
            rec.setAdapter(adapter);
        }
    }
}
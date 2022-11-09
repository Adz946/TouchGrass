package com.BITS.TouchGrass.challenges;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.BITS.TouchGrass.R;

public class ChallengesMainFragment extends Fragment {

    Button createChallengeBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenges_main, container, false);

        initWidgets(view);

        return view;
    }

    private void initWidgets(View view) {
        createChallengeBtn = view.findViewById(R.id.btnCreateChallenge);
    }
}
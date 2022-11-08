package com.BITS.TouchGrass.challenges;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.BITS.TouchGrass.R;

public class ChallengeCreateFragment extends Fragment {

    Button setTime, startDate, endDate, addFriendsBtn, createChallengeBtn, cancelBtn, mon, tue, wed, thu, fri, sat, sun;
    EditText challengeNameET;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenge_create, container, false);

        initWidgets(view);

        return view;
    }


    private void initWidgets(View view) {
        mon = view.findViewById(R.id.btnMon);
        tue = view.findViewById(R.id.btnTue);
        wed = view.findViewById(R.id.btnWed);
        thu = view.findViewById(R.id.btnThu);
        fri = view.findViewById(R.id.btnFri);
        sat = view.findViewById(R.id.btnSat);
        sun = view.findViewById(R.id.btnSun);
        setTime = view.findViewById(R.id.btnSetTime);
        startDate = view.findViewById(R.id.btnStartDate);
        endDate = view.findViewById(R.id.btnEndDate);
        createChallengeBtn = view.findViewById(R.id.btnCreateChallenge);
        challengeNameET = view.findViewById(R.id.EnterChallengeName);
    }
}
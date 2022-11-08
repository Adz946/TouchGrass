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

    Button SetTime, StartDate, EndDate, AddFriendsButton, CreateChallengeButton, Cancel, Mon, Tue, Wed, Thu, Fri, Sat, Sun;
    EditText EnterChallengeName;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Mon = (Button) view.findViewById(R.id.btnMon);
        Tue = (Button) view.findViewById(R.id.btnTue);
        Wed = (Button) view.findViewById(R.id.btnWed);
        Thu = (Button) view.findViewById(R.id.btnThu);
        Fri = (Button) view.findViewById(R.id.btnFri);
        Sat = (Button) view.findViewById(R.id.btnSat);
        Sun = (Button) view.findViewById(R.id.btnSun);
        SetTime = (Button) view.findViewById(R.id.btnSetTime);
        StartDate = (Button) getView().findViewById(R.id.btnStartDate);
        EndDate = (Button) getView().findViewById(R.id.btnEndDate);
        CreateChallengeButton = (Button) view.findViewById(R.id.btnCreateChallenge);
        EnterChallengeName = (EditText) view.findViewById(R.id.EnterChallengeName);

        return inflater.inflate(R.layout.fragment_challenge_create, container, false);
    }
}
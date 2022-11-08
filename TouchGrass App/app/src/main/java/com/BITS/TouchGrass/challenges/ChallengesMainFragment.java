package com.BITS.TouchGrass.challenges;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.BITS.TouchGrass.R;

public class ChallengesMainFragment extends Fragment {

    View view;
    Button CreateChallengeButton, AcceptButton, RejectButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenges_main, container, false);

        // Create the page here, and methods referring to the built page +assets on it are
        // referenced using 'view.'

        CreateChallengeButton = (Button) view.findViewById(R.id.btnCreateChallenge);
        AcceptButton = (Button) view.findViewById(R.id.btnAccept);
        RejectButton = (Button) view.findViewById(R.id.btnReject);
        return view;
    }
}
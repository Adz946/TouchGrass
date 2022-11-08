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

    View view;
    Button CreateChallengeButton, AcceptButton, RejectButton, Mon, Tue, Wed, Thu, Fri, Sat, Sun;
    EditText EnterChallengeName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenges_main, container, false);

        // Create the page here, and methods referring to the built page +assets on it are
        // referenced using 'view.'

        //Buttons
        CreateChallengeButton = (Button) view.findViewById(R.id.btnCreateChallenge);
        AcceptButton = (Button) view.findViewById(R.id.btnAccept);
        RejectButton = (Button) view.findViewById(R.id.btnReject);
        Mon = (Button) view.findViewById(R.id.btnMon);
        Tue = (Button) view.findViewById(R.id.btnTue);
        Wed = (Button) view.findViewById(R.id.btnWed);
        Thu = (Button) view.findViewById(R.id.btnThu);
        Fri = (Button) view.findViewById(R.id.btnFri);
        Sat = (Button) view.findViewById(R.id.btnSat);
        Sun = (Button) view.findViewById(R.id.btnSun);

        EnterChallengeName = (EditText) view.findViewById(R.id.EnterChallengeName);
        return view;
    }
}
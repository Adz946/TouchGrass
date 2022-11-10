package com.BITS.TouchGrass.challenges;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.BITS.TouchGrass.R;

public class ChallengesMainFragment extends Fragment {

    Button createChallengeBtn;

    private final ChallengeCreateFragment fragment_challenge_create = new ChallengeCreateFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenges_main, container, false);

        initWidgets(view);

        return view;
    }

    private void initWidgets(View view) {
        createChallengeBtn = view.findViewById(R.id.btnCreateChallenge);
        setListeners();
    }

    private void setListeners () {
        createChallengeBtn.setOnClickListener(v -> {
            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.flFragment, fragment_challenge_create);
            fr.addToBackStack("challenge");
            fr.commit();
        });
    }
}
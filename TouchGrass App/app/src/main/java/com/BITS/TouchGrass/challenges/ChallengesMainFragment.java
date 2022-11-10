package com.BITS.TouchGrass.challenges;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.BITS.TouchGrass.R;

import java.util.ArrayList;

public class ChallengesMainFragment extends Fragment {

    Button createChallengeBtn;
    RecyclerView incomingChallengesRV, ongoingChallengesRV, completedChallengesRV;

    private final ChallengeCreateFragment fragment_challenge_create = new ChallengeCreateFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenges_main, container, false);

        initWidgets(view);
        setChallengesAdapter();

        return view;
    }

    private void initWidgets(View view) {
        createChallengeBtn = view.findViewById(R.id.btnCreateChallenge);
        incomingChallengesRV = view.findViewById(R.id.incoming_challenge_RV);
        ongoingChallengesRV = view.findViewById(R.id.ongoing_challenge_RV);
        completedChallengesRV = view.findViewById(R.id.completed_challenge_RV);
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

    @Override
    public void onResume() {
        super.onResume();
        setChallengesAdapter();
    }

    public void setChallengesAdapter() {

        ArrayList<Challenge> incomingChallenges = new ArrayList<>();
        ArrayList<Challenge> ongoingChallenges = new ArrayList<>();
        ArrayList<Challenge> completedChallenges = new ArrayList<>();

        for (Challenge challenge : Challenge.challengesList) {
            if (challenge.type.equals("incoming")) {
                incomingChallenges.add(challenge);
            }
            if (challenge.type.equals("ongoing")) {
                ongoingChallenges.add(challenge);
            }
            if (challenge.type.equals("completed")) {
                completedChallenges.add(challenge);
            }
        }

        LinearLayoutManager incomingLayoutManager = new LinearLayoutManager(getContext());
        incomingChallengesRV.setLayoutManager(incomingLayoutManager);

        LinearLayoutManager ongoingLayoutManager = new LinearLayoutManager(getContext());
        ongoingChallengesRV.setLayoutManager(ongoingLayoutManager);

        LinearLayoutManager completedLayoutManager = new LinearLayoutManager(getContext());
        completedChallengesRV.setLayoutManager(completedLayoutManager);

        IncomingChallengesAdapter incomingChallengesAdapter = new IncomingChallengesAdapter(
                requireActivity().getApplicationContext(), incomingChallenges);
        OngoingChallengesAdapter ongoingChallengesAdapter = new OngoingChallengesAdapter(
                requireActivity().getApplicationContext(), ongoingChallenges);
        CompletedChallengesAdapter completedChallengesAdapter = new CompletedChallengesAdapter(
                requireActivity().getApplicationContext(), completedChallenges);

        incomingChallengesRV.setAdapter(incomingChallengesAdapter);
        ongoingChallengesRV.setAdapter(ongoingChallengesAdapter);
        completedChallengesRV.setAdapter(completedChallengesAdapter);
    }
}
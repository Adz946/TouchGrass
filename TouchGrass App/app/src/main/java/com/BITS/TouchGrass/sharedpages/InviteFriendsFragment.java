package com.BITS.TouchGrass.sharedpages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.BITS.TouchGrass.R;

public class InviteFriendsFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invite_friends, container, false);

        // Create the page here, and methods referring to the built page +assets on it are
        // referenced using 'view.'

        return view;
    }
}
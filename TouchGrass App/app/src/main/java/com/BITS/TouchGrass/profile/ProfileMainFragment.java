package com.BITS.TouchGrass.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.BITS.TouchGrass.R;

public class ProfileMainFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_main, container, false);

        // Create the page here, and methods referring to the built page +assets on it are
        // referenced using 'view.'

        return view;
    }
}
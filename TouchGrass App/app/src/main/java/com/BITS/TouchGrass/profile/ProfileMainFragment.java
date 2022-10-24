package com.BITS.TouchGrass.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.BITS.TouchGrass.R;

public class ProfileMainFragment extends Fragment implements View.OnClickListener {
    Button myButton;
    View myView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_profile_main, container, false);
        myButton = (Button) myView.findViewById(R.id.btnLogin);
        myButton.setOnClickListener(this);
        // Inflate the layout for this fragment

       
    }
}
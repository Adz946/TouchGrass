package com.BITS.TouchGrass.sharedpages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.BITS.TouchGrass.R;

public class InviteFriendsFragment extends Fragment {

    Button inviteBtn, cancelBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invite_friends, container, false);

        // Create the page here, and methods referring to the built page +assets on it are
        // referenced using 'view.'
        initWidgets(view);

        setListeners();

        return view;
    }


    private void initWidgets(View view) {
        inviteBtn = view.findViewById(R.id.invite_friends_button);
        cancelBtn = view.findViewById(R.id.cancel_button);
    }


    private void setListeners() {
        cancelBtn.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });
    }
}
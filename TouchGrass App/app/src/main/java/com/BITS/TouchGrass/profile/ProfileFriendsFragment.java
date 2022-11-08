package com.BITS.TouchGrass.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.BITS.TouchGrass.MainActivity;
import com.BITS.TouchGrass.R;


public class ProfileFriendsFragment extends Fragment {

    View view;
    Button logoutBtn, addFriendBtn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile_friends, container, false);

        logoutBtn = (Button) view.findViewById(R.id.logout);
        addFriendBtn = (Button) view.findViewById(R.id.addFriend);

        setListeners();

        return view;

    }

    public void setListeners() {

        logoutBtn.setOnClickListener(v -> {

            MainActivity.logout();
            getParentFragmentManager().popBackStack();
            Toast.makeText(getContext(), "You have logged out ", Toast.LENGTH_SHORT).show();
        });

    }


}

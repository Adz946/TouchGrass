package com.BITS.TouchGrass.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.BITS.TouchGrass.MainActivity;
import com.BITS.TouchGrass.R;

import java.util.ArrayList;
import java.util.List;


public class ProfileFriendsFragment extends Fragment {

    View view;
    Button logoutBtn, addFriendBtn;
    TextView searchUser;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile_friends, container, false);

        initWidgets(view);

        setListeners();

        return view;

    }

    private void initWidgets(View view) {
        logoutBtn = (Button) view.findViewById(R.id.logout);
        addFriendBtn = (Button) view.findViewById(R.id.addFriend);
        searchUser = (TextView) view.findViewById(R.id.searchUser);
    }


    public void setListeners() {

        logoutBtn.setOnClickListener(v -> {
            MainActivity.logout();
            getParentFragmentManager().popBackStack();
            Toast.makeText(getContext(), "You have logged out ", Toast.LENGTH_SHORT).show();
        });

        addFriendBtn.setOnClickListener(v -> {


            if (alreadyFriend() && !doesNotExist() && !yourself()) {
                Toast.makeText(getContext(), "User is already your friend!!", Toast.LENGTH_SHORT).show();
            } else if (yourself() && !alreadyFriend() && !doesNotExist()) {
                Toast.makeText(getContext(), "You can't add yourself!!", Toast.LENGTH_SHORT).show();
            } else if (doesNotExist() && !yourself() && !alreadyFriend()) {
                Toast.makeText(getContext(), "User does not exist...", Toast.LENGTH_SHORT).show();
            } else if (!(alreadyFriend() && doesNotExist() && yourself())) {
                Toast.makeText(getContext(), searchUser.getText().toString() +" added to your Friends List", Toast.LENGTH_SHORT).show();
                addFriend();
            }

        });

    }

    private void addFriend() {
        for (int i = 0; i < MainActivity.friendsList.size(); i++) {
            if (MainActivity.loggedUser.getName().equalsIgnoreCase(MainActivity.friendsList.get(i).get(0))) {
                MainActivity.friendsList.get(i).add(searchUser.getText().toString());
                break;
            }
        }
        for (int j = 0; j < MainActivity.friendsList.size(); j++) {
            if (searchUser.getText().toString().equalsIgnoreCase(MainActivity.friendsList.get(j).get(0))) {
                MainActivity.friendsList.get(j).add(MainActivity.loggedUser.getName());
                break;
            }
        }
    }

    private boolean alreadyFriend() {
        List<String> temp;
        boolean alreadyFriend = false;

        for ( int i = 0; i <MainActivity.friendsList.size(); i++) {
            if (MainActivity.loggedUser.getName().equalsIgnoreCase(MainActivity.friendsList.get(i).get(0))) {
                temp = MainActivity.friendsList.get(i);
                for(int k = 1; k < temp.size(); k ++) {
                    if (searchUser.getText().toString().equalsIgnoreCase(temp.get(k))) {
                        alreadyFriend = true;
                    }
                }
            }
        }
        return alreadyFriend;
    }

    private boolean doesNotExist() {
        boolean noMatch = true;
        for (int i = 0; i < MainActivity.users.size(); i++) {
            if (searchUser.getText().toString().equalsIgnoreCase(MainActivity.users.get(i).getName())) {
                noMatch = false;
            }
        }
        return noMatch;
    }

    private boolean yourself() {
        boolean yourself = false;
        if (searchUser.getText().toString().equalsIgnoreCase(MainActivity.loggedUser.getName())) {
            yourself = true;
        }
        return yourself;
    }
}

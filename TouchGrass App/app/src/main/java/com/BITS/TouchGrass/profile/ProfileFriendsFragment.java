package com.BITS.TouchGrass.profile;

import android.graphics.Color;
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
import java.util.Objects;


public class ProfileFriendsFragment extends Fragment {

    View view;
    Button logoutBtn, addFriendBtn, changeThemeBtn;
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
        changeThemeBtn = view.findViewById(R.id.change_theme_buttone);
    }


    public void setListeners() {

        logoutBtn.setOnClickListener(v -> {
            MainActivity.logout();
            getParentFragmentManager().popBackStack();
            Toast.makeText(getContext(), "You have logged out ", Toast.LENGTH_SHORT).show();
        });

        addFriendBtn.setOnClickListener(v -> {
            if (alreadyFriend() && exist() && !yourself()) {
                Toast.makeText(getContext(), "User is already your friend!!", Toast.LENGTH_SHORT).show();
            } else if (yourself() && !alreadyFriend() && exist()) {
                Toast.makeText(getContext(), "You can't add yourself!!", Toast.LENGTH_SHORT).show();
            } else if (!exist() && !yourself() && !alreadyFriend()) {
                Toast.makeText(getContext(), "User does not exist...", Toast.LENGTH_SHORT).show();
            } else if (!(alreadyFriend() && !exist() && yourself())) {
                Toast.makeText(getContext(), searchUser.getText().toString() +" added to your Friends List", Toast.LENGTH_SHORT).show();
                addFriend();
            }
        });

        changeThemeBtn.setOnClickListener(v -> {

            Toast.makeText(getContext(), requireActivity().getTheme().toString(),Toast.LENGTH_LONG).show();

//            if (requireActivity().getTheme()==R.style.Theme_TouchGrass_Retro) {
//
//            }

            requireActivity().setTheme(R.style.Theme_TouchGrass_Retro);

            requireActivity().getSupportFragmentManager().beginTransaction().replace(ProfileFriendsFragment.this.getId(), new ProfileFriendsFragment()).commit();
//            ProfileFriendsFragment fragment = (ProfileFriendsFragment) getParentFragmentManager().findFragmentByTag("profile_friends_tag");
//            getParentFragmentManager().beginTransaction().detach(fragment).attach(fragment).commit();

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
                    //Toast.makeText(getContext(), temp.get(k), Toast.LENGTH_SHORT).show();
                    if (searchUser.getText().toString().equalsIgnoreCase(temp.get(k))) {

                        alreadyFriend = true;
                        break;
                    }
                }
            }
        }
        return alreadyFriend;
    }

    private boolean exist() {
        boolean match = false;
        for (int i = 0; i < MainActivity.users.size(); i++) {
            if (searchUser.getText().toString().equalsIgnoreCase(MainActivity.users.get(i).getName())) {
                match = true;
            }
        }
        return match;
    }

    private boolean yourself() {
        // this returns the boolean value 'true' if searchUser == loggedUser.getName()
        return searchUser.getText().toString().equalsIgnoreCase(MainActivity.loggedUser.getName());
    }
}

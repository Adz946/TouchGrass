package com.BITS.TouchGrass.profile;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.MainActivity;
import com.BITS.TouchGrass.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class ProfileFriendsFragment extends Fragment {

    View view;
    Button logoutBtn, addFriendBtn;
    TextView searchUser;
    ImageView profileImg;
    List<User> friendsList = new ArrayList<>();
    User loggedUser;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile_friends, container, false);
        loggedUser = MainActivity.loggedUser;

        initWidgets(view);

        recyclerView = (RecyclerView) view.findViewById(R.id.friendsRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecycleViewAdapter(friendsList, this.getActivity());
        recyclerView.setAdapter(mAdapter);

        //Glide.with(this).load(friendsList.get(MainActivity.loggedUser.getProfileImg()).into(profileImg);

        setFriendsList();
        //setProfileImg();
        setListeners();

        return view;

    }

    private void setFriendsList() {
        List<String> fList = null;
        for (int i = 0; i < MainActivity.friendsList.size(); i++) {
            if (MainActivity.loggedUser.getName().equalsIgnoreCase(MainActivity.friendsList.get(i).get(0))) {
                fList = MainActivity.friendsList.get(i);
                break;
            }
        }
        for (int j = 1; j < fList.size(); j++) {
            for( int k = 0; k < MainActivity.users.size(); k++) {
                if (fList.get(j).strip().equalsIgnoreCase(MainActivity.users.get(k).getName().strip())) {
                    friendsList.add(MainActivity.users.get(k));
                    break;
                }
            }
        }
    }

//    private void setProfileImg() {
//
//        String imageName = MainActivity.loggedUser.getProfileImg().strip();
//        profileImg.setImageResource(R.drawable.clayton);
//
//    }

    private void initWidgets(View view) {
        logoutBtn = (Button) view.findViewById(R.id.logout);
        addFriendBtn = (Button) view.findViewById(R.id.addFriend);
        searchUser = (TextView) view.findViewById(R.id.searchUser);
        profileImg = (ImageView) view.findViewById(R.id.profileImg);

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
                //searchUser.setText("");
            } else if (yourself() && !alreadyFriend() && exist()) {
                Toast.makeText(getContext(), "You can't add yourself!!", Toast.LENGTH_SHORT).show();
                //searchUser.setText("");
            } else if (!exist() && !yourself() && !alreadyFriend()) {
                Toast.makeText(getContext(), "User does not exist...", Toast.LENGTH_SHORT).show();
                //searchUser.setText("");
            } else if (!(alreadyFriend() && !exist() && yourself())) {
                Toast.makeText(getContext(), searchUser.getText().toString() +" added to your Friends List", Toast.LENGTH_SHORT).show();
                //searchUser.setText("");
                addFriend();
            }
            searchUser.setText("");

        });

    }

    private void addFriend() {
        for (int i = 0; i < MainActivity.friendsList.size(); i++) {
            if (MainActivity.loggedUser.getName().equalsIgnoreCase(MainActivity.friendsList.get(i).get(0))) {
                MainActivity.friendsList.get(i).add(searchUser.getText().toString().strip());
                break;
            }
        }
        for (int j = 0; j < MainActivity.friendsList.size(); j++) {
            if (searchUser.getText().toString().strip().equalsIgnoreCase(MainActivity.friendsList.get(j).get(0))) {
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
//                if (temp.contains("adam")) {
//                    alreadyFriend = true;
//                    break;
//                }
                for(int k = 1; k < temp.size(); k ++) {
                    if (searchUser.getText().toString().strip().equalsIgnoreCase(temp.get(k))) {
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
        boolean yourself = false;
        if (searchUser.getText().toString().equalsIgnoreCase(MainActivity.loggedUser.getName())) {
            yourself = true;
        }
        return yourself;
    }
}

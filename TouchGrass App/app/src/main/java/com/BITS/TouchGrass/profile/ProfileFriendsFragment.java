package com.BITS.TouchGrass.profile;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.BITS.TouchGrass.MainActivity;
import com.BITS.TouchGrass.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class ProfileFriendsFragment extends Fragment {

    Button logoutBtn, addFriendBtn;
    Spinner setThemeSpinner;
    TextView searchUser;
    ImageView profileImg;
    ArrayList<User> friendsList = new ArrayList<>();
    User loggedUser;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_friends, container, false);
        this.loggedUser = MainActivity.loggedUser;

        initWidgets(view);

        buildThemeSpinner();

        Glide.with(this).load(this.loggedUser.getProfileImg()).into(profileImg);

        setFriendsList();
        // setProfileImg();
        setListeners();

        selectSpinnerValue(MainActivity.currentTheme);

        setFriendsListAdapter();

        return view;
    }


    private void initWidgets(View view) {
        logoutBtn = view.findViewById(R.id.logout);
        addFriendBtn = view.findViewById(R.id.addFriend);
        searchUser = view.findViewById(R.id.searchUser);
        profileImg = view.findViewById(R.id.profileImg);
        setThemeSpinner = view.findViewById(R.id.change_theme_spinner);
        recyclerView = view.findViewById(R.id.friendsRecycler);
    }


    private void setListeners() {

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
                Toast.makeText(getContext(), searchUser.getText().toString() + " added to your Friends List", Toast.LENGTH_SHORT).show();
                //searchUser.setText("");
                addFriend();
            }
            searchUser.setText("");
        });

        setThemeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                if (!item.equals(MainActivity.currentTheme)) {

//                    String themeName = null;
//
//                    try {
//                        int theme = requireContext().getPackageManager()
//                                .getActivityInfo(requireActivity().getComponentName(), 0)
//                                .getThemeResource();
//                        String fullThemeName = requireContext().getResources().getResourceEntryName(theme);
//                        String[] fields = fullThemeName.split("_");
//                        themeName = fields[1];
//                    } catch (PackageManager.NameNotFoundException e) {
//                        e.printStackTrace();
//                    }
//
//                    if (!item.equals(themeName)) {
                    switch (item) {
                        case "Light":
                            requireContext().setTheme(R.style.Theme_TouchGrass_Light);
                            break;
                        case "Dark":
                            requireContext().setTheme(R.style.Theme_TouchGrass_Dark);
                            break;
                        case "Retro":
                            requireContext().setTheme(R.style.Theme_TouchGrass_Retro);
                            break;
                        case "Christmas":
                            requireContext().setTheme(R.style.Theme_TouchGrass_Christmas);
                            break;
                        case "Colourblind":
                            requireContext().setTheme(R.style.Theme_TouchGrass_Colourblind);
                            break;
                    }
                    MainActivity.currentTheme = item;
                    reloadPage();
//                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void selectSpinnerValue(String string) {
        for (int i = 0; i < setThemeSpinner.getCount(); i++) {
            if (setThemeSpinner.getItemAtPosition(i).toString().equals(string)) {
                setThemeSpinner.setSelection(i);
                break;
            }
        }
    }

//
//    // each time the page is opened, the friends list will update
//    @Override
//    public void onResume() {
//        super.onResume();
//        setFriendsListAdapter();
//    }


    private void setFriendsListAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecycleViewAdapter adapter = new RecycleViewAdapter(friendsList, this.getActivity());
        recyclerView.setAdapter(adapter);
    }


    private void setFriendsList() {
        ArrayList<String> fList = new ArrayList<>();
        ArrayList<User> temp = new ArrayList<>();

        for (int i = 0; i < MainActivity.friendsList.size(); i++) {
            if (MainActivity.loggedUser.getName().equalsIgnoreCase(MainActivity.friendsList.get(i).get(0))) {
                fList = MainActivity.friendsList.get(i);
                break;
            }
        }
        for (int j = 1; j < fList.size(); j++) {
            for (int k = 0; k < MainActivity.users.size(); k++) {
                if (fList.get(j).strip().equalsIgnoreCase(MainActivity.users.get(k).getName().strip())) {
                    temp.add(MainActivity.users.get(k));
                    break;
                }
            }
        }
        friendsList = temp;
    }

//    private void setProfileImg() {
//
//        String imageName = MainActivity.loggedUser.getProfileImg().strip();
//        profileImg.setImageResource(R.drawable.clayton);
//
//    }


    private void reloadPage() {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(ProfileFriendsFragment.this.getId(), new ProfileFriendsFragment())
                .commit();
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
        reloadPage();
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
        // simplified boolean expression
        return searchUser.getText().toString().equalsIgnoreCase(MainActivity.loggedUser.getName());
    }


    private void buildThemeSpinner() {
        // creates an adapter from the spinner template, and applies to our options in 'themes_spinner'
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.themes_spinner, android.R.layout.simple_spinner_item);
        // sets the layout resource
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // applies the adapter to our drop down
        setThemeSpinner.setAdapter(adapter);
    }
}

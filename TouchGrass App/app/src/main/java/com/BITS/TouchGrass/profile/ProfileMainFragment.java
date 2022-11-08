package com.BITS.TouchGrass.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.BITS.TouchGrass.MainActivity;
import com.BITS.TouchGrass.R;
import com.BITS.TouchGrass.reminders.EditReminderFragment;

import java.util.Objects;

public class ProfileMainFragment extends Fragment {

    View view;
    Button logInBtn, registerBtn;
    TextView txtViewErrorMsg;
    EditText editTxtUsername, edtTxtPW;

    private final ProfileRegisterFragment profileRegisterFragment = new ProfileRegisterFragment();
    private final ProfileFriendsFragment profileFriendsFragment = new ProfileFriendsFragment();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile_main, container, false);

        // Initialise all the UI elements
        logInBtn = (Button) view.findViewById(R.id.btnLogin);
        registerBtn = (Button) view.findViewById(R.id.btnRegister);
        txtViewErrorMsg = (TextView) view.findViewById(R.id.txtViewErrorMsg);
        editTxtUsername = (EditText) view.findViewById(R.id.editTxtUsername);
        edtTxtPW = (EditText) view.findViewById(R.id.edtTxtRegPW);

        // Methods to call
        setListeners();

        return view;
    }


    public void setListeners() {

        logInBtn.setOnClickListener(v -> {

            String username = editTxtUsername.getText().toString();
            String password = edtTxtPW.getText().toString();
            boolean noUser = true;

            for (int i = 0; i < MainActivity.users.size(); i++) {
                if (username.equalsIgnoreCase(MainActivity.users.get(i).getName()) &&
                        (password.equals(MainActivity.users.get(i).getPassword()))) {
                    MainActivity.users.get(i).setLoggedIn();
                    noUser = false;
                    MainActivity.loggedUser = MainActivity.users.get(i);
                }
            }


            if (!noUser) {
                  FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                  fr.replace(R.id.flFragment, profileFriendsFragment);
                  fr.addToBackStack(null);
                  fr.commit();
            } else {
                txtViewErrorMsg.setText("Failed! Username or password incorrect" );
            }
        });

        registerBtn.setOnClickListener(v -> {
            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.flFragment, profileRegisterFragment);
            fr.addToBackStack(null);
            fr.commit();
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

//    public void onResume() {
//        super.onResume();
//    }
}
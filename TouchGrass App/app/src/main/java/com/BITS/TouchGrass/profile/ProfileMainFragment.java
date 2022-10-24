package com.BITS.TouchGrass.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.BITS.TouchGrass.R;
import com.BITS.TouchGrass.reminders.EditReminderFragment;

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
            if (editTxtUsername.getText().toString().equalsIgnoreCase("bob") && edtTxtPW.getText().toString().equals("password")) {
                  FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                  fr.replace(R.id.flFragment, profileFriendsFragment);
                  fr.commit();
            } else {
                txtViewErrorMsg.setText("Failed! Username or password incorrect" + edtTxtPW.getText().toString());
            }
        });

        registerBtn.setOnClickListener(v -> {
            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.flFragment, profileRegisterFragment);
            fr.commit();
        });
    }

//    public void onResume() {
//        super.onResume();
//    }
}
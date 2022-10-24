package com.BITS.TouchGrass.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.BITS.TouchGrass.R;


public class ProfileRegisterFragment extends Fragment {

    View view;
    Button btnRegister;
    TextView txtViewErrorMsg;
    EditText edtTxtUsername, edtTxtPW, edtTxtPWConfirm;

    private final ProfileFriendsFragment profileFriendsFragment = new ProfileFriendsFragment();
    //private final ProfileMainFragment profmain = new ProfileMainFragment();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile_register, container, false);

        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        txtViewErrorMsg = (TextView) view.findViewById(R.id.txtViewErrorMsg);
        edtTxtUsername = (EditText) view.findViewById(R.id.editTxtUsername);
        edtTxtPW = (EditText) view.findViewById(R.id.edtTxtRegPW);
        edtTxtPWConfirm = (EditText) view.findViewById(R.id.edtTxtRegPWConfirm);

        setListeners();

        return view;

    }

    private void setListeners() {

        btnRegister.setOnClickListener(v -> {
            if (!edtTxtUsername.getText().toString().equalsIgnoreCase("bob") && edtTxtPW.getText().toString().equals(edtTxtPWConfirm.getText().toString())) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.flFragment, profileFriendsFragment);
                fr.commit();
                txtViewErrorMsg.setText("Success!");
            }
            else if (!edtTxtPW.getText().toString().equals(edtTxtPWConfirm.getText().toString())) {
                txtViewErrorMsg.setText("password and password confirmation mismatch...");

            }
            else {
                txtViewErrorMsg.setText("Username already in use...");
            }
        });
    }


}

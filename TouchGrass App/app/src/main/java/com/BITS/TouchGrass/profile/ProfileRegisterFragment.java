package com.BITS.TouchGrass.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.BITS.TouchGrass.R;

public class ProfileRegisterFragment extends Fragment {

    Button btnRegister, returnToLoginBtn;
    TextView txtViewErrorMsg;
    EditText edtTxtUsername, edtTxtPW, edtTxtPWConfirm;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_register, container, false);

        initWidgets(view);
        setListeners();

        return view;
    }


    private void initWidgets(View view) {
        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        txtViewErrorMsg = (TextView) view.findViewById(R.id.txtViewErrorMsg);
        edtTxtUsername = (EditText) view.findViewById(R.id.editTxtUsername);
        edtTxtPW = (EditText) view.findViewById(R.id.edtTxtRegPW);
        edtTxtPWConfirm = (EditText) view.findViewById(R.id.edtTxtRegPWConfirm);
        returnToLoginBtn = (Button) view.findViewById(R.id.btnReturnToLogin);
    }


    private void setListeners() {

        btnRegister.setOnClickListener(v -> {

            // first if should check if username is in use: 'edtTxtUsername.isInUse()'

            // checks to see if username is in use
            if (edtTxtUsername.getText().toString().equalsIgnoreCase("bob")) {
                txtViewErrorMsg.setText("Username already in use...");

            // checks to see if username is empty
            } else if (edtTxtUsername.getText().length() == 0) {
                txtViewErrorMsg.setText("Cannot have an empty username...");

            // checks to see if password 1 is empty
            } else if (edtTxtPW.getText().length() == 0) {
                txtViewErrorMsg.setText("Cannot have an empty password...");

            // checks to see if passwords match
            } else if (!edtTxtPW.getText().toString().equals(edtTxtPWConfirm.getText().toString())) {
                txtViewErrorMsg.setText("Passwords do not match...");

            // if none of the previous clauses raise an error, proceed to create account
            } else {
                // add account to the database, and pop stack back to the login screen
                // database.addUser(edtTxtUsername,edtTxtPW);
                getParentFragmentManager().popBackStack();
                Toast.makeText(getContext(), "Account created! Welcome "
                        + edtTxtUsername.getText() + ".", Toast.LENGTH_LONG).show();

            }
        });

        returnToLoginBtn.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();  // go back to profile_main/login_screen
        });
    }
}

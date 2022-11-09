package com.BITS.TouchGrass.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.BITS.TouchGrass.MainActivity;
import com.BITS.TouchGrass.R;

import java.io.FileOutputStream;

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
        btnRegister = view.findViewById(R.id.btnRegister);
        txtViewErrorMsg = view.findViewById(R.id.txtViewErrorMsg);
        edtTxtUsername = view.findViewById(R.id.editTxtUsername);
        edtTxtPW = view.findViewById(R.id.edtTxtRegPW);
        edtTxtPWConfirm = view.findViewById(R.id.edtTxtRegPWConfirm);
        returnToLoginBtn = view.findViewById(R.id.btnReturnToLogin);
    }


    private void setListeners() {

        btnRegister.setOnClickListener(v -> {

            // first if should check if username is in use: 'edtTxtUsername.isInUse()'
            String username = edtTxtUsername.getText().toString().strip();
            String password = edtTxtPW.getText().toString().strip();
            String passwordConfirm = edtTxtPWConfirm.getText().toString().strip();
            boolean exists = false;

            for (int i = 0; i < MainActivity.users.size(); i++) {
                if (username.equalsIgnoreCase(MainActivity.users.get(i).getName())) {
                    exists = true;
                }
            }

            // checks to see if username is in use
            if (exists) {
                txtViewErrorMsg.setText("Username already in use...");

            // checks to see if username is empty
            } else if (username.length() < 3) {
                txtViewErrorMsg.setText("Username must be greater than 3 characters...");

            // checks to see if password 1 is empty
            } else if (password.length() < 5) {
                txtViewErrorMsg.setText("Password must be greater than 5 characters...");

            // checks to see if passwords match
            } else if (!password.equals(passwordConfirm)) {
                txtViewErrorMsg.setText("Passwords do not match...");

            // if none of the previous clauses raise an error, proceed to create account
            } else {
                // add account to the database, and pop stack back to the login screen
                // database.addUser(edtTxtUsername,edtTxtPW);
                User user = new User(username, password);
                MainActivity.users.add(user);

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

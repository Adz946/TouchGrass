package com.BITS.TouchGrass.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.BITS.TouchGrass.R;

public class ProfileMainFragment extends Fragment implements View.OnClickListener {
    Button myButton;
    View myView;

    public ProfileMainFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_profile_main, container, false);
        myButton = (Button) myView.findViewById(R.id.btnLogin);
        myButton.setOnClickListener(this);
        // Inflate the layout for this fragment
        return myView;

    }

//    public void onLoginBtnClick (View view) {
//
//        TextView txtViewErrorMsg = getView().findViewById(R.id.txtViewErrorMsg);
//
//        EditText editTxtUsername = getView().findViewById(R.id.editTxtUsername);
//        EditText edtTxtPW = getView().findViewById(R.id.edtTxtRegPW);
//
//        if (editTxtUsername.getText().toString().equalsIgnoreCase("bob")) {
//            txtViewErrorMsg.setText("Success!");
//        } else {
//            txtViewErrorMsg.setText ("Failed!");
//        }
//        txtViewErrorMsg.setText("Username is..." + editTxtUsername.getText().toString());
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                TextView txtViewErrorMsg = getView().findViewById(R.id.txtViewErrorMsg);
                EditText editTxtUsername = getView().findViewById(R.id.editTxtUsername);
                EditText edtTxtPW = getView().findViewById(R.id.edtTxtRegPW);

                if (editTxtUsername.getText().toString().equalsIgnoreCase("bob")) {
                    txtViewErrorMsg.setText("Success! WEENER!");
                } else {
                    txtViewErrorMsg.setText("Failed! YOU SUCC");
                }
                break;
        }
    }
}
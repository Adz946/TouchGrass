package com.BITS.TouchGrass.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.BITS.TouchGrass.R;

public class ProfileMainFragment extends Fragment {

    public ProfileMainFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_main, container, false);
    }

    public void onLoginBtnClick (View view) {

        TextView txtViewErrorMsg = getView().findViewById(R.id.txtViewErrorMsg);

        EditText editTxtUsername = getView().findViewById(R.id.editTxtUsername);
        EditText edtTxtPW = getView().findViewById(R.id.edtTxtRegPW);

        if (editTxtUsername.getText().toString().equalsIgnoreCase("bob")) {
            txtViewErrorMsg.setText("Success!");
        } else {
            txtViewErrorMsg.setText ("Failed!");
        }
        txtViewErrorMsg.setText("Username is..." + editTxtUsername.getText().toString());

    }
}
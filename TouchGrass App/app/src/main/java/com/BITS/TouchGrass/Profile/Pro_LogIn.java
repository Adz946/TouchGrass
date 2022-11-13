package com.BITS.TouchGrass.Profile;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.BITS.TouchGrass.*;
import com.BITS.TouchGrass.databinding.ProLogInLayoutBinding;

public class Pro_LogIn extends Fragment {

    EditText username, password;
    TextView uError, pError;
    Button button;

    static boolean check;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProLogInLayoutBinding binding = ProLogInLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        username = view.findViewById(R.id.user);
        password = view.findViewById(R.id.pass);
        uError = view.findViewById(R.id.userError);
        pError = view.findViewById(R.id.passError);
        button = view.findViewById(R.id.logIn_button);

        button.setOnClickListener(v -> {
            checkDetails();

            if (check) {
                NavHostFragment.findNavController(Pro_LogIn.this).navigate(R.id.profile_home);
            }
        });
    }

    public void checkDetails() {
        check = false;
        int i = 0;

        boolean userCheck = false;
        boolean passCheck = false;
        uError.setText("");
        pError.setText("");

        while (i < ObjectClasses.users.size()) {
            ObjectClasses.User user = ObjectClasses.users.get(i);
            String name = username.getText().toString();
            String pass = password.getText().toString();

            if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
                user.setLoggedIn(true); check = true; }

            if (!userCheck && user.getUsername().equals(name)) { userCheck = true; }
            else if (!userCheck && !user.getUsername().equals(name)) {
                uError.setText(R.string.logUser); }

            if (!passCheck && user.getPassword().equals(pass)) { passCheck = true; }
            else if (!passCheck && !user.getPassword().equals(pass)) {
                pError.setText(R.string.logPass); }

            i += 1;
        }
    }
}
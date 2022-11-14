package com.BITS.TouchGrass;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bView;
    //Creates a BottomNavView variable

    public static WeakReference<MainActivity> reference;
    public static MainActivity getReference() {
        return reference.get();
    }
    //These allow the MainActivity's Context/Assets/etc. to be used with no memory leaks
    //  to be used in Java classes (FileReader / Adapter / etc.)

    FileReader reader = new FileReader();
    public static WeakReference<FileReader> fileReader;
    //Creates a reference to the FileReader file without memory leaks

    public static ObjectClasses.User loggedUser;
    //Sets up the loggedIn user to use throughout the fragments


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Normal onCreate attributes

        reference = new WeakReference<>(MainActivity.this);
        //Creates a reference to use in other classes (e.g. Methods)

        fileReader = new WeakReference<>(reader);
        fileReader.get().prepLists();
        //The following are methods from the fileReader class, reads from the individual files
        //  and gets each list ready to use.

        //------------------------------------------------------------------------------------------
        //START ActionBar

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_top_bar);
        //The "ActionBar" normally just shows the title of the app
        //By using these 3 settings, anyone is able to create a custom Action / Top bar

        //END ActionBar
        //------------------------------------------------------------------------------------------
        //START FragmentConnection

        NavHostFragment fragHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.frag_nav);
        NavController nav = Objects.requireNonNull(fragHost).getNavController();
        //Connects the NavController variable to its corresponding design in "activity_main.xml"
        //  ALSO ensures that it is not null

         bView = findViewById(R.id.bottom_nav);
        //Connects the BottomNavView variable to its corresponding design in "activity_main.xml"

        NavigationUI.setupWithNavController(bView, nav);
        //Connects both variables together so that the fragments work with the BottomNavigation

        //END FragmentConnection
        //------------------------------------------------------------------------------------------

        bView.setItemIconTintList(null);
        //The icons used for the BottomNavView can be seen in full detail
        //  without being filled in, blank shapes
    }
}
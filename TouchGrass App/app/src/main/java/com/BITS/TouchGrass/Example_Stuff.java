package com.BITS.TouchGrass;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class Example_Stuff extends AppCompatActivity {
    // Self Note - THIS is how you input basic Java variables
    // int i = 010; Whole numbers
    // double n = 0.20; Decimal / Whole numbers
    // String pj = "pp&j"; Text
    // boolean and = false; True/False
    // Character o = 'o'; ONE single letter
    public int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_stuff);
    }
    // onCreate is essentially what happens when the page opens up

    public void Clicker(View V) {
        TextView grayskull = findViewById(R.id.Grayskull);
        ImageButton ib = findViewById(R.id.Change);
        if (i == 0) {
            grayskull.setText("I have the power!");
            ib.setImageResource(R.drawable.example_man);
            i = 1;
        }
        else if (i == 1) {
            grayskull.setText("By the power of Grayskull...");
            ib.setImageResource(R.drawable.example_skull);
            i = 0;
        }
    }
    // "Clicker" (could be any name) makes stuff happen when the feature (in this case, button)
    // has been pressed. The xml requires the "onClick" addition for it to work
}
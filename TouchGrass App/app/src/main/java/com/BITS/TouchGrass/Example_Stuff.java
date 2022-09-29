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
    // - Adam
    public int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_stuff);
    }

    public void Clicker(View V) {
        TextView grayskull = findViewById(R.id.Grayskull);
        if (i == 0) {
            grayskull.setText("I have the power!");
            i = 1;
        }
        else if (i == 1) {
            grayskull.setText("By the power of Grayskull...");
            i = 0;
        }
    }
}
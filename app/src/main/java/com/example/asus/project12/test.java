package com.example.asus.project12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class test extends AppCompatActivity {

    private ImageButton testAlphabets_button;
    private ImageButton testNumbers_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testAlphabets_button = findViewById(R.id.Alphabets);
        testNumbers_button = findViewById(R.id.Numbers);

        testAlphabets_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTestAlphabetsActivity();
            }
        });

        testNumbers_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTestNumbersActivity();
            }
        });
    }

    public void openTestAlphabetsActivity() {
        Intent testingAlphabets = new Intent(this, testAlphabets.class);
        startActivity(testingAlphabets);
    }

    public void openTestNumbersActivity() {
        Intent testingNumbers = new Intent(this, testNumbers.class);
        startActivity(testingNumbers);
    }
}

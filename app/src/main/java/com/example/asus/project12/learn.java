package com.example.asus.project12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class learn extends AppCompatActivity {

    private ImageButton learnAlphabets_button;
    private ImageButton learnNumbers_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        learnAlphabets_button = findViewById(R.id.Alphabets);
        learnNumbers_button = findViewById(R.id.Numbers);

        learnAlphabets_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLearnAlphabetsActivity();
            }
        });

        learnNumbers_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLearnNumbersActivity();
            }
        });
    }

    public void openLearnAlphabetsActivity() {
        Intent learningAlphabets = new Intent(this, learnAlphabets.class);
        startActivity(learningAlphabets);
    }

    public void openLearnNumbersActivity() {
        Intent learningNumbers = new Intent(this, learnNumbers.class);
        startActivity(learningNumbers);
    }
}

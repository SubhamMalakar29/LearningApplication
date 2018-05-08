package com.example.asus.project12;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class home extends AppCompatActivity {

    private ImageButton learn_button, test_button, about_button, profile_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        learn_button = findViewById(R.id.Learn);
        test_button = findViewById(R.id.Test);
        about_button = findViewById(R.id.about);
        profile_button = findViewById(R.id.profile);


        learn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLearnActivity();
            }
        });

        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTestActivity();
            }
        });

        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutActivity();
            }
        });

        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfileActivity();
            }
        });


    }

    public void openLearnActivity() {
        Intent learning = new Intent(this, learn.class);
        startActivity(learning);
    }

    public void openTestActivity() {
        Intent testing = new Intent(this, test.class);
        startActivity(testing);
    }

    public void openAboutActivity() {
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }

    public void openProfileActivity() {
        Intent intent = new Intent(this, Profile_Activity.class);
        startActivity(intent);
    }

}

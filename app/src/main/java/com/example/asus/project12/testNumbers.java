package com.example.asus.project12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class testNumbers extends AppCompatActivity {

    private ImageButton zero2ten_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_numbers);

        zero2ten_button = findViewById(R.id.zero2ten);

        zero2ten_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openZeorToTenActivity();
            }
        });
    }

    public void openZeorToTenActivity() {
        Intent jump = new Intent(this, zeroToTen.class);
        startActivity(jump);
    }
}

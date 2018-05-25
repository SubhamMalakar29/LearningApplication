package com.example.asus.project12;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class welcome extends AppCompatActivity {
    private static int Splash = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},0);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(welcome.this, Login_Activity.class);
                startActivity(homeIntent);
                finish();
            }
        },Splash);
    }
}

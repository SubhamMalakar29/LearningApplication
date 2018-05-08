package com.example.asus.project12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_Activity extends AppCompatActivity {

    TextView nameDisp, emailDisp, logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameDisp = findViewById(R.id.nameView);
        emailDisp = findViewById(R.id.emailView);
        logout = findViewById(R.id.logoutView);

        FirebaseUser user = mAuth.getInstance().getCurrentUser();

        nameDisp.setText(user.getDisplayName());
        emailDisp.setText(user.getEmail());


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(Profile_Activity.this, Login_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}

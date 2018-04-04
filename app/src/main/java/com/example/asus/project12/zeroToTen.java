package com.example.asus.project12;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;

public class zeroToTen extends AppCompatActivity {

    private Button option1, option2, option3, option4;
    private TextView question;

    Random r;
    private Integer mQuestions[], mAnswers[], mResponses[],counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero_to_ten);

        option1 = findViewById(R.id.op1);
        option2 = findViewById(R.id.op2);
        option3 = findViewById(R.id.op3);
        option4 = findViewById(R.id.op4);
        question = findViewById(R.id.quest);

        prepareQuestions();
        prepareAnswers();
        updateQuestion();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });
    }

    public void prepareQuestions() {
        r = new Random();
        int i,j,q,c=0;
        mQuestions = new Integer[5];
        for(i=0;i<5;i++) {
            mQuestions[i]=-1;
        }
        for(i=0;i<5;i++) {
            q=r.nextInt(11);
            c=0;
            for(j=0;j<i;j++) {
                if(mQuestions[j]==q)
                    c++;
            }
            if(c==0){
                mQuestions[i]=q;
            }
            else
                i--;
        }
    }

    public void prepareAnswers() {
        mAnswers = new Integer[5];
        int i;
        for (i=0;i<5;i++) {
            mAnswers[i] = mQuestions[i];
        }
    }

    public void updateQuestion(){
        if (counter<5) {
            question.setText(mQuestions[counter].toString());
            counter++;
        }
    }
    private void testOver () {
        AlertDialog.Builder alertMessage = new AlertDialog.Builder( zeroToTen.this );
        alertMessage
                .setMessage("Test Over")
                .setCancelable(false)
                .setPositiveButton("New Test",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(),zeroToTen.class));
                                finish();
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertMessage.create();
        alertDialog.show();
    }
}
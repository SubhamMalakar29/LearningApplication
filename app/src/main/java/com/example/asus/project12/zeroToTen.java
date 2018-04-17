package com.example.asus.project12;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;

import java.util.Date;
import java.util.Random;

public class zeroToTen extends AppCompatActivity {

    private Button option1, option2, option3, option4;
    private TextView question;

    Random r;
    private Integer mQuestions[], mAnswers[], mOptions[], counter = 0;
    public String path = Environment.getExternalStorageDirectory()+"/Learning Application";

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
                recorder(option1.getText().toString());
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               recorder(option2.getText().toString());
               if (counter<5)
                    updateQuestion();
               else
                    testOver();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recorder(option3.getText().toString());
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recorder(option4.getText().toString());
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });
    }

    public void prepareQuestions() {
        r = new Random();
        int i,j,q,c;
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
            updateOptions();
        }
    }

    public void updateOptions(){
        mOptions = new Integer[4];
        int opNoSeq[],q,i,j,c;
        opNoSeq = new int[4];

        for(i=0;i<4;i++) {
            q=r.nextInt(4);
            c=0;
            for(j=0;j<i;j++) {
                if(opNoSeq[j]==q)
                    c++;
            }
            if(c==0){
                opNoSeq[i]=q;
            }
            else
                i--;
        }

        mOptions[0] = mAnswers[counter];

        for(i=1;i<4;i++) {
            q=r.nextInt(11);
            c=0;
            for(j=0;j<i;j++) {
                if(mOptions[j]==q)
                    c++;
            }
            if(c==0){
                mOptions[i]=q;
            }
            else
                i--;
        }

        for(i=0;i<4;i++) {
            switch (opNoSeq[i]) {
                case 0:
                    option1.setText(mOptions[i].toString());
                    break;
                case 1:
                    option2.setText(mOptions[i].toString());
                    break;
                case 2:
                    option3.setText(mOptions[i].toString());
                    break;
                case 3:
                    option4.setText(mOptions[i].toString());
                    break;
                default:
                    break;
            }
        }
    }

    public void recorder(String s) {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String entry = currentDateTimeString+" , "+mQuestions[counter].toString()+" , "+s+"\n";
        File dir = new File(path);
        if (!dir.exists())
            dir.mkdirs();
        File myFile = new File(path+"/ResponsesZeroToTen.csv");
        try {
            FileOutputStream out = new FileOutputStream(myFile,true);
            out.write(entry.getBytes());
            out.flush();
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        counter++;
    }

    private void testOver () {
        AlertDialog.Builder alertMessage = new AlertDialog.Builder( zeroToTen.this );
        alertMessage
                .setMessage("Test Over!")
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
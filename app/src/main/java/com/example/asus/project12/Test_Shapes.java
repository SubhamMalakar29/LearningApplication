package com.example.asus.project12;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;

import java.util.Date;
import java.util.Random;

public class Test_Shapes extends AppCompatActivity {

    private ImageView option1, option2, option3, option4;
    private TextView question;

    Random r;
    private Integer mQuestions[], mAnswers[], mOptions[], counter = 0;
    public Integer temp,temp1,temp2,temp3,temp4;
    public String path = Environment.getExternalStorageDirectory()+"/Learning Application";

    int[] images = { R.drawable.circle_1, R.drawable.rectangle_3,
            R.drawable.square_2, R.drawable.triangle_1,
            R.drawable.oval_1, R.drawable.star_1};

    String[] names = new String[] { "Circle", "Rectangle", "Square", "Triangle", "Oval", "Star" };

    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_shapes);

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
                recorder(temp1);
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recorder(temp2);
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recorder(temp3);
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recorder(temp4);
                if (counter<5)
                    updateQuestion();
                else
                    testOver();
            }
        });
    }

    public void prepareQuestions() {
        r = new Random();
        int i,j,c,q;
        mQuestions = new Integer[5];
        for(i=0;i<5;i++) {
            mQuestions[i]=-1;
        }
        for(i=0;i<5;i++) {
            q=r.nextInt(6);
            c=0;
            for(j=0;j<i;j++) {
                if(mQuestions[j]==q)
                    c++;
            }
            if(c==0)
                mQuestions[i]=q;
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
            temp=mQuestions[counter];
            question.setText(names[temp]);
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
            q=r.nextInt(6);
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
                    temp1=mOptions[i];
                    option1.setBackgroundResource(images[mOptions[i]]);
                    break;
                case 1:
                    temp2=mOptions[i];
                    option2.setBackgroundResource(images[mOptions[i]]);
                    break;
                case 2:
                    temp3=mOptions[i];
                    option3.setBackgroundResource(images[mOptions[i]]);
                    break;
                case 3:
                    temp4=mOptions[i];
                    option4.setBackgroundResource(images[mOptions[i]]);
                    break;
                default:
                    break;
            }
        }
    }

    public void recorder(int s) {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String entry = currentDateTimeString+" , "+names[temp]+" , "+names[s]+"\n";
        String Message = names[temp].toString()+" , "+names[s];

        myRef = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid = user.getUid();

        myRef.child(userid).child("Log").child("Shapes").child(currentDateTimeString).setValue(Message);

        File dir = new File(path);
        if (!dir.exists())
            dir.mkdirs();
        File myFile = new File(path+"/Shapes.csv");
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
        AlertDialog.Builder alertMessage = new AlertDialog.Builder( Test_Shapes.this );
        alertMessage
                .setMessage("Test Over!")
                .setCancelable(false)
                .setPositiveButton("New Test",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), Test_Shapes.class));
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
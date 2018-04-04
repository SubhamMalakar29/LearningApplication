package com.example.asus.project12;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class learnAlphabets extends Activity {

    private ImageView hImageViewPic;
    private ImageButton nextButton, prevButton;

    private int currentImage = 0;
    int[] images = { R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20, R.drawable.a21, R.drawable.a22, R.drawable.a23, R.drawable.a24, R.drawable.a25, R.drawable.a26 };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_alphabets);

        hImageViewPic = (ImageView)findViewById(R.id.display);
        nextButton = (ImageButton) findViewById(R.id.next);
        prevButton = (ImageButton) findViewById(R.id.prev);
        //Just set one Click listener for the image

        nextButton.setOnClickListener(nextButtonChangeImageListener);
        prevButton.setOnClickListener(prevButtonChangeImageListener);
    }
    View.OnClickListener nextButtonChangeImageListener = new OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage++;
            currentImage = currentImage % images.length;

            hImageViewPic.setImageResource(images[currentImage]);

        }
    };

    View.OnClickListener prevButtonChangeImageListener = new OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage--;
            currentImage = (currentImage + images.length) % images.length;

            hImageViewPic.setImageResource(images[currentImage]);

        }
    };
}
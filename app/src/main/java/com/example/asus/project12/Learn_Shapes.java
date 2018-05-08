package com.example.asus.project12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Learn_Shapes extends AppCompatActivity {

    private TextView Name;
    private ImageView hImageViewPic;
    private ImageButton nextButton, prevButton;

    private int currentImage = 0;
    int[] images = { R.drawable.circle_1, R.drawable.rectangle_3, R.drawable.square_2,
                     R.drawable.triangle_1, R.drawable.oval_1, R.drawable.star_1 };
    String[] names = { "CIRCLE", "RECTANGLE", "SQUARE", "TRIANGLE", "OVAL", "STAR" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_shapes);

        Name = findViewById(R.id.Shape_Name);
        hImageViewPic = findViewById(R.id.display);
        nextButton = findViewById(R.id.next);
        prevButton = findViewById(R.id.prev);
        //Just set one Click listener for the image

        nextButton.setOnClickListener(nextButtonChangeImageListener);
        prevButton.setOnClickListener(prevButtonChangeImageListener);
    }
    View.OnClickListener nextButtonChangeImageListener = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage++;
            currentImage = currentImage % images.length;
            Name.setText(names[currentImage]);
            hImageViewPic.setImageResource(images[currentImage]);

        }
    };

    View.OnClickListener prevButtonChangeImageListener = new View.OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage--;
            currentImage = (currentImage + images.length) % images.length;
            Name.setText(names[currentImage]);
            hImageViewPic.setImageResource(images[currentImage]);

        }
    };
}

package com.example.asus.project12;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;


public class learnNumbers extends Activity {

    private ImageView hImageViewPic;
    private ImageButton nextButton, prevButton;

    private int currentImage = 0;
    int[] images = { R.drawable.n0,R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n5, R.drawable.n6, R.drawable.n7, R.drawable.n8, R.drawable.n9, R.drawable.n10, R.drawable.n11, R.drawable.n12, R.drawable.n13, R.drawable.n14, R.drawable.n15, R.drawable.n16, R.drawable.n17, R.drawable.n18, R.drawable.n19, R.drawable.n20, R.drawable.n21, R.drawable.n22, R.drawable.n23, R.drawable.n24, R.drawable.n25, R.drawable.n26, R.drawable.n27, R.drawable.n28, R.drawable.n29, R.drawable.n30, R.drawable.n31, R.drawable.n32, R.drawable.n33, R.drawable.n34, R.drawable.n35, R.drawable.n36, R.drawable.n37, R.drawable.n38, R.drawable.n39, R.drawable.n40, R.drawable.n41, R.drawable.n42, R.drawable.n43, R.drawable.n44, R.drawable.n45, R.drawable.n46, R.drawable.n47, R.drawable.n48, R.drawable.n49, R.drawable.n50, R.drawable.n51, R.drawable.n52, R.drawable.n53, R.drawable.n54, R.drawable.n55, R.drawable.n56, R.drawable.n57, R.drawable.n58, R.drawable.n59, R.drawable.n60, R.drawable.n61, R.drawable.n62, R.drawable.n63, R.drawable.n64, R.drawable.n65, R.drawable.n66, R.drawable.n67, R.drawable.n68, R.drawable.n69, R.drawable.n70, R.drawable.n71, R.drawable.n72, R.drawable.n73, R.drawable.n74, R.drawable.n75, R.drawable.n76, R.drawable.n77, R.drawable.n78, R.drawable.n79, R.drawable.n80, R.drawable.n81, R.drawable.n82, R.drawable.n83, R.drawable.n84, R.drawable.n85, R.drawable.n86, R.drawable.n87, R.drawable.n88, R.drawable.n89, R.drawable.n90, R.drawable.n91, R.drawable.n92, R.drawable.n93, R.drawable.n94, R.drawable.n95, R.drawable.n96, R.drawable.n97, R.drawable.n98, R.drawable.n99, R.drawable.n100 };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_numbers);

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
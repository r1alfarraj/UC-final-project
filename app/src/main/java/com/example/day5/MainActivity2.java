package com.example.day5;

import static com.example.day5.R.id.button2;
import static com.example.day5.R.id.button3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

Button button3;
RatingBar ratingStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button Done = findViewById(R.id.button3);
        ratingStars = findViewById(R.id.simpleRatingBar);

        float myRating=0;

        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message = null;
                ratingBar.getRating();

                switch (rating){
                    case 1:
                        message = "we are sorry to hear that :(";
                        break;
                    case 2:
                        message = "we always accept suggestions";
                        break;
                    case 3:
                        message ="good enough";
                        break;
                    case 4:
                        message ="Good enough!! Thankyou!";
                        break;
                    case 5:
                        message = "Great !!";
                        break;
                    case 6:
                        message = "Awesome!! you are the best!!";
                        break;
                    case 7:
                        message = "Amaizing !! Hope to see you again!!";
                        break;

                }
                Toast.makeText(MainActivity2.this,message,Toast.LENGTH_SHORT).show();

            }
        });







    }
}
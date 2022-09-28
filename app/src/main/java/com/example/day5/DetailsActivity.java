package com.example.day5;

import static com.example.day5.R.id.button;
import static com.example.day5.R.id.button2;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView nametext = findViewById(R.id.textViewnamed);
        TextView nametext2 = findViewById(R.id.textView3);
        TextView pricetext = findViewById(R.id.textViewpriced);
        ImageView img = findViewById(R.id.imageViewDetails);
        Button pdfRead = findViewById(button);
        Button pdfrate = findViewById(button2);


        Bundle bundle = getIntent().getExtras();

        BookShop sentBook = (BookShop) bundle.getSerializable("BookShop");

        nametext.setText(sentBook.getBookName());
        nametext2.setText(sentBook.getBookType());

        //  img.setImageResource(sentBook.getBookImg());

        pricetext.setText(sentBook.getbookPrice() + " KD");

        Picasso.with(this).load(sentBook.getBookImg()).into(img);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
             // Intent intent = new Intent(DetailsActivity.this,MainActivity2.class);
             //   startActivity(intent);
                String url = sentBook.getBookUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 Intent intent = new Intent(DetailsActivity.this,SplashScreen.class);
                 startActivity(intent);

            }
        });


    }


        }



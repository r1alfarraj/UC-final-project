package com.example.day5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<BookShop> myList = new ArrayList<>();
    int currentBook=0;
    Context context;

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://bookstore-cbe8e-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




       /* BookShop B1 = new BookShop("The Chronicles of Narinia" ,5, R.drawable.imge1,"Fiction");
        BookShop B2 = new BookShop("BECOMING" , 6.5 , R.drawable.imge2,"nonFiction");
        BookShop B3 = new BookShop("little women" , 5 , R.drawable.imge3,"Classics");
       BookShop B4 = new BookShop("A TALE OF TWO CITIES" , 4.3 , R.drawable.imge4,"British Classics");
       BookShop B5 = new BookShop("Romeo and Juliet" , 4.4 , R.drawable.imge5,"Tragedy");
       BookShop B6 = new BookShop("The WAR of the Worlds" , 6 , R.drawable.imge6,"Science Fiction");

     myList.add(B1);*/
        RecyclerView recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);

        ItemAdapter adapter = new ItemAdapter(myList, this);
        recycler.setAdapter(adapter);
      /*  myList.add(B2);
        myList.add(B3);
        myList.add(B4);
        myList.add(B5);
        myList.add(B6);*/


        final Query myBook = dbRef.child("Book");
        myBook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot a : snapshot.getChildren()){
                    BookShop book = a.getValue(BookShop.class);
                    myList.add(book);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });


    }

}
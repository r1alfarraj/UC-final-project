package com.example.day5;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {
    ArrayList<BookShop> myList = new ArrayList<>();
    Context context;

    public ItemAdapter(ArrayList<BookShop> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        ViewHolder vh = new ViewHolder(view);


        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ((ViewHolder)holder).textname.setText(myList.get(position).getBookType());
        ((ViewHolder)holder).textprice.setText(myList.get(position).getbookPrice() + " KD");
      //  ((ViewHolder)holder).img.setImageResource(myList.get(position).getBookImg());
        Picasso.with(context).load(myList.get(position).getBookImg()).into(((ViewHolder)holder).img);
        ((ViewHolder)holder).textname2.setText(myList.get(position).getBookName());
        ((ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("BookShop",myList.get(position));
                context.startActivity(intent);

            }
        });
        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookShop removedphone = myList.get(position);
                int x = position;
                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setTitle("Attention!!")
                        .setMessage("Are you sure you want to delete this item ?")
                        .setPositiveButton("delete",new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                myList.remove(position);
                                notifyDataSetChanged();
                                Snackbar.make(context, view,"one item deleted",3000)
                                        .setAction("Undo", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                myList.add(position,removedphone);
                                                notifyDataSetChanged();
                                            }
                                        }).show();

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alert.show();

            }
        });

    }
    @Override

    public int getItemCount() {
        return myList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img,delete;
        TextView textname,textprice,textname2;
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v =itemView;
            img = v.findViewById(R.id.imageView);
            textname = v.findViewById(R.id.textView3);
            textname2 = v.findViewById(R.id.textViewnamed);
            textprice = v.findViewById(R.id.textViewpriced);
            delete= v.findViewById(R.id.imageView2);



        }
    }
}

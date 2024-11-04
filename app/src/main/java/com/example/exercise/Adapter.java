package com.example.exercise;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Constructor;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Myholder> {
    @NonNull
    Context context;
    List<LoadData>loadData;
    LayoutInflater layoutInflater;

    public Adapter(@NonNull Context context, List<LoadData> loadData) {
        this.context = context;
        this.loadData=loadData;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.imageview,parent,false);



        return new Myholder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {



        holder.imageView.setImageURI(loadData.get(position).getImageview());
        holder.textView.setText(loadData.get(position).getTextview());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("imageuri",loadData.get(position).getImageview().toString());
                context.startActivity(intent);

                 */



                FragmentManager fragmentManager=((MainActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                Bundle bundle=new Bundle();
                bundle.putString("imageuri",loadData.get(position).getImageview().toString());
                bundle.putString("text",loadData.get(position).getTextview().toString());


                ViewPagerFragment viewPagerFragment=new ViewPagerFragment();
                viewPagerFragment.setArguments(bundle);



                fragmentTransaction.add(R.id.framelayoutt,viewPagerFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();





            }
        });




    }

    @Override
    public int getItemCount() {
        return loadData.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;


        public Myholder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageviews);
            textView=itemView.findViewById(R.id.textview);



        }
    }


}

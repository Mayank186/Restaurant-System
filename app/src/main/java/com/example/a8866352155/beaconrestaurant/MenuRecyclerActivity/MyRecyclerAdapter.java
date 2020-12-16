package com.example.a8866352155.beaconrestaurant.MenuRecyclerActivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a8866352155.beaconrestaurant.R;

import java.util.ArrayList;

/**
 * Created by 8866352155 on 3/6/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewholder> {

    Context context;
    ArrayList<Food> foods;

    public MyRecyclerAdapter(Context context, ArrayList<Food> foods) {
        this.context = context;
        this.foods = foods;
    }
    //hi from here holder chalu thase NOTE:parth
    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_for_menu,null);
        MyViewholder holder=new MyViewholder(v);
        return holder;
    }

    //ahiya bind thase
    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        holder.nameTxt.setText(foods.get(position).getName());
        holder.img.setImageResource(foods.get(position).getImage());

        //listener ahiya

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Toast.makeText(context, foods.get(pos).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
}

package com.example.a8866352155.beaconrestaurant.Pizzafood_Menu_Recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a8866352155.beaconrestaurant.R;

/**
 * Created by 8866352155 on 3/22/2017.
 */

public class PizzaViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img;
    TextView nameTxt;
    TextView price;
    ItemClickListeners itemClickListeners;
    Context context;

    public PizzaViewholder(View itemView) {
        super(itemView);
        context=itemView.getContext();


        img=(ImageView) itemView.findViewById(R.id.item_image);
        nameTxt=(TextView)itemView.findViewById(R.id.item_name);
        price=(TextView)itemView.findViewById(R.id.item_price);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListeners ic){

        this.itemClickListeners=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListeners.onItemClick(v,getLayoutPosition());

    }
}

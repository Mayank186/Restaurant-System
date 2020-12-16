package com.example.a8866352155.beaconrestaurant.MenuRecyclerActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a8866352155.beaconrestaurant.Chinesefood_Menu_Activity;
import com.example.a8866352155.beaconrestaurant.Gujaratifood_Menu_Activity;
import com.example.a8866352155.beaconrestaurant.IceCream_Menu_Activity;
import com.example.a8866352155.beaconrestaurant.Pizzafood_Menu_Activity;
import com.example.a8866352155.beaconrestaurant.Punjabifood_Menu_Activity;
import com.example.a8866352155.beaconrestaurant.R;
import com.example.a8866352155.beaconrestaurant.Southfood_Menu_Activity;

/**
 * Created by 8866352155 on 3/6/2017.
 */

public class MyViewholder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img;
    TextView nameTxt;
    ItemClickListener itemClickListener;
    Context context;


    public MyViewholder(View itemView) {
        super(itemView);
        context=itemView.getContext();

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img= (ImageView ) itemView.findViewById(R.id.imgview);

        itemView.setOnClickListener(this);


    }

    public void setItemClickListener(ItemClickListener ic){

        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

        Intent intent=null;

        switch (getAdapterPosition())
        {
            case 0:
                intent=new Intent(context, Pizzafood_Menu_Activity.class);
                break;

            case 1:
                intent=new Intent(context, Gujaratifood_Menu_Activity.class);
                break;

            case 2:
                intent=new Intent(context, Chinesefood_Menu_Activity.class);
                break;

            case 3:
                intent=new Intent(context, Southfood_Menu_Activity.class);
                break;

            case 4:
                intent=new Intent(context, Punjabifood_Menu_Activity.class);
                break;

            case 5:
                intent=new Intent(context, IceCream_Menu_Activity.class);
                break;
        }
        context.startActivity(intent);

    }
}


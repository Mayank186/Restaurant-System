package com.example.a8866352155.beaconrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a8866352155.beaconrestaurant.IceCream_Menu_Recycler.IceCream;
import com.example.a8866352155.beaconrestaurant.IceCream_Menu_Recycler.IceCreamRecyclerAdapter;

import java.util.ArrayList;

public class IceCream_Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_cream__menu);

        RecyclerView rv=(RecyclerView)findViewById(R.id.icecream_recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new IceCreamRecyclerAdapter(this,getIceCream()));
    }

    private ArrayList<IceCream> getIceCream() {

        ArrayList<IceCream> foods=new ArrayList<>();

        IceCream food=new IceCream(R.drawable.banana,"Banana-Venilla","45 Rs.");
        foods.add(food);

        food=new IceCream(R.drawable.coconut,"Coconut","60 Rs.");
        foods.add(food);

        food=new IceCream(R.drawable.mango,"Rajvadi-Mango","70 Rs.");
        foods.add(food);

        food=new IceCream(R.drawable.lemon,"Lemon-Pineapple","50 Rs.");
        foods.add(food);

        food=new IceCream(R.drawable.watermelon,"Watermelon","30 Rs.");
        foods.add(food);

        food=new IceCream(R.drawable.velvet,"Straubarry","75 Rs.");
        foods.add(food);

        food=new IceCream(R.drawable.frusting,"Cholocate","50 Rs.");
        foods.add(food);

       /* food=new IceCream(R.drawable.cup,"Badam-Pista-Keshar","50 Rs.");
        foods.add(food);*/

        return foods;
    }
}

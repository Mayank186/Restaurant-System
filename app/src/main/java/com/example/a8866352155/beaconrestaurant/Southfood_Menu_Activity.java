package com.example.a8866352155.beaconrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a8866352155.beaconrestaurant.Southfood_Menu_Recycler.SouthFood;
import com.example.a8866352155.beaconrestaurant.Southfood_Menu_Recycler.SouthFoodRecyclerAdapter;

import java.util.ArrayList;

public class Southfood_Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southfood__menu);

        RecyclerView rv=(RecyclerView)findViewById(R.id.southfood_recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new SouthFoodRecyclerAdapter(this,getSouthFood()));
    }

    private ArrayList<SouthFood> getSouthFood() {

        ArrayList<SouthFood> foods =new ArrayList<>();

        SouthFood food=new SouthFood(R.drawable.dhosa,"Dhosa","115 Rs");
        foods.add(food);

        food=new SouthFood(R.drawable.idli,"Idli","40 Rs.");
        foods.add(food);

        food=new SouthFood(R.drawable.malabari_parotha,"Malabari","30 Rs.");
        foods.add(food);

        food=new SouthFood(R.drawable.mushroom_uttapa,"Uttapa","39 Rs.");
        foods.add(food);

        food=new SouthFood(R.drawable.paal_payasam,"Paal-Payasam","65 Rs.");
        foods.add(food);

        food=new SouthFood(R.drawable.mendu_vada,"Mendu-Vada","40 Rs.");
        foods.add(food);

        return foods;

    }
}

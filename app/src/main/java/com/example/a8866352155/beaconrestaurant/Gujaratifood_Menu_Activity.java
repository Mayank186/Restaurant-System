package com.example.a8866352155.beaconrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a8866352155.beaconrestaurant.Gujaratifood_Menu_Recycler.Guj;
import com.example.a8866352155.beaconrestaurant.Gujaratifood_Menu_Recycler.GujRecyclerAdapter;

import java.util.ArrayList;

public class Gujaratifood_Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gujaratifood__menu);

        RecyclerView rv=(RecyclerView)findViewById(R.id.guj_recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new GujRecyclerAdapter(this,getGujFood()));
    }

    private ArrayList<Guj> getGujFood() {

        ArrayList<Guj> foods =new ArrayList<>();

        Guj food=new Guj(R.drawable.fulldish,"Full-Dish","120 Rs.");
        foods.add(food);

        food=new Guj(R.drawable.khaman,"Khaman-Dhokla","79 Rs.");
        foods.add(food);

        food=new Guj(R.drawable.lassi,"Chaas","19 Rs.");
        foods.add(food);

        food=new Guj(R.drawable.patra,"Chhas","79 Rs.");
        foods.add(food);

        food=new Guj(R.drawable.fafda,"Fafda","50 Rs.");
        foods.add(food);

        food=new Guj(R.drawable.khand,"Khandvi","39 Rs.");
        foods.add(food);

        /*food=new Guj(R.drawable.cup,"Chinese","79 Rs.");
        foods.add(food);*/

        return foods;

    }
}

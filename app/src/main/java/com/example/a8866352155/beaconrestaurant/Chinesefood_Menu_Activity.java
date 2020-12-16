package com.example.a8866352155.beaconrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a8866352155.beaconrestaurant.Chinesefood_Menu_Recycler.Chinese;
import com.example.a8866352155.beaconrestaurant.Chinesefood_Menu_Recycler.ChineseRecyclerAdapter;

import java.util.ArrayList;

public class Chinesefood_Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinesefood__menu);

        RecyclerView rv=(RecyclerView)findViewById(R.id.chinese_recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ChineseRecyclerAdapter(this,getChineseFood()));
    }

    private ArrayList<Chinese> getChineseFood() {

        ArrayList<Chinese> foods =new ArrayList<>();

        Chinese food=new Chinese(R.drawable.carrot_manchurian,"Manchurian","79 Rs.");
        foods.add(food);

        food=new Chinese(R.drawable.chop_suey,"Chop-Suey","40 Rs.");
        foods.add(food);

        food=new Chinese(R.drawable.chow_mein,"Chow-Mein","40 Rs.");
        foods.add(food);

        food=new Chinese(R.drawable.fried_rice,"Fried-Rice","50 Rs.");
        foods.add(food);

        food=new Chinese(R.drawable.noodles,"Noodle","25 Rs.");
        foods.add(food);

        food=new Chinese(R.drawable.spring_rolls,"Spring-Roll","60 Rs.");
        foods.add(food);

        /*food=new Chinese(R.drawable.cup,"Chinese","79 Rs.");
        foods.add(food);

        food=new Chinese(R.drawable.cup,"Chinese","79 Rs.");
        foods.add(food);*/

        return foods;
    }


}

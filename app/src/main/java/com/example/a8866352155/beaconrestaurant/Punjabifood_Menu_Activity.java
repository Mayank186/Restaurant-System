package com.example.a8866352155.beaconrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a8866352155.beaconrestaurant.Punjabifood_Menu_Recycler.PunjabiFood;
import com.example.a8866352155.beaconrestaurant.Punjabifood_Menu_Recycler.PunjabiFoodRecyclerAdapter;

import java.util.ArrayList;

public class Punjabifood_Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punjabifood__menu);

        RecyclerView rv=(RecyclerView)findViewById(R.id.punjabifood_recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new PunjabiFoodRecyclerAdapter(this,getPunjabiFood()));
    }

    private ArrayList<PunjabiFood> getPunjabiFood() {

        ArrayList<PunjabiFood> foods =new ArrayList<>();

        PunjabiFood food=new PunjabiFood(R.drawable.bhature,"Bhature","30 Rs.");
        foods.add(food);

        food=new PunjabiFood(R.drawable.dal_makhni,"Dal-Makhni","40 Rs.");
        foods.add(food);

        food=new PunjabiFood(R.drawable.punjabi_bigicon,"Lassi","29 Rs.");
        foods.add(food);

        food=new PunjabiFood(R.drawable.masala_chana,"Masala-Chana","39 Rs.");
        foods.add(food);

        food=new PunjabiFood(R.drawable.panner_tika,"Panner-Tika","79 Rs.");
        foods.add(food);

        food=new PunjabiFood(R.drawable.parotha,"Butter-Parotha","43 Rs.");
        foods.add(food);

        food=new PunjabiFood(R.drawable.pinni,"Pinni","29 Rs.");
        foods.add(food);

        food=new PunjabiFood(R.drawable.rajma_chawal,"Rajma","50 Rs.");
        foods.add(food);



        return foods;
    }
}

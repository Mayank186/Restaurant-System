package com.example.a8866352155.beaconrestaurant;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.a8866352155.beaconrestaurant.Pizzafood_Menu_Recycler.Pizza;
import com.example.a8866352155.beaconrestaurant.Pizzafood_Menu_Recycler.PizzaRecyclerAdapter;

import java.util.ArrayList;

public class Pizzafood_Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzafood_menu);



        RecyclerView rv=(RecyclerView)findViewById(R.id.pizza_recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new PizzaRecyclerAdapter(this,getPizza()));
    }



    private ArrayList<Pizza> getPizza() {
        ArrayList<Pizza> foods =new ArrayList<>();


        Pizza food=new Pizza(R.drawable.a,"Margherita","79 Rs.");
        foods.add(food);

        food=new Pizza(R.drawable.b,"Chili Pizza","89 Rs.");
        foods.add(food);

        food=new Pizza(R.drawable.c,"Extra Cheese","99 Rs.");
        foods.add(food);

        food=new Pizza(R.drawable.d,"Margerita","99 Rs.");
        foods.add(food);

        food=new Pizza(R.drawable.g,"Italian-Pizza","89 Rs.");
        foods.add(food);

        food=new Pizza(R.drawable.f,"Jain Pizza","79 Rs.");
        foods.add(food);

        return foods;
    }
}

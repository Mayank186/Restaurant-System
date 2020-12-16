package com.example.a8866352155.beaconrestaurant;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.a8866352155.beaconrestaurant.MenuRecyclerActivity.Food;
import com.example.a8866352155.beaconrestaurant.MenuRecyclerActivity.MyRecyclerAdapter;

import java.util.ArrayList;

public class MenusActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    /*CustomPagerAdapter mcustomPagerAdapter;
    ViewPager mviewPager;*/
    int[] imageArray = {
            R.drawable.khaman,
            R.drawable.patra,
            R.drawable.fafda,
            R.drawable.khaman,

    };
    ImageView iv;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        RecyclerView rv = (RecyclerView) findViewById(R.id.menu_recyler);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setAdapter(new MyRecyclerAdapter(this, getBreakfast()));

        //image slider no code

        /*mcustomPagerAdapter=new CustomPagerAdapter(this);
        mviewPager=(ViewPager) findViewById(R.id.pager);
        mviewPager.setAdapter(mcustomPagerAdapter);*/

        iv = (ImageView) findViewById(R.id.myimageview);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                iv.setImageResource(imageArray[i]);
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 3000);  //for interval...
            }
        };
        handler.postDelayed(runnable, 100);
       /* handler.postDelayed(runnable, 500);*/ //for initial delay..



        //drawer
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);*/



        //BoTTOM bar no code

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_menu:
                        Toast.makeText(MenusActivity.this,"Already Select",Toast.LENGTH_SHORT).show();

                        /*
                        Intent intent=new Intent(MenusActivity.this,MenusActivity.class);
                        startActivity(intent);
                        */
                        break;

                    case R.id.action_order:
                        /*Intent intent1=new Intent(MenusActivity.this,OrderActivity.class);
                        startActivity(intent1);
                        finish();*/
                        Toast.makeText(MenusActivity.this,"Please Order the Food first",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_about:
                        Intent intent2=new Intent(MenusActivity.this,AboutActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        /*overridePendingTransition(0, 0);*/
                        finish();
                        break;
                }
                return false;
            }
        });

    }

    //drawer mate ni method
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }*/

    private ArrayList<Food> getBreakfast() {

        ArrayList<Food> foods =new ArrayList<>();

        Food food =new Food(R.drawable.pizza_bigicon,"Pizza");
        foods.add(food);

        food =new Food(R.drawable.khaman_bigicon,"Gujrati-Dish");
        foods.add(food);

        food =new Food(R.drawable.chinese_bigicon,"Chinese");
        foods.add(food);

        food =new Food(R.drawable.south_bigicon,"South-Food");
        foods.add(food);

        food =new Food(R.drawable.punjabi_bigicon,"Punjabi Food");
        foods.add(food);

        food=new Food(R.drawable.mango,"Ice-Cream");
        foods.add(food);

        return foods;
    }
}

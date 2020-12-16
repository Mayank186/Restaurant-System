package com.example.a8866352155.beaconrestaurant;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_menu:
                        Intent intent=new Intent(AboutActivity.this,MenusActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.action_order:

                        /*Intent intent1=new Intent(AboutActivity.this,OrderActivity.class);
                        startActivity(intent1);*/
                        Toast.makeText(AboutActivity.this,"Please Order the Food first",Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.action_about:
                        Toast.makeText(AboutActivity.this,"Already Select",Toast.LENGTH_SHORT).show();
                        /*Intent intent2=new Intent(OrderActivity.this,AboutActivity.class);
                        startActivity(intent2);*/
                        break;
                }
                return false;
            }
        });
    }
    }


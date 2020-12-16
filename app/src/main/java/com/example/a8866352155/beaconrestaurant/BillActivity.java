package com.example.a8866352155.beaconrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BillActivity extends AppCompatActivity {

    TextView item_name,item_price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        Intent intent=getIntent();
      String Item=intent.getStringExtra("bill");
      String Price=intent.getStringExtra("price");

        item_name=(TextView)findViewById(R.id.bill_name);
        item_price=(TextView)findViewById(R.id.bill_price);

        item_name.setText(Item);
        item_price.setText(Price);
    }
}

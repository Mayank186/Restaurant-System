package com.example.a8866352155.beaconrestaurant;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static com.example.a8866352155.beaconrestaurant.R.id.bill_name;
import static com.example.a8866352155.beaconrestaurant.R.id.bill_price;

public class OrderActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private final String serverUrl = "http://192.168.43.142/smarts/order.php";

    ImageView imageView;
    TextView txt_name;
    TextView txt_price;
    BottomNavigationView bottomNavigationView;
    Button order;
    String name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        final Intent intent=getIntent();
        String names=intent.getStringExtra("Name");
        String price=intent.getStringExtra("Price");
        int image=intent.getIntExtra("Image",0);


        imageView=(ImageView)findViewById(R.id.item_image);
        imageView.setImageResource(image);

        txt_name=(TextView)findViewById(R.id.item_name);
        txt_name.setText(names);

        txt_price= (TextView) findViewById(R.id.item_price);
        txt_price.setText(price);

        order=(Button)findViewById(R.id.order_now);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 name=txt_name.getText().toString();
                email=txt_price.getText().toString();

                //json data to server
                bg obj = new bg();

                obj.execute(name, email);
                //**Intent intent1=new Intent(OrderActivity.this,BillActivity.class);
               /* intent1.putExtra("bill",bill_name);
                intent1.putExtra("price",bill_price);
                startActivityForResult(intent1,0);
                finish();*/
            }
        });

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_menu:
                        Intent intent=new Intent(OrderActivity.this,MenusActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.action_order:
                        Toast.makeText(OrderActivity.this,"Already Select",Toast.LENGTH_SHORT).show();

                        /*Intent intent1=new Intent(OrderActivity.this,OrderActivity.class);
                        startActivity(intent1);*/
                        break;

                    case R.id.action_about:
                        Intent intent2=new Intent(OrderActivity.this,AboutActivity.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }

    String response="";
    String result="";
    private static final String TAG = "NIGGAAAH@!";

    public class bg extends AsyncTask<String, Void, String> {




        @Override
        protected String doInBackground(String... params) {

            try {
                String name = params[0];
                String email = params[1];


                Log.e("Chheckk", name+email);

                URL url = new URL("http://192.168.43.142/smarts/order.php");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");
                con.setRequestMethod("POST");

                JSONObject jobject = new JSONObject();

                jobject.put("name", name);
                jobject.put("email", email);


                Log.e(TAG, jobject.toString());

                OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
                wr.write(jobject.toString());
                wr.flush();

                //display what returns the POST request

                StringBuilder sb = new StringBuilder();
                int HttpResult = con.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), "utf-8"));
                    while ((response = br.readLine()) != null) {
                        sb.append(response + "\n");
                        result += response;

                        return result;

                    }
                    br.close();
                    System.out.println("" + sb.toString());



                } else {
                    System.out.println(con.getResponseMessage());
                }
            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException: " + e.getMessage());
            } catch (ProtocolException e) {
                Log.e(TAG, "ProtocolException: " + e.getMessage());
            } catch (IOException e) {
                Log.e(TAG, "IOException: " + e.getMessage());
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
            return null;

        }
        @Override
        protected void onPostExecute(String result1) {

            super.onPostExecute(result1);

            result1=result;

            // Log.e("result1",result1);
            if(result1.equals("success")){
                Intent i=new Intent(OrderActivity.this,BillActivity.class);
                i.putExtra("bill",name);
                i.putExtra("price",email);
                /*startActivityForResult(i,0);
                finish();*/
                startActivity(i);



            }
            else {
                Toast.makeText(OrderActivity.this,"Please Wait", Toast.LENGTH_LONG).show();


            }




        }


    }

}

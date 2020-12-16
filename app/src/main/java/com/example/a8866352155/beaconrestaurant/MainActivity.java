package com.example.a8866352155.beaconrestaurant;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.SystemRequirementsChecker;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText inpt_email,inpt_pass;
    Button Login;
    TextView Registration;
    Button Guest;

    private static final int REQUEST_SIGNUP = 0;
/*
    private final String serverUrl = "http://192.168.43.85/smarts/login.php";
*/
    private final String serverUrl = "http://192.168.43.142/smarts/login.php";

    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        //EditText
        inpt_email=(EditText)findViewById(R.id.et_mail);
        inpt_pass=(EditText)findViewById(R.id.et_pass);

        //Button
        Login=(Button)findViewById(R.id.btn_loginbutton);
        Guest=(Button)findViewById(R.id.btn_guest);

        //TextView

        Registration= (TextView) findViewById(R.id.tv_registration);


        //Listeners

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inpt_email.getText().toString();
                String password = inpt_pass.getText().toString();

                if (email.trim().length()>0 && password.trim().length()>0)
                {
                    bg bgobj = new bg();
                    bgobj.execute(email, password);

                   /* Intent i =new Intent(MainActivity.this,MenusActivity.class);*/
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Check Connection",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Registration_Activity.class);
                startActivity(i);
                finish();
            }
        });


        Guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii=new Intent(MainActivity.this,MenusActivity.class);
                startActivity(ii);
                finish();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        MyApplication app = (MyApplication) getApplication();

        if (!SystemRequirementsChecker.checkWithDefaultDialogs(this)) {
            Log.e(TAG, "Can't scan for beacons, some pre-conditions were not met");
            Log.e(TAG, "Read more about what's required at: http://estimote.github.io/Android-SDK/JavaDocs/com/estimote/sdk/SystemRequirementsChecker.html");
            Log.e(TAG, "If this is fixable, you should see a popup on the app's screen right now, asking to enable what's necessary");
        } else if (!app.isBeaconNotificationsEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            app.enableBeaconNotifications();
        }
    }
    String response="";
    String result="";


    private static final String TAG = "NIGGAAAH@!";



    public class bg extends AsyncTask<String, Void, String> {




        @Override
        protected String doInBackground(String... params) {

            try {

                String email = params[0];
                String password = params[1];


                Log.e(TAG, email+password);

                URL url = new URL("http://192.168.43.142/smarts/login.php");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");
                con.setRequestMethod("POST");

                JSONObject jobject = new JSONObject();


                jobject.put("email", email);
                jobject.put("password", password);


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

                        Log.e("Result",response);
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



            if(result1.equals("success")){
                inpt_email = (EditText)findViewById(R.id.et_mail);
                String emailforsesson=inpt_email.getText().toString();
                Log.e("emailfor",emailforsesson);
                session.createLoginSession(emailforsesson);
                Intent i=new Intent(MainActivity.this,MenusActivity.class);
                startActivity(i);


            }
            else {

                Toast.makeText(MainActivity.this,"Check Your Internet Connection",Toast.LENGTH_LONG).show();

            }





        }


    }



}

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

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Registration_Activity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
/*
    private final String serverUrl = "http://192.168.43.85/smarts/register.php";
*/

    private final String serverUrl = "http://192.168.43.142/smarts/register.php";


    EditText Name,Email,Password,Contact;
    Button Register;
    TextView linkFORlogin;
/*
    String name,email,password,cno;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Name= (EditText) findViewById(R.id.et_Name);
        Email= (EditText) findViewById(R.id.et_email);
        Password= (EditText) findViewById(R.id.et_password);
        Contact= (EditText) findViewById(R.id.et_Contact);

        //Button

        Register=(Button)findViewById(R.id.btn_Registration);

        //TextviEW

        linkFORlogin=(TextView)findViewById(R.id.tv_linkFORlogin);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = Name.getText().toString();
                final String email = Email.getText().toString();
                final String password = Password.getText().toString();
                final String cno = Contact.getText().toString();
                Log.e("First check", name + email + password + cno);

                if (name.trim().length() > 0 && email.trim().length()>0 ) {
                    bg obj = new bg();

                    obj.execute(name, email, password, cno);

                }
                else
                {
                    Name.setText("Enter Your Name");
                    Email.setText("Enter Your Email");
                }
            }
        });

        linkFORlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Registration_Activity.this,MainActivity.class);
                startActivity(intent);
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
                String password = params[2];
                String cno = params[3];

                Log.e("Chheckk", name+email+password+cno);

                URL url = new URL("http://192.168.43.142/smarts/register.php");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");
                con.setRequestMethod("POST");

                JSONObject jobject = new JSONObject();

                jobject.put("name", name);
                jobject.put("email", email);
                jobject.put("password", password);
                jobject.put("contact", cno);

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
                Intent i=new Intent(Registration_Activity.this,MainActivity.class);
                startActivity(i);



            }
            else {
                Toast.makeText(Registration_Activity.this,"check your connection", Toast.LENGTH_LONG).show();


            }




        }


    }
}

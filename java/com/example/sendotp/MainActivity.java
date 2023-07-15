package com.example.sendotp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    //Random random = new Random();
   // int otp = 100000 + random.nextInt(900000);
    //String ot = Integer.valueOf(otp).toString().trim();
     EditText mobileno;
     EditText name;
    //String no;

    String otpCode = String.valueOf((int) (Math.random() * 900000) + 100000);
    TextView Captcha ;






    private Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileno=findViewById(R.id.phone_numbers);
        sendsms=findViewById(R.id.send_otp);
        name = findViewById(R.id.name);



        //Performing action on button click
        sendsms.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View arg0) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

                    sendSMS();

                }
                else{
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},100);
                }

            }






            public void sendSMS() {

                String no =  mobileno.getText().toString().trim();
                String names = name.getText().toString().trim();
                String message = "Your OTP is " + otpCode;
                ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                loadingProgressBar.setVisibility(View.VISIBLE);
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();

                if (!no.isEmpty()) {

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(no, null, message, null, null);

                    System.out.println(otpCode);
                    System.out.println(no);
                    System.out.println(names);


                    Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                            Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "please enter phone number",
                            Toast.LENGTH_LONG).show();
                }
                Intent intent1 = new Intent(MainActivity.this, receiveOTP.class);
                intent1.putExtra("otp_code", otpCode);
                intent1.putExtra("phone_no", no);
                intent1.putExtra("yourN",names);

                startActivity(intent1);

                progressDialog.dismiss();
                finish();

            }


    });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}

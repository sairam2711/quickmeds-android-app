package com.example.sendotp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    private Button sign;

    receiveOTP obj = new receiveOTP();
    long check = obj.newRowId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sign = (Button) findViewById(R.id.sign);




        //String password = prefs.getString("password", null);








        sign.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent2 = new Intent(Profile.this, MainActivity.class);
                startActivity(intent2);
                finish();


            }
        });
    }

}
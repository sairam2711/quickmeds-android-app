package com.example.sendotp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile2 extends AppCompatActivity {
    String EnteredName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        EnteredName = getIntent().getStringExtra("name").trim();
        TextView text = findViewById(R.id.text1);
        text.setText(EnteredName);
        Button button = findViewById(R.id.my_cart);
        Button button1 = findViewById(R.id.MyOrders);
        Button button2 = findViewById(R.id.lodO);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(Profile2.this,MyCart.class);
            i.putExtra("name4",EnteredName);
            startActivity(i);


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile2.this,MyOrder.class);
                i.putExtra("name4",EnteredName);
                startActivity(i);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper dbHelper = new MyDatabaseHelper(Profile2.this);
                dbHelper.deleteRecord(EnteredName);
                Intent i = new Intent(Profile2.this,Profile.class);
                startActivity(i);
                finish();


            }
        });
    }
}
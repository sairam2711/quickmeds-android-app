package com.example.sendotp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Check_address extends AppCompatActivity {
     TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_address);

        textView = findViewById(R.id.phone);



    }

    public void updateTextView(String inputText) {
        textView.setText(inputText);
    }
}
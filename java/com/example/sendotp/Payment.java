package com.example.sendotp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Payment extends AppCompatActivity {
    int no = 1;
    final int UPI_PAYMENT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Button button2 = findViewById(R.id.online_pay);

        // In your activity or fragment

       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent share = new Intent(android.content.Intent.ACTION_SEND);

               share.setType("text/plain");

               share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

               share.putExtra(Intent.EXTRA_SUBJECT, "hi this my app");
               Intent intent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
               if (intent != null) {
                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   startActivity(intent);
               } else {
                   // Paytm app not installed, redirect to Google Play Store
                   startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tcpoongavanam")));
               }

               share.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());

               startActivity(Intent.createChooser(share, "select your payment app"));
           }
       });








    }

    public void cashOd(View view) {
        String name2 = getIntent().getStringExtra("name2");
        String name = getIntent().getStringExtra("name");
        String phoneno = getIntent().getStringExtra("phoneno");
        String pinCode = getIntent().getStringExtra("pincode");
        String state = getIntent().getStringExtra("state");
        String city = getIntent().getStringExtra("city");
        String productname = getIntent().getStringExtra("product name");
        String quantity = getIntent().getStringExtra("quantity");
        String price = getIntent().getStringExtra("price");
        String image = getIntent().getStringExtra("image");

        DatabaseReference childRef = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("product name" + no);
        //DatabaseReference userRef = database.getReference(userPath);
        DatabaseReference childRef1 = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("quantity" + no);
        DatabaseReference childRef2 = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("price" + no);
        DatabaseReference childRef3 = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("image" + no);
        DatabaseReference childRef4 = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("name" + no);
        DatabaseReference childRef5 = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("phone number-" + no);
        DatabaseReference childRef6 = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("pincode" + no);
        DatabaseReference childRef7 = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("state" + no);
        DatabaseReference childRef8 = FirebaseDatabase.getInstance().getReference().child("users").child(name2).child("orders").child("city" + no);
// Insert data into the new child node
        childRef.setValue(productname);
        childRef1.setValue(quantity);
        childRef2.setValue(price);
        childRef3.setValue(image);
        childRef4.setValue(name);
        childRef5.setValue(phoneno);
        childRef6.setValue(pinCode);
        childRef7.setValue(state);
        childRef8.setValue(city);
        no++;
        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
        loadingProgressBar.setVisibility(View.VISIBLE);
        ProgressDialog progressDialog = new ProgressDialog(Payment.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();


        Toast.makeText(getApplicationContext(), "ordered successfully",
                Toast.LENGTH_LONG).show();


        progressDialog.dismiss();


    }
}

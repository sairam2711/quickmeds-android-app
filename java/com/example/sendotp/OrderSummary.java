package com.example.sendotp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class OrderSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
        loadingProgressBar.setVisibility(View.VISIBLE);
        ProgressDialog progressDialog = new ProgressDialog(OrderSummary.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        String name = getIntent().getStringExtra("name");
        String phoneno = getIntent().getStringExtra("phoneno");
        String pinCode = getIntent().getStringExtra("pincode");
        String state = getIntent().getStringExtra("state");
        String city = getIntent().getStringExtra("city");
        String productname = getIntent().getStringExtra("product name");
        String quantity = getIntent().getStringExtra("quantity");
        String price = getIntent().getStringExtra("price");



        String address = getIntent().getStringExtra("address");
        String address2 = getIntent().getStringExtra("address2");


        TextView text1 = findViewById(R.id.textView4);
        TextView text2 = findViewById(R.id.textView5);
        TextView text3 = findViewById(R.id.textView6);
        TextView text4 = findViewById(R.id.textView7);
        TextView text5 = findViewById(R.id.textView8);
        TextView text6 = findViewById(R.id.textView9);
        TextView text7 = findViewById(R.id.textView10);
        TextView text8 = findViewById(R.id.price);
        //TextView text9 = findViewById(R.id.textView11);
        TextView text9 = findViewById(R.id.textView12);
        TextView text10 = findViewById(R.id.textView13);
        TextView text11 = findViewById(R.id.textView14);
        TextView text12 = findViewById(R.id.textView15);

        ImageView Image = findViewById(R.id.imageView);
        String image = getIntent().getStringExtra("image");
        System.out.println(image);
        // Use the downloadUrl to display the image in your ImageVie
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef1 = storage.getReferenceFromUrl(image);

        storageRef1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(OrderSummary.this).load(uri).into(Image);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

        text5.setText(productname);
        text6.setText(quantity);
        text7.setText(price);
        text1.setText(name);
        text2.setText(address+""+address2);
        text3.setText(pinCode);
        text4.setText(phoneno);
        text8.setText(price);
        text9.setText("price:375");
        text10.setText("discount:56");
        text11.setText("Delivery Charges:Free Delivery");
        text12.setText("total Amount:"+price);

        progressDialog.dismiss();



    }

    public void Continue(View view){
        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
        loadingProgressBar.setVisibility(View.VISIBLE);
        ProgressDialog progressDialog = new ProgressDialog(OrderSummary.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
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
        Intent i = new Intent(OrderSummary.this,Payment.class);
        i.putExtra("name2",name2);
        i.putExtra("name",name);
        i.putExtra("phoneno",phoneno);
        i.putExtra("pincode",pinCode);
        i.putExtra("state",state);
        i.putExtra("city",city);
        i.putExtra("product name",productname);
        i.putExtra("quantity",quantity);
        i.putExtra("price",price);
        i.putExtra("image",image);
        startActivity(i);
        progressDialog.dismiss();



    }
}
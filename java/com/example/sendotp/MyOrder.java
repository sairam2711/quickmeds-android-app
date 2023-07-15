package com.example.sendotp;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MyOrder extends AppCompatActivity {

    MyDatabaseHelper mydb = new MyDatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        TextView text1 = findViewById(R.id.textView17);
        TextView text2 = findViewById(R.id.textView18);
        TextView text3 = findViewById(R.id.textView19);
        ImageView image3 = findViewById(R.id.image1);
        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
        loadingProgressBar.setVisibility(View.VISIBLE);
        ProgressDialog progressDialog = new ProgressDialog(MyOrder.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        Cursor res1 = mydb.getAllData();
        if (res1.moveToFirst()) {
            String name = res1.getString(0);

            String userPath = name + "/orders";
            DatabaseReference usersRef1 = FirebaseDatabase.getInstance().getReference("users/" + userPath);

            usersRef1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    DatabaseReference nameRef = usersRef1.child("product name1");
                    DatabaseReference QuantityRef = usersRef1.child("quantity1");
                    DatabaseReference priceRef = usersRef1.child("price1");
                    DatabaseReference imageRef = usersRef1.child("image1");

                    nameRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String name = snapshot.getValue(String.class);
                            if(name!=null){
                                text1.setText(name);
                                Log.d(TAG, "Name is: " + name);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "data not found",
                                        Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.w(TAG, "Failed to read name.", error.toException());
                        }
                    });
                    QuantityRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String Quantity = snapshot.getValue(String.class);
                            if(Quantity!= null){
                                text2.setText(Quantity);
                                Log.d(TAG, "Name is: " + Quantity);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "data not found",
                                        Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.w(TAG, "Failed to read name.", error.toException());
                        }
                    });
                    priceRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String price = snapshot.getValue(String.class);
                            if(price!=null){
                                text3.setText(price);
                                Log.d(TAG, "Name is: " + price);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "data not found",
                                        Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.w(TAG, "Failed to read name.", error.toException());
                        }
                    });

                    imageRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String image = snapshot.getValue(String.class);
                            if(image!=null){
                                FirebaseStorage storage = FirebaseStorage.getInstance();
                                StorageReference storageRef1 = storage.getReferenceFromUrl(image);
                                storageRef1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        // Use the downloadUrl to display the image in your ImageView
                                        //ImageView imageView = findViewById(R.id.image_view);
                                        Glide.with(MyOrder.this).load(uri).into(image3);
                                    }


                                });
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "data not found",
                                        Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.w(TAG, "Failed to read name.", error.toException());
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.w(TAG, "Failed to read name.", error.toException());

                }


            });
            progressDialog.dismiss();
        }




    }
}
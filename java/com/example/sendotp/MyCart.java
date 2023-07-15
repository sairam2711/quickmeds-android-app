package com.example.sendotp;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MyCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        String name4 = getIntent().getStringExtra("name4").trim();
        String userPath = name4 + "/cart";
        DatabaseReference usersRef1 = FirebaseDatabase.getInstance().getReference("users/" + userPath);
        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        TextView textView3 = findViewById(R.id.text3);
        ImageView image1 = findViewById(R.id.image1);
        TextView textView4 = findViewById(R.id.text4);
        TextView textView5 = findViewById(R.id.text5);
        TextView textView6 = findViewById(R.id.text6);
        ImageView image2 = findViewById(R.id.image2);

        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
        loadingProgressBar.setVisibility(View.VISIBLE);
        ProgressDialog progressDialog = new ProgressDialog(MyCart.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();



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
                        if(name!=null) {
                            textView1.setText(name);
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
                        if(Quantity !=null) {
                            textView2.setText(Quantity);
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
                        if(price!=null) {

                            textView3.setText(price);
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
                        if (image != null) {


                            FirebaseStorage storage = FirebaseStorage.getInstance();
                            StorageReference storageRef1 = storage.getReferenceFromUrl(image);
                            storageRef1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    // Use the downloadUrl to display the image in your ImageView
                                    //ImageView imageView = findViewById(R.id.image_view);
                                    Glide.with(MyCart.this).load(uri).into(image2);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    // Handle any errors
                                }
                            });
                            Log.d(TAG, "Name is: " + image);
                        }else{
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

        usersRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DatabaseReference nameRef = usersRef1.child("product name2");
                DatabaseReference QuantityRef = usersRef1.child("quantity2");
                DatabaseReference priceRef = usersRef1.child("price2");
                DatabaseReference imageRef = usersRef1.child("image2");

                nameRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String name = snapshot.getValue(String.class);
                        if(name!=null) {
                            textView4.setText(name);
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
                        if(Quantity!=null) {
                            textView5.setText(Quantity);
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
                        if(price!=null) {
                            textView6.setText(price);
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

                            FirebaseStorage storage = FirebaseStorage.getInstance();
                        if(image!= null) {
                            StorageReference storageRef1 = storage.getReferenceFromUrl(image);

                            storageRef1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    // Use the downloadUrl to display the image in your ImageView
                                    //ImageView imageView = findViewById(R.id.image_view);
                                    Glide.with(MyCart.this).load(uri).into(image1);
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
package com.example.sendotp;

import static android.R.layout;
import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class homePage extends AppCompatActivity {
    MyDatabaseHelper mydb = new MyDatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageView category= findViewById(R.id.category);

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    String name = res1.getString(0);
                    Intent i = new Intent(homePage.this, category.class);
                    i.putExtra("name3", name);
                    startActivity(i);
                }
            }
        });

        String[] cities = {"chennai", "kerala", "kanniyakumari", "pondicherry", "thoraipakkam", "pallavaram", "coimbathor", "thambaram", "cheggalpattu", "thiruvanmure"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.city_spinner);
        spinner.setAdapter(adapter);
        Button cityButton = findViewById(R.id.button);
        ImageView imageView1 = findViewById(R.id.imageview1);
        ImageView imageView2 = findViewById(R.id.imageview2);
        ImageView imageView3 = findViewById(R.id.imageview3);
        ImageView imageView4 = findViewById(R.id.imageview4);
        ImageView imageView5 = findViewById(R.id.imageview5);
        ImageView imageView6 = findViewById(R.id.imageview6);
        ImageView imageView7 = findViewById(R.id.imageview7);
        ImageView imageView8 = findViewById(R.id.imageview8);
        ImageView imageView9 = findViewById(R.id.imageview9);
        ImageView imageView10 = findViewById(R.id.imageview10);
        ImageView imageView11 = findViewById(R.id.imageview11);
        ImageView imageView12 = findViewById(R.id.imageview12);
        ImageView imageView13 = findViewById(R.id.imageview13);
        ImageView imageView14 = findViewById(R.id.imageview14);



                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageRef1 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/juices and vinegars.jpeg");
                StorageReference storageRef2 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/test strips and lancets.jpeg");
                StorageReference storageRef3 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/sugar subsitutes.jpeg");
                StorageReference storageRef4 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/blood glucose monitors.jpeg");
        StorageReference storageRef5 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/antifungal.jpeg");
        StorageReference storageRef6 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/acne.jpeg");
        StorageReference storageRef7 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/skin.jpeg");
        StorageReference storageRef8 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/dry.jpeg");
        StorageReference storageRef9 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/skinpigmentation.jpeg");
        StorageReference storageRef10 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/balms.jpeg");
        StorageReference storageRef11 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/ortho.jpeg");
        StorageReference storageRef12 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/body.jpeg");
        StorageReference storageRef13 = storage.getReferenceFromUrl("gs://android-app-98dcd.appspot.com/pain.jpeg");
                //StorageReference imageRef = storageRef.child("gs://android-app-98dcd.appspot.com/juices and vinegars.jpeg");

                storageRef2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Use the downloadUrl to display the image in your ImageView
                        //ImageView imageView = findViewById(R.id.image_view);
                        Glide.with(homePage.this).load(uri).into(imageView3);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

                storageRef3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Use the downloadUrl to display the image in your ImageView
                        //ImageView imageView = findViewById(R.id.image_view);
                        Glide.with(homePage.this).load(uri).into(imageView4);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });
                storageRef4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Use the downloadUrl to display the image in your ImageView
                        //ImageView imageView = findViewById(R.id.image_view);
                        Glide.with(homePage.this).load(uri).into(imageView5);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

                storageRef1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Use the downloadUrl to display the image in your ImageView
                        //ImageView imageView = findViewById(R.id.image_view);
                        Glide.with(homePage.this).load(uri).into(imageView2);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

        storageRef5.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView6);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        storageRef6.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView7);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        storageRef7.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView8);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        storageRef8.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView9);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        storageRef9.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView10);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        storageRef10.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView11);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        storageRef11.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView12);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        storageRef12.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView13);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        storageRef13.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(homePage.this).load(uri).into(imageView14);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

               imageView1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        new RetrieveValueTask().execute();
                        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                        loadingProgressBar.setVisibility(View.VISIBLE);
                        ProgressDialog progressDialog = new ProgressDialog(homePage.this);
                        progressDialog.setMessage("Loading...");
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        progressDialog.show();
                        progressDialog.dismiss();
                    }
                });

                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Cursor res1 = mydb.getAllData();
                        if (res1.moveToFirst()) {
                            String name = res1.getString(0);
                            ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                            loadingProgressBar.setVisibility(View.VISIBLE);
                            ProgressDialog progressDialog = new ProgressDialog(homePage.this);
                            progressDialog.setMessage("Loading...");
                            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progressDialog.show();
                            Intent intent1 = new Intent(homePage.this, Juice_andv.class);
                            intent1.putExtra("product1","Axiom Aloevera Diabetes cod-32 juice");
                            intent1.putExtra("quantity1","bottle of 1000ml");
                            intent1.putExtra("price1","₹319");
                            intent1.putExtra("image1","gs://android-app-98dcd.appspot.com/alovera diabetes.jpeg");
                            intent1.putExtra("product2","DrPatkars Apple Cider Vinegar With Garlic and Honey");
                            intent1.putExtra("quantity2","bottle of 1000ml");
                            intent1.putExtra("price2","₹675");
                            intent1.putExtra("image2","gs://android-app-98dcd.appspot.com/apple cider.jpeg");
                            intent1.putExtra("product3","Apple cider Vinegar juice");
                            intent1.putExtra("quantity3","bottle of 1000ml");
                            intent1.putExtra("price3","₹400");
                            intent1.putExtra("image3","gs://android-app-98dcd.appspot.com/apple_cider1.jpeg");
                            intent1.putExtra("name3", name);
                            startActivity(intent1);
                            progressDialog.dismiss();

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "please sign in",
                                    Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(homePage.this, Profile.class);
                            startActivity(intent);
                        }
                    }
                });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    String name = res1.getString(0);
                    ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    ProgressDialog progressDialog = new ProgressDialog(homePage.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    Intent intent1 = new Intent(homePage.this, Juice_andv.class);
                    intent1.putExtra("product1","glucose test strips and lancet combo pack");
                    intent1.putExtra("quantity1","blood glucose 50 test strip and microlet colores 100 lancets");
                    intent1.putExtra("price1","₹1265");
                    intent1.putExtra("image1","gs://android-app-98dcd.appspot.com/test/test1.jpeg");
                    intent1.putExtra("product2","combo pack of one touch verio");
                    intent1.putExtra("quantity2","one touch delica plus 25 lancet");
                    intent1.putExtra("price2","₹1392");
                    intent1.putExtra("image2","gs://android-app-98dcd.appspot.com/test/test2.jpeg");
                    intent1.putExtra("product3","dr morepen combo pack of BG -03");
                    intent1.putExtra("quantity3","50 test strips and 100 lancets");
                    intent1.putExtra("price3","₹1403");
                    intent1.putExtra("image3","gs://android-app-98dcd.appspot.com/test/test3.jpeg");
                    intent1.putExtra("name3", name);
                    startActivity(intent1);
                    progressDialog.dismiss();

                }
                else{
                    Toast.makeText(getApplicationContext(), "please sign in",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(homePage.this, Profile.class);
                    startActivity(intent);
                }
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    String name = res1.getString(0);
                    ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    ProgressDialog progressDialog = new ProgressDialog(homePage.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    Intent intent1 = new Intent(homePage.this, Juice_andv.class);
                    intent1.putExtra("product1","combo pack of sugar free gold low calorie sweetener");
                    intent1.putExtra("quantity1","neurobian forte tablet");
                    intent1.putExtra("price1","₹317");
                    intent1.putExtra("image1","gs://android-app-98dcd.appspot.com/sugar/sugar3.jpeg");
                    intent1.putExtra("product2","warm milk mix recipe of turmeric drops with piperine");
                    intent1.putExtra("quantity2","buy 1 get 1 free 225gm");
                    intent1.putExtra("price2","₹545");
                    intent1.putExtra("image2","gs://android-app-98dcd.appspot.com/sugar/sugar2.jpeg");
                    intent1.putExtra("product3","anti-oxidants combo of organic india lemon ginger");
                    intent1.putExtra("quantity3","tulsi green tea 25 tea bag and dabur honey 1kg");
                    intent1.putExtra("price3","₹599");
                    intent1.putExtra("image3","gs://android-app-98dcd.appspot.com/sugar/sugar1.jpeg");
                    intent1.putExtra("name3", name);
                    startActivity(intent1);
                    progressDialog.dismiss();

                }
                else{
                    Toast.makeText(getApplicationContext(), "please sign in",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(homePage.this, Profile.class);
                    startActivity(intent);
                }
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    String name = res1.getString(0);
                    ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    ProgressDialog progressDialog = new ProgressDialog(homePage.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    Intent intent1 = new Intent(homePage.this, Juice_andv.class);
                    intent1.putExtra("product1","contour plus elite blood glucose monitoring sysytem glucometer");
                    intent1.putExtra("quantity1","glucose test strip 20s free");
                    intent1.putExtra("price1","₹1032");
                    intent1.putExtra("image1","gs://android-app-98dcd.appspot.com/blood/blood1.jpeg");
                    intent1.putExtra("product2","dr morepen bg 03 gluco one glucose monitoring system");
                    intent1.putExtra("quantity2","glucometer with glucose 25 test strip");
                    intent1.putExtra("price2","₹508");
                    intent1.putExtra("image2","gs://android-app-98dcd.appspot.com/blood/blood2.jpeg");
                    intent1.putExtra("product3","accu-chek active blood glucometer kit");
                    intent1.putExtra("quantity3","box of 10 test strips free");
                    intent1.putExtra("price3","₹902");
                    intent1.putExtra("image3","gs://android-app-98dcd.appspot.com/blood/blood3.jpeg");
                    intent1.putExtra("name3", name);
                    startActivity(intent1);
                    progressDialog.dismiss();

                }
                else{
                    Toast.makeText(getApplicationContext(), "please sign in",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(homePage.this, Profile.class);
                    startActivity(intent);
                }
            }
        });

                cityButton.setBackgroundColor(Color.WHITE);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedCity = (String) parent.getItemAtPosition(position);

                        cityButton.setText(selectedCity);
                        // Do something with the selected city
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing
                    }
                });




    }

    public void juices(View view) {
        new RetrieveValueTask().execute();

    }

    private class RetrieveValueTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            // Retrieve value from SQLite database
            String name = null;

            try {
                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    name = res1.getString(0);


                }
                res1.close();

            } catch (Exception e) {
                Log.e(TAG, "Error retrieving value from database: " + e.getMessage());
            } finally {
                if (mydb != null) {
                    mydb.close();
                }
            }
            return name;
        }
        @Override
        protected void onPostExecute(String name) {
            if (name != null) {
                // Start new activity with the retrieved value
                Intent intent = new Intent(homePage.this, Profile2.class);
                intent.putExtra("name",name);
                startActivity(intent);
            } else {
                // Handle error
                Intent intent = new Intent(homePage.this, Profile.class);
                startActivity(intent);
            }
        }
    }
}
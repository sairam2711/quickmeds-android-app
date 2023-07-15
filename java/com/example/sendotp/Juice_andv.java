package com.example.sendotp;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

import java.util.Arrays;
import java.util.List;

public class Juice_andv extends AppCompatActivity {

    private Context context;

    String product, product2;

    int no = 1;
    int no1=1;
    int no2= 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_andv);

        String product1 = getIntent().getStringExtra("product1");
        String quantity1 = getIntent().getStringExtra("quantity1");
        String price1 = getIntent().getStringExtra("price1");
        String image1 = getIntent().getStringExtra("image1");
        String product2 = getIntent().getStringExtra("product2");
        String quantity2 = getIntent().getStringExtra("quantity2");
        String price2 = getIntent().getStringExtra("price2");
        String image2 = getIntent().getStringExtra("image2");
        String product3 = getIntent().getStringExtra("product3");
        String quantity3 = getIntent().getStringExtra("quantity3");
        String price3 = getIntent().getStringExtra("price3");
        String image3 = getIntent().getStringExtra("image3");


        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference aloevera_diabetes = storage.getReferenceFromUrl(image1);
        StorageReference apple_cider = storage.getReferenceFromUrl(image2);
        StorageReference apple_cider1 = storage.getReferenceFromUrl(image3);

        context = this;

        TextView textView = findViewById(R.id.textview1);
        TextView textView1 = findViewById(R.id.textview2);
        TextView product_1 = findViewById(R.id.product1);

        TextView product_2 = findViewById(R.id.product2);
        TextView product_3 = findViewById(R.id.product3);
        TextView product_quantity1 = findViewById(R.id.product_quantity1);
        TextView product_quantity2 = findViewById(R.id.product_quantity2);
        TextView product_quantity3 = findViewById(R.id.product_quantity3);
        TextView product_price1 = findViewById(R.id.product_price1);
        TextView product_price2 = findViewById(R.id.product_price2);
        TextView product_price3 = findViewById(R.id.product_price3);
        ImageView delete = findViewById(R.id.delete);
        ImageView delete1 = findViewById(R.id.delete2);
        TextView hmp = findViewById(R.id.add);
        TextView hmp1 = findViewById(R.id.add_hmp);
        TextView hmp2 = findViewById(R.id.add_hmp2);


        ImageView imageView = findViewById(R.id.alloveradia);
        ImageView imageView1 = findViewById(R.id.apple_cider_v);
        ImageView imageView2 = findViewById(R.id.urban_apple_cider);

        ImageView addSymbol= findViewById(R.id.addSymbol1);
        ImageView addSymbol1 = findViewById(R.id.addSymbol2);

        ImageView downSymbol= findViewById(R.id.downSymbol1);
        ImageView downSymbol1 = findViewById(R.id.downSymbol2);


        Button button2 = findViewById(R.id.add3);
        Button button1 = findViewById(R.id.add1);



        product_1.setText(product1);
        product_2.setText(product2);
        product_3.setText(product3);
        product_quantity1.setText(quantity1);
        product_quantity2.setText(quantity2);
        product_quantity3.setText(quantity3);
        product_price1.setText(price1);
        product_price2.setText(price2);
        product_price3.setText(price3);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        aloevera_diabetes.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(Juice_andv.this).load(uri).into(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
       apple_cider.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(Juice_andv.this).load(uri).into(imageView1);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        apple_cider1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(Juice_andv.this).load(uri).into(imageView2);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name3 = getIntent().getStringExtra("name3");
                Intent intent = new Intent(Juice_andv.this, cod32_juice.class);
                intent.putExtra("name5", name3);
                intent.putExtra("product",product1);
                intent.putExtra("quantity",quantity1);
                intent.putExtra("price",price1);
                intent.putExtra("discount","₹319 M̶R̶P̶ ₹3̶7̶5̶ 15% off");
                intent.putExtra("whendelivery","Earliest delivary by,Monday");
                intent.putExtra("productowner","by Axiom Ayureveda");
                intent.putExtra("image",image1);
                startActivity(intent);

            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name3 = getIntent().getStringExtra("name3");
                Intent intent = new Intent(Juice_andv.this, cod32_juice.class);
                intent.putExtra("name5", name3);
                intent.putExtra("product",product2);
                intent.putExtra("quantity",quantity2);
                intent.putExtra("price",price2);
                intent.putExtra("discount","₹574 M̶R̶P̶ ₹6̶7̶5̶ 15% off");
                intent.putExtra("whendelivery","Earliest delivary by,Monday");
                intent.putExtra("productowner","by Axiom Ayureveda");
                intent.putExtra("image",image2);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name3 = getIntent().getStringExtra("name3");
                Intent intent = new Intent(Juice_andv.this, cod32_juice.class);
                intent.putExtra("name5", name3);
                intent.putExtra("product",product3);
                intent.putExtra("quantity",quantity3);
                intent.putExtra("price",price3);
                intent.putExtra("discount","₹340 M̶R̶P̶ ₹4̶0̶0̶ 15% off");
                intent.putExtra("whendelivery","Earliest delivary by,Monday");
                intent.putExtra("productowner","by Axiom Ayureveda");
                intent.putExtra("image",image3);
                startActivity(intent);
            }
        });


        addSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = String.valueOf(no1);
                hmp.setText(number);
                no1++;

            }
        });

        addSymbol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = String.valueOf(no2);
                hmp1.setText(number);
                no2++;

            }
        });

        downSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no1--;
                String number = String.valueOf(no1);
                hmp.setText(number);

            }
        });

        downSymbol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no2--;
                String number = String.valueOf(no2);
                hmp1.setText(number);

            }
        });


        textView1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                List<String> strings = Arrays.asList("branded", "product form", "prescription required", "uses", "age");

                // Create an ArrayAdapter to display the list of strings
                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, strings);

                // Create a ListView to display the list of strings
                ListView listView = new ListView(context);
                listView.setAdapter(adapter);
                // Create a dialog to display the ListView
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Select one");
                builder.setView(listView);
                AlertDialog dialog = builder.create();


                // Set an OnItemClickListener for the ListView to handle item selections
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Get the selected string
                        String selectedString = (String) parent.getItemAtPosition(position);

                        // Set the selected string as the text of the TextView
                        textView1.setText(selectedString);

                        // Dismiss the dialog
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }


        });


        textView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                List<String> strings = Arrays.asList("Relevance", "popularity", "Average customer rating", "price:low to high", "price:high to low", "Discount");

                // Create an ArrayAdapter to display the list of strings
                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, strings);

                // Create a ListView to display the list of strings
                ListView listView = new ListView(context);
                listView.setAdapter(adapter);
                // Create a dialog to display the ListView
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Select one");
                builder.setView(listView);
                AlertDialog dialog = builder.create();


                // Set an OnItemClickListener for the ListView to handle item selections
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Get the selected string
                        String selectedString = (String) parent.getItemAtPosition(position);

                        // Set the selected string as the text of the TextView
                        textView.setText(selectedString);

                        // Dismiss the dialog
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }


        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView hmp = findViewById(R.id.add);
                String no = (String) hmp.getText();
                if(no.isEmpty()){
                    Toast.makeText(getApplicationContext(), " plz select first how many product you want using + symbol",
                            Toast.LENGTH_LONG).show();

                }
                else{

                    addCart(product1,quantity1,price1,image1);



                }




            }

        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                deleteCart(no1,product1,quantity1,price1);



            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView hmp1 = findViewById(R.id.add);
                String no = (String) hmp1.getText();
                if(no.isEmpty()){
                    Toast.makeText(getApplicationContext(), " plz select first how many product you want using + symbol",
                            Toast.LENGTH_LONG).show();

                }
                else{
                    addCart(product2,quantity2,price2,image2);

                }




            }

        });

        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteCart(no1,product2,quantity2,price2);
            }
        });




    }

    public void allovera(View view) {
        String name3 = getIntent().getStringExtra("name3");
        Intent intent = new Intent(Juice_andv.this, cod32_juice.class);
        intent.putExtra("name5", name3);
        startActivity(intent);
    }
     public void addCart(String product,String quantity,String price,String image){



         String name3 = getIntent().getStringExtra("name3");
         TextView hmp = findViewById(R.id.add);
         String number = (String) hmp.getText();

         ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
         loadingProgressBar.setVisibility(View.VISIBLE);
         ProgressDialog progressDialog = new ProgressDialog(Juice_andv.this);
         progressDialog.setMessage("Loading....");
         progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
         progressDialog.show();

         String userPath = "users/" + name3;
         DatabaseReference childRef = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("product name1" );
         //DatabaseReference userRef = database.getReference(userPath);
         DatabaseReference childRef1 = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("quantity1");
         DatabaseReference childRef2 = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("price1");
         DatabaseReference childRef3 = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("image1");
         DatabaseReference childRef4 = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("number of products1");
         //DatabaseReference staffRef = userRef.push().child("cart/");

         // Loop through the array of values and insert each one into the database
         childRef.addListenerForSingleValueEvent(new ValueEventListener() {



             public void onDataChange(DataSnapshot dataSnapshot) {

                 String storedEmail = dataSnapshot.getValue(String.class);
                 //String password = userSnapshot.child("users").child("staff").child("password").getValue(String.class);
                 if (product.equals(storedEmail) ) {
                     Toast.makeText(getApplicationContext(), "your already added this cart",
                             Toast.LENGTH_LONG).show();

                 }
                 else{
                     childRef.setValue(product);
                     childRef1.setValue(quantity);
                     childRef2.setValue(price);
                     childRef3.setValue(image);
                     childRef4.setValue(number);

                     Toast.makeText(getApplicationContext(), " successfully added to cart",
                             Toast.LENGTH_LONG).show();


                 }

             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.e(TAG, "onCancelled", databaseError.toException());
             }
         } );
         no++;

         progressDialog.dismiss();
     }




             public void deleteCart(int no2,String product,String quantity,String price){



        no2--;
        no--;
         String name3 = getIntent().getStringExtra("name3");
         String number = String.valueOf(no2);
         ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
         loadingProgressBar.setVisibility(View.VISIBLE);
         ProgressDialog progressDialog = new ProgressDialog(Juice_andv.this);
         progressDialog.setMessage("Loading...");
         progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
         progressDialog.show();

         String userPath = "users/" + name3;
         DatabaseReference childRef = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("product name1");
         //DatabaseReference userRef = database.getReference(userPath);
         DatabaseReference childRef1 = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("quantity1");
         DatabaseReference childRef2 = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("price1" );
         //DatabaseReference childRef3 = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("image" + no);
         //DatabaseReference staffRef = userRef.push().child("cart/");
         DatabaseReference childRef4 = FirebaseDatabase.getInstance().getReference().child("users").child(name3).child("cart").child("number of products1" );

         // Loop through the array of values and insert each one into the database
         childRef.removeValue();
         childRef1.removeValue();
         childRef2.removeValue();
         //childRef3.removeValue();
         childRef4.removeValue();

         Toast.makeText(getApplicationContext(), " successfully removed from cart",
                 Toast.LENGTH_LONG).show();
         progressDialog.dismiss();

     }
}

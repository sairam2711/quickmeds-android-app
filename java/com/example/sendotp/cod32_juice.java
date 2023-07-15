package com.example.sendotp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class cod32_juice extends AppCompatActivity {
    private Button aloevera;
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod32_juice);

        Button prescription = findViewById(R.id.prescription);
        ImageView presimage =findViewById(R.id.prescriptionImage);
        prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        String name = getIntent().getStringExtra("name3");

// Create a reference to the image file using the path in Firebase Realtime Database
        StorageReference imageRef = storageRef.child("images/" +name);

// Retrieve the download URL for the image and load it into the ImageView
        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(cod32_juice.this)
                        .load(uri)
                        .into(presimage);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

        aloevera = findViewById(R.id.aloevera_button);

        String product = getIntent().getStringExtra("product");
        String quantity = getIntent().getStringExtra("quantity");
        String price = getIntent().getStringExtra("price");
        String discount = getIntent().getStringExtra("discount");
        String whendelivery = getIntent().getStringExtra("whendelivery");
        String productowner = getIntent().getStringExtra("productowner");
        String image = getIntent().getStringExtra("image");

        ImageView productImage = findViewById(R.id.imageView3);
        TextView  productName = findViewById(R.id.product_name);
        TextView  productOwner = findViewById(R.id.product_owner);
        TextView  quantity1 = findViewById(R.id.quantity);
        TextView  whenDelivery = findViewById(R.id.when_delivery);
        TextView  Discount = findViewById(R.id.discount);
        TextView  productPrice = findViewById(R.id.price);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference productI = storage.getReferenceFromUrl(image);

       productI.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use the downloadUrl to display the image in your ImageView
                //ImageView imageView = findViewById(R.id.image_view);
                Glide.with(cod32_juice.this).load(uri).into(productImage);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
       productName.setText(product);
       productOwner.setText(productowner);
       quantity1.setText(quantity);
       whenDelivery.setText(whendelivery);
       Discount.setText(discount);
       productPrice.setText(price);



        /*aloevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper mydb = new MyDatabaseHelper(cod32_juice.this);
                Cursor res = mydb.getAllData();
                if (res.moveToFirst()) {
                    String name2 = res.getString(0);
                    Intent intent = new Intent(cod32_juice.this, Add_address.class);
                    intent.putExtra("name2",name2);
                    intent.putExtra("product name","Axiom Aloevera Diabetes Cod-32 Juice");
                    intent.putExtra("quantity","bottle of 1000ml");
                    intent.putExtra("price","₹675");
                    intent.putExtra("image","gs://android-app-98dcd.appspot.com/alovera diabetes.jpeg");
                    startActivity(intent);
                }
            }
        });*/


    }
    public void aloevera(View view ){
        MyDatabaseHelper mydb = new MyDatabaseHelper(cod32_juice.this);
        Cursor res = mydb.getAllData();
        if (res.moveToFirst()) {
            String name2 = res.getString(0);
            String product = getIntent().getStringExtra("product");
            String quantity = getIntent().getStringExtra("quantity");
            String price = getIntent().getStringExtra("price");
            String image = getIntent().getStringExtra("image");
            Intent intent = new Intent(cod32_juice.this, Add_address.class);
            intent.putExtra("name2",name2);
            intent.putExtra("product name",product);
            intent.putExtra("quantity",quantity);
            intent.putExtra("price",price);
            intent.putExtra("image",image);
            startActivity(intent);
        }

    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            StorageReference storageRef = FirebaseStorage.getInstance().getReference();
            String name = getIntent().getStringExtra("name3");
            StorageReference imageRef = storageRef.child("images/" +name);
            imageRef.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Image upload success, store the image URL in Firebase Realtime Database
                            imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
                                    String name = getIntent().getStringExtra("name3");
                                    databaseRef.child("images/"+name).push().setValue(uri.toString());
                                    Toast.makeText(getApplicationContext(), "successfully uploaded image",
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Image upload failure
                        }
                    });
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(uri));
    }
}
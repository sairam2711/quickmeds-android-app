package com.example.sendotp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Add_address extends AppCompatActivity {

    private EditText phoneno;
    private EditText name;
    private EditText pinC;
    private EditText state;
    private EditText city;
    private EditText Address;
    private EditText Address2;
    private Button saveB;
    private LocationManager locationManager;
    String na, phone, pinCode, State, City, address, address2;
    Connection connection;
    int startUserId = 0; // initialize the starting user id
    int numUsers = 0;
    int i = startUserId;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        Button currentL = findViewById(R.id.current_location);
        currentL.setOnClickListener(new View.OnClickListener() {
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(Add_address.this);
            @Override
            public void onClick(View view) {
                getLastLocation();
// Insert data into the new child node


            }

            private void getLastLocation() {
                if (ContextCompat.checkSelfPermission(Add_address.this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if(location!=null){
                                Geocoder geocoder = new Geocoder(Add_address.this, Locale.getDefault());
                                List<android.location.Address> addresses = null;
                                try {
                                    ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                                    loadingProgressBar.setVisibility(View.VISIBLE);
                                    ProgressDialog progressDialog = new ProgressDialog(Add_address.this);
                                    progressDialog.setMessage("Loading...");
                                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                    progressDialog.show();
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    String name2 = getIntent().getStringExtra("name2");
                                    String userPath = "users/"+name2;

                                    DatabaseReference userRef = database.getReference(userPath);
                                    DatabaseReference staffRef = userRef.child("OrderAddress/"+name2);
                                    addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                                    String Addresses = addresses.get(0).getAddressLine(0);
                                    String locality = addresses.get(0).getLocality();
                                    String country = addresses.get(0).getCountryName();
                                    String pinCode = addresses.get(0).getPostalCode();

                                    na = name.getText().toString().trim();

                                    phone = phoneno.getText().toString().trim();
                                    address2 = Address2.getText().toString().trim();
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("name", na);
                                    map.put("phoneno", phone);
                                    map.put("pincode", pinCode);
                                    map.put("state", locality);
                                    map.put("city", country);
                                    map.put("address",Addresses);


// Insert data into the new child node
                                    staffRef.setValue(map);
                                    Toast.makeText(getApplicationContext(), "user address is saved",
                                            Toast.LENGTH_LONG).show();

                                    String productname = getIntent().getStringExtra("product name");
                                    String quantity = getIntent().getStringExtra("quantity");
                                    String price= getIntent().getStringExtra("price");
                                    String image = getIntent().getStringExtra("image");
                                    System.out.println(image);

                                    Intent i = new Intent(Add_address.this,OrderSummary.class);
                                    i.putExtra("name",na);
                                    i.putExtra("name2",name2);
                                    i.putExtra("phoneno",phone);
                                    i.putExtra("pincode",pinCode);
                                    i.putExtra("state",State);
                                    i.putExtra("city",City);
                                    i.putExtra("address",address);
                                    i.putExtra("address2",address2);
                                    i.putExtra("product name",productname);
                                    i.putExtra("quantity",quantity);
                                    i.putExtra("price",price);
                                    i.putExtra("image",image);
                                    startActivity(i);
                                    progressDialog.dismiss();



                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }


                            }
                            else{
                                askPermission();
                            }
                        }

                        private void askPermission() {
                            if(ContextCompat.checkSelfPermission(Add_address.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                               getLastLocation();

                            }
                            else{
                                ActivityCompat.requestPermissions(Add_address.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);
                            }

                        }


                    });
                }
            }
        });
    }
    public void savebutton(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String name2 = getIntent().getStringExtra("name2");
        String userPath = "users/"+name2;

        DatabaseReference userRef = database.getReference(userPath);
        DatabaseReference staffRef = userRef.child("OrderAddress/"+name2);

        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
        loadingProgressBar.setVisibility(View.VISIBLE);
        ProgressDialog progressDialog = new ProgressDialog(Add_address.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        phoneno = findViewById(R.id.phone_number);
        name = findViewById(R.id.name);
        pinC = findViewById(R.id.pin_code);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        Address = findViewById(R.id.address);
        Address2 = findViewById(R.id.address2);
        saveB = findViewById(R.id.save_button);
        Button currentL = findViewById(R.id.current_location);


        na = name.getText().toString().trim();

        phone = phoneno.getText().toString().trim();

        pinCode = pinC.getText().toString().trim();

        State = state.getText().toString().trim();

        City = city.getText().toString().trim();

        address = Address.getText().toString().trim();



        address2 = Address2.getText().toString().trim();
        Map<String, Object> map = new HashMap<>();
        map.put("name", na);
        map.put("phoneno", phone);
        map.put("pincode", pinCode);
        map.put("state", State);
        map.put("city", City);
        map.put("address", address);
        map.put("address2", address2);

// Insert data into the new child node
        staffRef.setValue(map);
        Toast.makeText(getApplicationContext(), "user address is saved",
                Toast.LENGTH_LONG).show();
        String productname = getIntent().getStringExtra("product name");
        String quantity = getIntent().getStringExtra("quantity");
        String price= getIntent().getStringExtra("price");
        String image = getIntent().getStringExtra("image");
        System.out.println(image);

        Intent i = new Intent(Add_address.this,OrderSummary.class);
        i.putExtra("name",na);
        i.putExtra("name2",name2);
        i.putExtra("phoneno",phone);
        i.putExtra("pincode",pinCode);
        i.putExtra("state",State);
        i.putExtra("city",City);
        i.putExtra("address",address);
        i.putExtra("address2",address2);
        i.putExtra("product name",productname);
        i.putExtra("quantity",quantity);
        i.putExtra("price",price);
        i.putExtra("image",image);
        startActivity(i);
        progressDialog.dismiss();

    }
}



  //
//}
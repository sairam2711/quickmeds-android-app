package com.example.sendotp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class category extends AppCompatActivity {
    MyDatabaseHelper mydb = new MyDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        TextView sugar = findViewById(R.id.sugar);
        TextView test = findViewById(R.id.test);
        TextView blood = findViewById(R.id.blood);
        TextView juices = findViewById(R.id.juices);

        sugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    String name = res1.getString(0);
                    ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    ProgressDialog progressDialog = new ProgressDialog(category.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    Intent intent1 = new Intent(category.this, Juice_andv.class);
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
                    Intent intent = new Intent(category.this, Profile.class);
                    startActivity(intent);
                }
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    String name = res1.getString(0);
                    ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    ProgressDialog progressDialog = new ProgressDialog(category.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    Intent intent1 = new Intent(category.this, Juice_andv.class);
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
                    Intent intent = new Intent(category.this, Profile.class);
                    startActivity(intent);
                }
            }
        });
        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    String name = res1.getString(0);
                    ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    ProgressDialog progressDialog = new ProgressDialog(category.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    Intent intent1 = new Intent(category.this, Juice_andv.class);
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
                    Intent intent = new Intent(category.this, Profile.class);
                    startActivity(intent);
                }
            }
        });
        juices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res1 = mydb.getAllData();
                if (res1.moveToFirst()) {
                    String name = res1.getString(0);
                    ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    ProgressDialog progressDialog = new ProgressDialog(category.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    Intent intent1 = new Intent(category.this, Juice_andv.class);
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
                    Intent intent = new Intent(category.this, Profile.class);
                    startActivity(intent);
                }
            }
        });

    }
}
package com.example.sendotp;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class receiveOTP extends AppCompatActivity {

    private EditText otpEditText;
    String phone,nameY;
    long newRowId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_otp);

        otpEditText = findViewById(R.id.otp_edit_text);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String userPath = "users";
        //MainActivity objA = new MainActivity();
        // Create an object of ClassA
        // int otp1= objA.otp;
        //System.out.println(objA.ot);
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);




        Button verifyOtpButton = findViewById(R.id.verify_otp_button);
        verifyOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String otp2 = otpEditText.getText().toString().trim();
                String sentOtpCode = getIntent().getStringExtra("otp_code").trim();
                System.out.println(sentOtpCode);
                verifyOtp(sentOtpCode);
                Intent intent1 = new Intent(receiveOTP.this, Profile2.class);
                intent1.putExtra("name", nameY);
                startActivity(intent1);
                finish();
            }

            private void verifyOtp(String otp1) {


                String enteredOtp = otpEditText.getText().toString().trim();


                if (enteredOtp.equals(otp1)) {
                    Toast.makeText(getApplicationContext(), "otp verification successfull", Toast.LENGTH_SHORT).show();
                     phone = getIntent().getStringExtra("phone_no");
                     nameY = getIntent().getStringExtra("yourN");
                    MyDatabaseHelper dbHelper = new MyDatabaseHelper(receiveOTP.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();

                    values.put("name", nameY);
                    values.put("status", "login successful");

                     newRowId = db.insert("users", null, values);
                    insertData(nameY);




                    //System.out.println(phone);
                    //insertData(phone);
                } else {
                    // OTP verification failed
                    Toast.makeText(getApplicationContext(), "Invalid OTP, please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            private void insertData(String nameY) {
                DatabaseReference userRef = database.getReference(userPath);
                DatabaseReference staffRef = userRef.child(String.valueOf(nameY));


                //address2 = Address2.getText().toString().trim();
                Map<String, Object> map = new HashMap<>();
                map.put("name", nameY);
                map.put("phoneno", phone);
                staffRef.setValue(map);
            }

            //private void insertData(String phone) {
//
  //              DBhelp dbHelper = new DBhelp(receiveOTP.this);

    //            boolean success = dbHelper.insertData(nameY,phone,"phoneNo","pincode","state","city","address1","address2","null","NULL");
      //          if (success) {
        //            Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
          //      } else {
            //        Toast.makeText(getApplicationContext(), "Data insertion failed", Toast.LENGTH_SHORT).show();
              //  }
            //}
        });
    }
}
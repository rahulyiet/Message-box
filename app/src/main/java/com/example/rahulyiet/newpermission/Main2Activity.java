package com.example.rahulyiet.newpermission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    EditText OTP;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        OTP = findViewById(R.id.OTP);
        Submit = findViewById(R.id.Submit);

        String  message = getIntent().getStringExtra("message");

        final int x = Integer.valueOf(message);

        Log.d("test"," "+x);



        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String UserOTP = OTP.getText().toString().trim();
                Integer y = Integer.valueOf(UserOTP);

                if (x == y) {
                    Toast.makeText(Main2Activity.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(Main2Activity.this, "Wrong Otp", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

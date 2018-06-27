package com.example.rahulyiet.newpermission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

      private   EditText Phone,Message;
         private Button Send;

         private static final int REQUEST_CODE_SMS =101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Phone =findViewById(R.id.phone);
        Message =findViewById(R.id.message);
        Send=findViewById(R.id.button);

        String[] permission = {
                Manifest.permission.SEND_SMS

        };

           if(ActivityCompat.checkSelfPermission(MainActivity.this,permission[0]) != PackageManager.PERMISSION_GRANTED){

               ActivityCompat.requestPermissions(MainActivity.this,
               permission,123);
           }

              Send.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      String phoneNo = Phone.getText().toString().trim();
                      String message = Message.getText().toString().trim();

                      SmsManager sms =SmsManager.getDefault();
                      Random r =new Random();
                      int i1 =r.nextInt(9999 - 1111) + 1111;
                      String MessageNumber=i1+"";

                      sms.sendTextMessage(phoneNo,null,MessageNumber,null,null);



                      Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                      intent.putExtra("message",MessageNumber);
                      startActivity(intent);

                  }
              });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==123){
            if (grantResults.length>0 &&
                    grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(MainActivity.this,"Permission Granted !",Toast.LENGTH_SHORT).show();
            }else{

                Toast.makeText(MainActivity.this,"Permission not granted",Toast.LENGTH_SHORT).show();
            }

        }
    }
}

package com.b1.ltd.startsmscallview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etPhone,etMessage;
    Button sendSMS,call;

    String mobile = "";
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendSMS = findViewById(R.id.sendSMS);
        call = findViewById(R.id.call);

        etMessage = findViewById(R.id.etMessage);
        etPhone = findViewById(R.id.etPhone);


        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile = etPhone.getText().toString();
                message = etMessage.getText().toString();

                Uri uri = Uri.parse("sms: " +mobile);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile = etPhone.getText().toString();
                //message = etMessage.getText().toString();

                Uri uri = Uri.parse("tel: " +mobile);
                Intent intent = new Intent(Intent.ACTION_CALL_BUTTON,uri);
                //intent.putExtra("sms_body",message);
                startActivity(intent);
            }
        });
    }
}

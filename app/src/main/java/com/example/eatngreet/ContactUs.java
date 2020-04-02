package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactUs extends AppCompatActivity implements View.OnClickListener{
    Button button22, button1;
    EditText messageName, messageSubject, messageBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        button22 = findViewById(R.id.button22);
        button1 = findViewById(R.id.button1);
        messageName = (EditText)findViewById(R.id.editText1);
        messageSubject = (EditText)findViewById(R.id.editText2);
        messageBody = (EditText)findViewById(R.id.editText3);

        button22.setOnClickListener(this);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                // Getting information from xml file
                String nameFrom = messageName.getText().toString();
                String body = messageBody.getText().toString();

                // Hardcoding email recipient and subject
                String[] mailto = new String[1];
                mailto[0] = "tori9peaches@yahoo.com";
                String subject = "EatNGreet Issue".concat(" - ").concat(nameFrom);

                // Creating email intent
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, mailto);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, body);
                emailIntent.setType("message/rfc822");

                // Launching email intent
                startActivity(Intent.createChooser(emailIntent,"Choose Mail App"));

            }
        });
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button22:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;
        }
    }
}
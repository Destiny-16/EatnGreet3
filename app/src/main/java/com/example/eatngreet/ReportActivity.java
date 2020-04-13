package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReportActivity extends AppCompatActivity implements View.OnClickListener{
    Button button20; // back button
    Button button1;
    EditText editText1; // text input from user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // set buttons to xml file buttons
        button20 = findViewById(R.id.button20);
        button1 = findViewById(R.id.button1);

        editText1 =(EditText)findViewById(R.id.editText1);


        button20.setOnClickListener(this);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Get information from XML file
                String userMessage = editText1.getText().toString();

                // Hardcode email recipient with "Report" subject line
                String[] mailto = new String[1];
                mailto[0] = "kathe.gee@gmail.com";
                String subject = "EatNGreet Report User-";

                // Create email content intent
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, mailto);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, userMessage);
                intent.setType("message/rfc822");

                // Launch email intent
                startActivity(Intent.createChooser(intent, "Choose Mail App"));
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button20:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.button1:
                Intent intent = new Intent(getApplicationContext(), Profile.class);
                startActivity(intent);
                break;

        }
    }
}

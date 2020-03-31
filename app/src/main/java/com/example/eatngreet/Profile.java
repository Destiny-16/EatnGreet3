package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity implements View.OnClickListener{

    Button button16;
    Button chatButton;
    Button reportButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button16 = findViewById(R.id.button16);
        chatButton = findViewById(R.id.chatButton);
        reportButton = findViewById(R.id.reportButton);


        button16.setOnClickListener(this);
        chatButton.setOnClickListener(this);
        reportButton.setOnClickListener(this);


        }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {

            case R.id.button16:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.chatButton:
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);
                break;

            case R.id.reportButton:
                intent = new Intent(getApplicationContext(), ReportActivity.class);
                startActivity(intent);
                break;
    }
    }

}

package com.example.eatngreet;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eatngreet.ui.login.LoginActivity;

public class RateActivity extends AppCompatActivity implements View.OnClickListener{

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {

            case R.id.button1:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.button2:
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
                break;
        }

    }
}

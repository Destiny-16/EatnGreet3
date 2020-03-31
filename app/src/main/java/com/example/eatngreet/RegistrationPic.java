package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eatngreet.ui.login.LoginActivity;

public class RegistrationPic extends AppCompatActivity implements View.OnClickListener{
    Button backButton12;
    Button button31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_pic);

        backButton12 = findViewById(R.id.backButton12);
        button31 = findViewById(R.id.button31);

        backButton12.setOnClickListener(this);
        button31.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.american:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;

            case R.id.button31:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
        }
    }

    }


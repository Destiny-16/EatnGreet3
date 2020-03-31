package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactUs extends AppCompatActivity implements View.OnClickListener{
    Button button22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        button22 = findViewById(R.id.button22);

        button22.setOnClickListener(this);
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
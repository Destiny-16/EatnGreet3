package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Matches extends AppCompatActivity implements View.OnClickListener {

    Button backButton7;
    Button button17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        backButton7 = findViewById(R.id.backButton7);
        button17 = findViewById(R.id.button17);

        backButton7.setOnClickListener(this);
        button17.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button17:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                break;

            case R.id.backButton7:
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
                break;

        }
    }
}
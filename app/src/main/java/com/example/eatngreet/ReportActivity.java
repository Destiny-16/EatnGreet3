package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportActivity extends AppCompatActivity implements View.OnClickListener{
    Button button20;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        button20 = findViewById(R.id.button20);
        button1 = findViewById(R.id.button1);


        button20.setOnClickListener(this);
        button1.setOnClickListener(this);

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

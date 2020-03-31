package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuuu extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menuuu);

        b = findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener(){

                                 @Override
                                 public void onClick(View view) {
                                     startActivity(new Intent(getApplicationContext(), FindPartner.class));
                                 }
                             }

        );
    }
}

package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditProfile extends AppCompatActivity {

    Button backButton;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        backButton = findViewById(R.id.backButton);

                backButton.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(intent);
            }

    });


        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditProfilePic.class);
                startActivity(intent);
            }

        });



}}

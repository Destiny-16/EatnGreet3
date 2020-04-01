package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.eatngreet.ui.login.LoginActivity;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{

    Button findButton;
    Button profileButton;
    Button mealsButton;
    Button MesButton;
    Button searchButton;
    Button contactButton;
    Button logoutButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        findButton = findViewById(R.id.findButton);
        profileButton = findViewById(R.id.profileButton);
        mealsButton = findViewById(R.id.mealsButton);
        MesButton = findViewById(R.id.MesButton);
        searchButton = findViewById(R.id.searchButton);
        contactButton = findViewById(R.id.contactButton);
        logoutButton = findViewById(R.id.logoutButton);

        findButton.setOnClickListener(this);
        profileButton.setOnClickListener(this);
        mealsButton.setOnClickListener(this);
        MesButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        contactButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {

            case R.id.findButton:
                startActivity(new Intent(getApplicationContext(), FindPartner1.class));
                break;

            case R.id.profileButton:
                Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(intent);
                break;

            case R.id.mealsButton:
                intent = new Intent(getApplicationContext(), UpcomingMeals.class);
                startActivity(intent);
                break;

            case R.id.searchButton:
            intent = new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
                break;

            case R.id.MesButton:
                intent = new Intent(getApplicationContext(), MessagesActivity.class);
                startActivity(intent);
                break;

            case R.id.contactButton:
                intent = new Intent(getApplicationContext(), ContactUs.class);
                startActivity(intent);
                break;

            case R.id.logoutButton:
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }



        }
}




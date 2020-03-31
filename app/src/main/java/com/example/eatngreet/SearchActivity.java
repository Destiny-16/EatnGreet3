package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{
    Button backButton;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        backButton = findViewById(R.id.backButton);
        searchButton = findViewById(R.id.searchButton);

//kkuguyg
        backButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.backButton:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.searchButton:
                Intent intent = new Intent(getApplicationContext(), Matches.class);
                startActivity(intent);
                break;

        }

    }
}

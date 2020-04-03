package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Matches extends AppCompatActivity implements View.OnClickListener {

    Button backButton7;
    Button button17, button8, button9;
    TextView textView47, textView48, textView33;
    private static final String TAG = Registration.class.getSimpleName();
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        backButton7 = findViewById(R.id.backButton7);
        button17 = findViewById(R.id.button17);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        textView47 = findViewById(R.id.textView47);
        textView48 = findViewById(R.id.textView48);
        textView33 = findViewById(R.id.textView33);

        backButton7.setOnClickListener(this);
        button17.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        


        //mFirebaseDatabase.orderByChild()


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button17:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                break;

            case R.id.button8:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                break;

            case R.id.button9:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                break;

            case R.id.backButton7:
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
                break;

        }
    }
}
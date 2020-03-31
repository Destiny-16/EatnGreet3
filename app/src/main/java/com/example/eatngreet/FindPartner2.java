package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FindPartner2 extends AppCompatActivity implements View.OnClickListener{

    Button backButton3;
    Button noPref;
    Button vegan;
    Button fastFood;
    Button healthy;
    Button thai;
    Button tacos;
    Button vegetarian;
    Button pizza;
    Button seafood;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_partner2);

        backButton3 = findViewById(R.id.backButton3);
        noPref = findViewById(R.id.noPref);
        vegan = findViewById(R.id.vegan);
        fastFood = findViewById(R.id.fastFood);
        healthy = findViewById(R.id.healthy);
        thai = findViewById(R.id.thai);
        tacos = findViewById(R.id.tacos);
        vegetarian = findViewById(R.id.vegetarian);
        pizza = findViewById(R.id.pizza);
        seafood = findViewById(R.id.seafood);

        backButton3.setOnClickListener(this);
        noPref.setOnClickListener(this);
        vegan.setOnClickListener(this);
        fastFood.setOnClickListener(this);
        healthy.setOnClickListener(this);
        thai.setOnClickListener(this);
        tacos.setOnClickListener(this);
        vegetarian.setOnClickListener(this);
        pizza.setOnClickListener(this);
        seafood.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        FirebaseUser user3= FirebaseAuth.getInstance().getCurrentUser();
        String userId=user3.getUid();

        switch (view.getId()) {
            case R.id.backButton3:
                startActivity(new Intent(getApplicationContext(), FindPartner1.class));
                break;

            case R.id.noPref:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("No Preference");
                break;

            case R.id.vegan:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Vegan");
                break;

            case R.id.fastFood:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Fast Food");
                break;

            case R.id.healthy:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Healthy");
                break;

            case R.id.thai:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Thai");
                break;

            case R.id.tacos:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Tacos");
                break;

            case R.id.vegetarian:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Vegetarian");
                break;

            case R.id.pizza:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("pizza");
                break;

            case R.id.seafood:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Seafood");
                break;
        }

    }
}

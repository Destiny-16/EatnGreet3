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

public class FindPartner1 extends AppCompatActivity implements View.OnClickListener{

    Button button;
    Button italian;
    Button more;
    Button chinese;
    Button indian;
    Button sandwiches;
    Button mexican;
    Button dessert;
    Button breakfast;
    Button american;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_partner1);

        button = findViewById(R.id.button14);
        italian = findViewById(R.id.italian);
        more = findViewById(R.id.more);
        chinese = findViewById(R.id.chinese);
        indian = findViewById(R.id.indian);
        sandwiches = findViewById(R.id.sandwiches);
        mexican = findViewById(R.id.mexican);
        dessert = findViewById(R.id.dessert);
        breakfast = findViewById(R.id.breakfast);
        american = findViewById(R.id.american);


        button.setOnClickListener(this);
        italian.setOnClickListener(this);
        more.setOnClickListener(this);
        chinese.setOnClickListener(this);
        indian.setOnClickListener(this);
        sandwiches.setOnClickListener(this);
        mexican.setOnClickListener(this);
        dessert.setOnClickListener(this);
        breakfast.setOnClickListener(this);
        american.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        FirebaseUser user3=FirebaseAuth.getInstance().getCurrentUser();
        String userId=user3.getUid();

        switch (view.getId()) {

            case R.id.button:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.italian:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Italian");
                break;

            case R.id.chinese:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Chinese");
                break;

            case R.id.indian:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Indian");
                break;

            case R.id.sandwiches:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Sandwiches");
                break;

            case R.id.mexican:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Mexican");
                break;

            case R.id.dessert:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Dessert");
                break;

            case R.id.breakfast:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("Breakfast");
                break;

            case R.id.american:
                startActivity(new Intent(getApplicationContext(), findPartner3.class));
                mFirebaseInstance.getReference("users").child(userId).child("foodPref").setValue("American");
                break;

            case R.id.more:
                startActivity(new Intent(getApplicationContext(), FindPartner2.class));
                break;
        }

    }
}

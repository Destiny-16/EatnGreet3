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

public class findPartner3 extends AppCompatActivity implements View.OnClickListener {
    Button backButton4;
    Button option19;//male
    Button option20;//female
    Button option18;//noPref
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_partner3);

        backButton4 = findViewById(R.id.backButton4);
        option20 = findViewById(R.id.option20);
        option19 = findViewById(R.id.option19);
        option18 = findViewById(R.id.option18);

        backButton4.setOnClickListener(this);
        option20.setOnClickListener(this);
        option19.setOnClickListener(this);
        option18.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        FirebaseUser user3= FirebaseAuth.getInstance().getCurrentUser();
        String userId=user3.getUid();

        switch(view.getId()) {
            case R.id.backButton4:
                Intent intent = new Intent(getApplicationContext(), FindPartner2.class);
                startActivity(intent);

            case R.id.option20:
                startActivity(new Intent(getApplicationContext(), FindPartner4.class));
                mFirebaseInstance.getReference("users").child(userId).child("genderPref").setValue("Female");
                break;


            case R.id.option19:
                startActivity(new Intent(getApplicationContext(), FindPartner4.class));
                mFirebaseInstance.getReference("users").child(userId).child("genderPref").setValue("Male");
                break;

            case R.id.option18:
                startActivity(new Intent(getApplicationContext(), FindPartner4.class));
                mFirebaseInstance.getReference("users").child(userId).child("genderPref").setValue("No Preference");
                break;
        }


    }
}

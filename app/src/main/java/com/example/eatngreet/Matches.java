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

public class Matches extends AppCompatActivity implements View.OnClickListener {

    Button backButton7;
    Button button17, button32, button33;
    private static final String TAG = Registration.class.getSimpleName();
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        backButton7 = findViewById(R.id.backButton7);
        button17 = findViewById(R.id.button17);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);

        backButton7.setOnClickListener(this);
        button17.setOnClickListener(this);
        button32.setOnClickListener(this);
        button33.setOnClickListener(this);

        // DO NOT CHANGE / CREATES DATABASE CONNECTION***********************************************************
        FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(USER_SERVICE).child(user2.getUid());
        String ref2 = ref.toString().trim();

        FirebaseUser user3 = FirebaseAuth.getInstance().getCurrentUser();
        final String userId = user3.getUid();

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users").child(userId);
        // *******************************************************************************************************

       // mFirebaseInstance.


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button17:
                startActivity(new Intent(getApplicationContext(), Profile.class));
                break;

            case R.id.button32:
                // Go to chat activity
                break;

            case R.id.button33:
                // Go to greet activity
                break;

            case R.id.backButton7:
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
                break;

        }
    }
}
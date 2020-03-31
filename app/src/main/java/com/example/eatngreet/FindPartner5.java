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

public class FindPartner5 extends AppCompatActivity implements View.OnClickListener {

    Button backButton6;
    Button option32;//five
    Button option31;//ten
    Button option30;//twenty
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_partner5);

        backButton6 = findViewById(R.id.backButton6);
        option32 = findViewById(R.id.option32);
        option31 = findViewById(R.id.option31);
        option30 = findViewById(R.id.option30);

        backButton6.setOnClickListener(this);
        option32.setOnClickListener(this);
        option31.setOnClickListener(this);
        option30.setOnClickListener(this);
    }

        public void onClick(View view) {
            mFirebaseInstance = FirebaseDatabase.getInstance();
            mFirebaseDatabase = mFirebaseInstance.getReference("users");
            FirebaseUser user3= FirebaseAuth.getInstance().getCurrentUser();
            String userId=user3.getUid();

            switch(view.getId()) {

                case R.id.backButton6:
                    Intent intent = new Intent(getApplicationContext(), FindPartner4.class);
                    startActivity(intent);

                case R.id.option32:
                    startActivity(new Intent(getApplicationContext(), Matches.class));
                    mFirebaseInstance.getReference("users").child(userId).child("distancePref").setValue("Five Miles or Less");
                    break;

                case R.id.option31:
                    startActivity(new Intent(getApplicationContext(), Matches.class));
                    mFirebaseInstance.getReference("users").child(userId).child("distancePref").setValue("Ten Miles or Less");
                    break;

                case R.id.option30:
                    startActivity(new Intent(getApplicationContext(), Matches.class));
                    mFirebaseInstance.getReference("users").child(userId).child("distancePref").setValue("Twenty Miles or Less");
                    break;

            }

    }
}

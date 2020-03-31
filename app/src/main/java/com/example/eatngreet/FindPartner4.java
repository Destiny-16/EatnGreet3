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

public class FindPartner4 extends AppCompatActivity implements View.OnClickListener {

    Button backButton5;
    Button option22; //eighteen
    Button option25;//twenty
    Button option23;//thirty
    Button option21;//fifty
    Button option24;//nopref
    Button option26;//forty
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_partner4);

        backButton5 = findViewById(R.id.backButton5);
        option22 = findViewById(R.id.option22);
        option25 = findViewById(R.id.option25);
        option23 = findViewById(R.id.option23);
        option21 = findViewById(R.id.option21);
        option24 = findViewById(R.id.option24);
        option26 = findViewById(R.id.option26);

        backButton5.setOnClickListener(this);
        option22.setOnClickListener(this);
        option25.setOnClickListener(this);
        option23.setOnClickListener(this);
        option21.setOnClickListener(this);
        option24.setOnClickListener(this);
        option26.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        FirebaseUser user3= FirebaseAuth.getInstance().getCurrentUser();
        String userId=user3.getUid();

        switch(view.getId()){

            case R.id.backButton5:
                Intent intent = new Intent(getApplicationContext(), findPartner3.class);
                startActivity(intent);
                break;

            case R.id.option22:
                startActivity(new Intent(getApplicationContext(), FindPartner5.class));
                mFirebaseInstance.getReference("users").child(userId).child("agePref").setValue("18to20");
                break;

            case R.id.option25:
                startActivity(new Intent(getApplicationContext(), FindPartner5.class));
                mFirebaseInstance.getReference("users").child(userId).child("agePref").setValue("21to31");
                break;

            case R.id.option23:
                startActivity(new Intent(getApplicationContext(), FindPartner5.class));
                mFirebaseInstance.getReference("users").child(userId).child("agePref").setValue("31to41");
                break;

            case R.id.option21:
                startActivity(new Intent(getApplicationContext(), FindPartner5.class));
                mFirebaseInstance.getReference("users").child(userId).child("agePref").setValue("51 Plus");
                break;

            case R.id.option24:
                startActivity(new Intent(getApplicationContext(), FindPartner5.class));
                mFirebaseInstance.getReference("users").child(userId).child("agePref").setValue("No Preference");
                break;

            case R.id.option26:
                startActivity(new Intent(getApplicationContext(), FindPartner5.class));
                mFirebaseInstance.getReference("users").child(userId).child("agePref").setValue("41to51");
                break;
        }
    }
}

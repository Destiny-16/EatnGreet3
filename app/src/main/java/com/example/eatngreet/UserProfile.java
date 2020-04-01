package com.example.eatngreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity implements View.OnClickListener {

    Button button7, editButton;
    TextView favFood2, favRestaurant2, funFact2, userName3;
    private static final String TAG = Registration.class.getSimpleName();
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        button7 = findViewById(R.id.button7);
        editButton = findViewById(R.id.editButton);
        favFood2 = findViewById(R.id.favFood2);
        favRestaurant2 = findViewById(R.id.favRestaurant2);
        funFact2 = findViewById(R.id.funFact2);
        userName3 = findViewById(R.id.userName3);

        button7.setOnClickListener(this);
        editButton.setOnClickListener(this);

        FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(USER_SERVICE).child(user2.getUid());
        String ref2 = ref.toString().trim();

        FirebaseUser user3 = FirebaseAuth.getInstance().getCurrentUser();
        final String userId = user3.getUid();

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users").child(userId);

        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue().toString();
                String food = dataSnapshot.child("food").getValue().toString();
                String fact = dataSnapshot.child("fact").getValue().toString();
                String restaurant = dataSnapshot.child("restaurant").getValue().toString();

                userName3.setText(name);
                favFood2.setText(food);
                favRestaurant2.setText(restaurant);
                funFact2.setText(fact);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button7:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;


            case R.id.editButton:
                startActivity(new Intent(getApplicationContext(), EditProfile.class));
                break;
        }
    }

}

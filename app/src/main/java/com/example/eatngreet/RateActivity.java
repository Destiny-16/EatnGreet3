package com.example.eatngreet;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eatngreet.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RateActivity extends AppCompatActivity implements View.OnClickListener{

    Button button1;
    Button button2;
    boolean exists;
    double likes, dislikes;
    private static final String TAG = Registration.class.getSimpleName();
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        // Create buttons and listeners
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        // DO NOT CHANGE / CREATES DATABASE CONNECTION***********************************************************
        FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(USER_SERVICE).child(user2.getUid());
        String ref2 = ref.toString().trim();

        FirebaseUser user3 = FirebaseAuth.getInstance().getCurrentUser();
        final String userId = user3.getUid();

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users").child(userId);
        // *******************************************************************************************************

        // Check if the field exists, if it does then get likes and dislikes
       mFirebaseDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("likes")){
                    double likes = dataSnapshot.child("likes").getValue(double.class);
                    double dislikes = dataSnapshot.child("dislikes").getValue(double.class);
                    setLikes(likes);
                    setDislikes(dislikes);
                }
                else{
                    createNewFields(mFirebaseDatabase);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Left Empty
            }
        });

    }

    public void createNewFields(DatabaseReference mFirebaseDatabase){
        double value = 0;
        HashMap map = new HashMap();
        map.put("likes", value);
        map.put("dislikes", value);
        mFirebaseDatabase.updateChildren(map);
        setLikes(0);
        setDislikes(0);
    }

    @Override
    public void onClick(View view) {

        FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(USER_SERVICE).child(user2.getUid());
        String ref2 = ref.toString().trim();

        FirebaseUser user3 = FirebaseAuth.getInstance().getCurrentUser();
        final String userId = user3.getUid();

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users").child(userId);

        // Increment and apply new like or dislike
        switch(view.getId()) {

            case R.id.button1:
                double likes = getLikes() + 1;
                mFirebaseDatabase.child("likes").setValue(likes);
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.button2:
                double dislikes = getDislikes() + 1;
                mFirebaseDatabase.child("dislikes").setValue(dislikes);
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
                break;
        }

    }

    public void setLikes(double likesNum){
        likes = likesNum;
    }

    public double getLikes(){
        return likes;
    }

    public void setDislikes(double dislikesNum){
        dislikes = dislikesNum;
    }

    public double getDislikes(){
        return dislikes;
    }

    public void setExists(boolean bool){
        exists = bool;
    }

    public boolean getExists(){
        return exists;
    }

}

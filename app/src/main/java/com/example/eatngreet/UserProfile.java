package com.example.eatngreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

public class UserProfile extends AppCompatActivity implements View.OnClickListener {

    Button button7, editButton;
    TextView favFood2, favRestaurant2, funFact2, userName3, age, gender, likes, dislikes;
    ImageView imageView;
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
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        imageView = findViewById(R.id.imageView4);
        likes = findViewById(R.id.likes3);
        dislikes = findViewById(R.id.dislikes3);

        button7.setOnClickListener(this);
        editButton.setOnClickListener(this);

        FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(USER_SERVICE).child(user2.getUid());
        String ref2 = ref.toString().trim();

        FirebaseUser user3 = FirebaseAuth.getInstance().getCurrentUser();
        final String userId = user3.getUid();

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users").child(userId);

        mFirebaseDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue().toString();
                String food = dataSnapshot.child("food").getValue().toString();
                String fact = dataSnapshot.child("fact").getValue().toString();
                String restaurant = dataSnapshot.child("restaurant").getValue().toString();
                String gender2 = dataSnapshot.child("gender").getValue().toString();
                String age2 = dataSnapshot.child("age").getValue().toString();
                if(dataSnapshot.hasChild("likes")) { likes.setText("likes: " + dataSnapshot.child("likes").getValue().toString()); }
                if(dataSnapshot.hasChild("dislikes")) { dislikes.setText("dislikes: " + dataSnapshot.child("dislikes").getValue().toString()); }
                String image;
                if(dataSnapshot.hasChild("profileImage")){
                    image = dataSnapshot.child("profileImage").getValue().toString();
                    try{
                        Bitmap imageBitmap = decodeFromFirebase64(image);
                        imageView.setImageBitmap(imageBitmap);}
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }

                userName3.setText(name);
                favFood2.setText(food);
                favRestaurant2.setText(restaurant);
                funFact2.setText(fact);
                gender.setText(gender2);
                age.setText(age2);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public static Bitmap decodeFromFirebase64(String image) throws IOException{
        byte[] decodedByteArray = android.util.Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);
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

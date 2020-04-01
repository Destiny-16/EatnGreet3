package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eatngreet.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity implements View.OnClickListener{

    Button backButton;
    Button submitButton;
    Button submitButton2;
    Button submitButton3;
    Button submitButton4;
    Button submitButton5;
    EditText changeName, changeEmail, changeFact, changeFood, changeRestaurant;
    FirebaseAuth fAuth;
    private static final String TAG = Registration.class.getSimpleName();
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        backButton = findViewById(R.id.backButton);
        submitButton = findViewById(R.id.submitButton);
        submitButton2 = findViewById(R.id.submitButton2);
        submitButton3 = findViewById(R.id.submitButton3);
        submitButton4 = findViewById(R.id.submitButton4);
        submitButton5 = findViewById(R.id.submitButton5);
        changeName = findViewById(R.id.changeName);
        changeEmail = findViewById(R.id.changeEmail);
        changeRestaurant = findViewById(R.id.changeRestaurant);
        changeFact = findViewById(R.id.changeFact);
        changeFood = findViewById(R.id.changeFood);

        backButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);
        submitButton2.setOnClickListener(this);
        submitButton3.setOnClickListener(this);
        submitButton4.setOnClickListener(this);
        submitButton5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(USER_SERVICE).child(user2.getUid());
        String ref2 = ref.toString().trim();

        FirebaseUser user3=FirebaseAuth.getInstance().getCurrentUser();
        final String userId=user3.getUid();

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        switch(view.getId()) {

            case R.id.backButton:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.submitButton:
                String cName = changeName.getText().toString().trim();
                mFirebaseDatabase.child(userId).child("name").setValue(cName);
                Toast.makeText(EditProfile.this, "Name Changed", Toast.LENGTH_SHORT).show();
                break;

            case R.id.submitButton2:
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String cEmail = changeEmail.getText().toString().trim();
                user.updateEmail(cEmail);
                Toast.makeText(EditProfile.this, "Email Changed", Toast.LENGTH_SHORT).show();
                break;

            case R.id.submitButton3:
                String cFact = changeFact.getText().toString().trim();
                mFirebaseDatabase.child(userId).child("fact").setValue(cFact);
                Toast.makeText(EditProfile.this, "Fun Fact Changed", Toast.LENGTH_SHORT).show();
                break;

            case R.id.submitButton4:
                String cFood = changeFood.getText().toString().trim();
                mFirebaseDatabase.child(userId).child("food").setValue(cFood);
                Toast.makeText(EditProfile.this, "Favorite Food Changed", Toast.LENGTH_SHORT).show();
                break;

            case R.id.submitButton5:
                String cRestaurant = changeRestaurant.getText().toString().trim();
                mFirebaseDatabase.child(userId).child("restaurant").setValue(cRestaurant);
                Toast.makeText(EditProfile.this, "Favorite Restaurant Changed", Toast.LENGTH_SHORT).show();
                break;
        }


    }


}

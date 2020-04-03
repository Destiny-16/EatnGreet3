
package com.example.eatngreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eatngreet.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration extends AppCompatActivity implements View.OnClickListener{
    Button button24;
    Button button23;
    EditText name, email, password2, cPassword, food2, restaurant, fact, gender, age;
    Button button;
    Button button2;
    //FirebaseAuth fAuth;
    private static final String TAG = Registration.class.getSimpleName();
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    //private String userId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        button24 = findViewById(R.id.button24);
        button23 = findViewById(R.id.button23);
        name = findViewById(R.id.name);
        //cPassword = findViewById(R.id.cPassword);
        food2 = findViewById(R.id.food2);
        restaurant = findViewById(R.id.restaurant);
        fact = findViewById(R.id.fact);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);


        button24.setOnClickListener(this);
        button23.setOnClickListener(this);

        //fAuth = FirebaseAuth.getInstance();
        //myRef = FirebaseDatabase.getInstance().getReference();
        //progressBar2 = findViewById(R.id.progressBar2);

        //FOR LATER if user has not logged out, takes to to main menu without having to log back in
//        if(fAuth.getCurrentUser() != null) {
//            startActivity(new Intent(getApplicationContext(), MainMenu.class));
//            finish();
//        }
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button24:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;

            case R.id.button23:
                String sName = name.getText().toString().trim();
                String sFood = food2.getText().toString().trim();
                String sRestaurant = restaurant.getText().toString().trim();
                String sFact = fact.getText().toString().trim();
                String sGender = gender.getText().toString().trim();
                String sAge = age.getText().toString().trim();


                if(TextUtils.isEmpty(sName)){
                    name.setError("This field is required.");
                    return;
                }

                if(TextUtils.isEmpty(sFood)){
                    food2.setError("This field is required.");
                    return;
                }
                if(TextUtils.isEmpty(sRestaurant)){
                    restaurant.setError("This field is required.");
                    return;
                }
                if(TextUtils.isEmpty(sFact)){
                    fact.setError("This field is required.");
                    return;
                }
                if(TextUtils.isEmpty(sGender)){
                    gender.setError("This field is required.");
                    return;
                }
                if(TextUtils.isEmpty(sAge)){
                    age.setError("This field is required.");
                    return;
                }


                FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference(USER_SERVICE).child(user2.getUid());
                String ref2 = ref.toString().trim();

                FirebaseUser user3=FirebaseAuth.getInstance().getCurrentUser();
                String userId=user3.getUid();

                mFirebaseInstance = FirebaseDatabase.getInstance();
                mFirebaseDatabase = mFirebaseInstance.getReference("users");


                User user = new User(sFact, sFood, sName, sRestaurant, sGender, sAge);
                mFirebaseDatabase.child(userId).setValue(user);

                mFirebaseInstance.getReference("name").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e(TAG, "NAME CHANGED");
                        String  userName = dataSnapshot.getValue(String.class);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.e(TAG, "Failed", databaseError.toException());
                    }
                });

                startActivity(new Intent(getApplicationContext(), UploadPicture.class));

                break;
        }
    }
}
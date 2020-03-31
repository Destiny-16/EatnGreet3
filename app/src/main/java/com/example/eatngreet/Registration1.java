package com.example.eatngreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eatngreet.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration1 extends AppCompatActivity implements View.OnClickListener{

    EditText email2, password2;
    FirebaseAuth fAuth;
    FirebaseAuth fAuth2;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration1);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        fAuth = FirebaseAuth.getInstance();
        fAuth2 = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(getApplicationContext(), Registration.class));

        String sEmail = email2.getText().toString().trim();
        String sPassword = password2.getText().toString().trim();

        if(TextUtils.isEmpty(sEmail)) {
            email2.setError("This field is required.");
            return;
        }
        if(TextUtils.isEmpty(sPassword)){
            password2.setError("This field is required.");
            return;
        }

        if(sPassword.length() < 6){
            password2.setError("Password must be 6 or more characters");
            return;
        }

        fAuth.createUserWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() ){
                    Toast.makeText(getApplicationContext(), "User Created.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error!" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();

                }
            }
        });

        fAuth2.signInWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Registration1.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Registration.class));
                } else {
                    Toast.makeText(Registration1.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

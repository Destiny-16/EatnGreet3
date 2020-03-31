
package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eatngreet.ui.login.LoginActivity;

public class UploadPicture extends AppCompatActivity implements View.OnClickListener {

    Button backButton11;
    Button upload;
    Button capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_picture);

        backButton11 = findViewById(R.id.backButton11);
        capture = findViewById(R.id.capture);
        upload = findViewById(R.id.upload);


        backButton11.setOnClickListener(this);
        capture.setOnClickListener(this);
        upload.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.backButton11:
                startActivity(new Intent(getApplicationContext(), Registration.class));
                break;

            case R.id.capture:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.upload:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

        }
    }

}
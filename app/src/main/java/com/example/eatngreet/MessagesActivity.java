package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessagesActivity extends AppCompatActivity implements View.OnClickListener{
    Button button18;
    Button button19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);

        button18.setOnClickListener(this);
        button19.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button18:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;

            case R.id.button19:
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);
                break;

        }

    }
}

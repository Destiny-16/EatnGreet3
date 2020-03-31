package com.example.eatngreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindPartner extends AppCompatActivity {

    Button backButton;
//    Button option1;
//    Button option2;
//    Button option3;
//    Button option4;
//    Button option5;
//    Button option6;
//    Button option7;
//    Button option8;
//    Button option9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_partner);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {

                                          public void onClick(View v) {
                                              Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                                              startActivity(intent);
                                          }

                                      });

//      =

//        option1 = findViewById(R.id.option1);
//
//        option1.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), FindPartner2.class);
//                startActivity(intent);
//            }
//            });
//
//
//
//
//        option2 = findViewById(R.id.option2);
//
//        option2.setOnClickListener(new View.OnClickListener() {
//
//             public void onClick(View v) {
//                 Intent intent = new Intent(getApplicationContext(), FindPartner2.class);
//                 startActivity(intent);
//             }
//         });
//
//
//        option3 = findViewById(R.id.option3);
//
//        option3.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), FindPartner2.class);
//                startActivity(intent);
//            }
//        });




}
}
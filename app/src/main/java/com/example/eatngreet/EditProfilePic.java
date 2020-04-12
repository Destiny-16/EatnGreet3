package com.example.eatngreet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class EditProfilePic extends AppCompatActivity implements View.OnClickListener {

    Button backButton8;
    Button button4;
    Button doneButton;
    ImageView imageView7;
    boolean exists;
    Bitmap profileImage;

    private DatabaseReference mFirebaseDatabase, tFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance, tFirebaseInstance;

    private ArrayList<String> pathArray;
    private int array_position;

    private ProgressDialog mProgressDialog;
    private StorageReference mStorageRef;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_pic);

        backButton8 = findViewById(R.id.backButton8);
        imageView7 = findViewById(R.id.imageView7);
        button4 = findViewById(R.id.button4);
        doneButton = findViewById(R.id.button5);

        //pathArray = new ArrayList<>();
        //mProgressDialog = new ProgressDialog(EditProfilePic.this);
        //auth = FirebaseAuth.getInstance();
        //mStorageRef = FirebaseStorage.getInstance().getReference();

        //checkFilePermissions();


        if(ContextCompat.checkSelfPermission(EditProfilePic.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EditProfilePic.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    }, 100);
        }

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);

            }

        });

        doneButton.setOnClickListener(this);
        backButton8.setOnClickListener(this);

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            imageView7.setImageBitmap(captureImage);
            profileImage = captureImage;
            encodeBitmapAndSaveToFirebase(captureImage);
        }
    }


    public void encodeBitmapAndSaveToFirebase(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        String imageEncoded = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

        // Database Connection
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
                if(dataSnapshot.hasChild("profileImage")){
                    setExists(true);
                }
                else{
                    setExists(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if(getExists() == false) {
            HashMap map = new HashMap();
            map.put("profileImage", imageEncoded);
            mFirebaseDatabase.updateChildren(map);
        } else mFirebaseDatabase.child("profileImage").setValue(imageEncoded);

    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public boolean getExists(){
        return exists;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.backButton8:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                break;


            case R.id.button5:
                startActivity(new Intent(getApplicationContext(), EditProfile.class));
                break;
        }
    }

}

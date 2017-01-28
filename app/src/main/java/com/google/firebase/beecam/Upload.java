package com.google.firebase.beecam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Upload extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.beecam3.MESSAGE";

    public static StorageReference storageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageRef = storage.getReferenceFromUrl
                ("gs://beecam3.appspot.com");
    }

    public void doUpload(View view) {
        Intent uploadNow = new Intent(this, UploadShit.class);
        uploadNow.putExtra(EXTRA_MESSAGE, "Uploading your images to site, please wait momentarily");
        startActivity(uploadNow);
    }

    public static StorageReference getStorageRef() {return storageRef;}

}

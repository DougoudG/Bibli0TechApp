package com.example.testtechnopicture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_CODE = 1000;
    Button mCaptureBtn;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image_view);
        mCaptureBtn = findViewById(R.id.capture_image_btn);

        mCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ){
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else {
                        //permission already granted
                        openCamera();
                    }
                }
                else {
                    //system os < Nougat
                    openCamera();
                }
            }
        });
    }

    private void openCamera() {

    }

    //handling permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else {
                    Toast.makeText(this,"Permission denied...",Toast.LENGTH_SHORT).show();
                    //TODO "Take Picture with Camera - Android Studio - Java" 9:18
                }
            }
        }
    }
}
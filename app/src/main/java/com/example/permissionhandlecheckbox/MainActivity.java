package com.example.permissionhandlecheckbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button mbtnPermission;
private final int code =45;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnPermission = findViewById(R.id.btnPermission);
        mbtnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String []permission = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permission,code);
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0]== PackageManager.PERMISSION_GRANTED){
            DisplayToast("permission granted");
        }
        else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[0])){
                DisplayToast("permission Denied");
            }
            else
            {
                DisplayToast("Camera Permission denied by checking don't show again, go to settings and enable");
            }

        }
    }
    public void DisplayToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
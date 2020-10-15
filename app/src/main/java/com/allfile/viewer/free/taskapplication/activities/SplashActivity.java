package com.allfile.viewer.free.taskapplication.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.allfile.viewer.free.taskapplication.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;

import java.util.List;

public class SplashActivity extends Activity {
    Intent myintent;
    int Timmer = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Dexter.withActivity(this).
                withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
                        , Manifest.permission.CAMERA).
                withListener(new BaseMultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        super.onPermissionsChecked(report);
                        checkpermission();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        super.onPermissionRationaleShouldBeShown(permissions, token);
                    }
                }).check();


    }

    public void checkpermission() {
        if (getApplicationContext().checkCallingOrSelfPermission
                (Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                getApplicationContext().checkCallingOrSelfPermission
                        (Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                getApplicationContext().checkCallingOrSelfPermission
                        (Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            wait_three();

        }
    }

    private void wait_three() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                nextactivity();
            }
        }, Timmer);
    }

    public void nextactivity() {
        myintent = new Intent(SplashActivity.this, BaseActivity.class);
        startActivity(myintent);
        finish();
    }
}

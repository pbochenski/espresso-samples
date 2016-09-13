package com.siili.test;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Example4 extends AppCompatActivity {

    private static final int REQ_CODE_PERMISSIONS_READ_CONTACTS = 1;

    @BindView(R.id.textView)
    TextView textView;

    private boolean showPermissionDialog = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.reqpermbut)
    void onClick() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},
                REQ_CODE_PERMISSIONS_READ_CONTACTS);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQ_CODE_PERMISSIONS_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                textView.setText("Permission granted");
            } else {
                textView.setText("Permission denied");
            }
            showPermissionDialog = false;
        }
    }
}

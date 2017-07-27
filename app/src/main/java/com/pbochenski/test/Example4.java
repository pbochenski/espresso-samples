package com.pbochenski.test;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Example4 extends AppCompatActivity {
    private static final int REQ_CODE = 1;

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.reqpermbut)
    void onClick() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d("BOCHEN", "dupa1");
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                textView.setText("Permission granted");
            } else {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, REQ_CODE);
            }
        } else {
            Log.d("BOCHEN", "dupa2");
            textView.setText("Permission granted");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQ_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                textView.setText("Permission granted");
            } else {
                textView.setText("Permission denied");
            }
        }
    }
}

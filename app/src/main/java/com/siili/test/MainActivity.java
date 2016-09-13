package com.siili.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    void onButton1Clicked() {
        startActivity(new Intent(this, Example1.class));
    }

    @OnClick(R.id.button2)
    void onButton2Clicked() {
        startActivity(new Intent(this, Example3.class));
    }

    @OnClick(R.id.button3)
    void onButton3Clicked() {
        startActivity(new Intent(this, Example2.class));
    }

    @OnClick(R.id.button4)
    void onButton4Clicked() {
        startActivity(new Intent(this, Example4.class));
    }

    @OnClick(R.id.button5)
    void onButton5Clicked() {
        startActivity(new Intent(this, Example5.class));
    }

}

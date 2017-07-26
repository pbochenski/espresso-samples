package com.pbochenski.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pbochenski.test.Example9.Example9;

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

    @OnClick(R.id.button6)
    void onButton6Clicked() {
        startActivity(new Intent(this, Example6.class));
    }

    @OnClick(R.id.button7)
    void onButton7Clicked() {
        startActivity(new Intent(this, Example7.class));
    }

    @OnClick(R.id.button8)
    void onButton8Clicked() {
        startActivity(new Intent(this, Example8.class));
    }

    @OnClick(R.id.button9)
    void onButton9Clicked() {
        startActivity(new Intent(this, Example9.class));
    }

}

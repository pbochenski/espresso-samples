package com.pbochenski.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Example1 extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView clickmeTextView;
    private int counter = 0;

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.editText2)
    EditText editText2;

    @BindView(R.id.passwordMatchText)
    TextView passwordMatchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.clickmebutton)
    void clickmebutton() {
        counter++;
        clickmeTextView.setText("Clicked: " + counter + " times");
    }

    @OnClick(R.id.submitbutton)
    void clickSubmitButton() {
        if (editText.getText().toString().equals("test")
                && editText2.getText().toString().equals("test")) {
            passwordMatchText.setText("OK");
        }
    }
}

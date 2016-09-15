package com.siili.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Example8 extends AppCompatActivity {


    @BindView(R.id.login_view)
    View loginView;

    @BindView(R.id.comment_view)
    View commentView;

    @BindView(R.id.editText4)
    EditText loginText;

    @BindView(R.id.editText5)
    EditText passwdText;

    @BindView(R.id.textView3)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example8);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonLogin)
    void onLoginClicked() {
        if (loginText.getText().toString().equals("Siili")
                && passwdText.getText().toString().equals("password")) {
            loginView.setVisibility(View.GONE);
            commentView.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.button_submit)
    void onSubmitButtonClicked() {
        textView.setVisibility(View.VISIBLE);
    }
}

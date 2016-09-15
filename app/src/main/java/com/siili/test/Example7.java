package com.siili.test;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Example7 extends AppCompatActivity {

    @BindView(R.id.textView1_async)
    TextView textView;

    @BindView(R.id.progressBar1)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example7);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1_async)
    void onButton1Click() {
        startProgress();
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                return doSomeBackgroundWork(10000);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                stopProgress();
            }
        }.execute();
    }

    @OnClick(R.id.button2_async)
    void onButton2Clicked() {
        startProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doSomeBackgroundWork(10000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        stopProgress();
                    }
                });
            }
        }).start();
    }

    private Void doSomeBackgroundWork(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void startProgress() {
        textView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void stopProgress() {
        textView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

}

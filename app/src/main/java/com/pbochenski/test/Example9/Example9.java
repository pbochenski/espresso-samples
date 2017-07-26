package com.pbochenski.test.Example9;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.pbochenski.test.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Example9 extends AppCompatActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.imageView)
    ImageView imageView;

    Downloader downloader = new Downloader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example9);
        ButterKnife.bind(this);
        Picasso.with(this).setLoggingEnabled(true);
    }

    @OnClick(R.id.start_download_button)
    void startDownloadClicked() {

        downloader.setOnDownloadListener(new Downloader.OnDownloadListener() {
            @Override
            public void finished(Bitmap downloaded) {
                progressBar.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageBitmap(downloaded);
            }
        });

        imageView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        downloader.startDownload(this, "http://i.imgur.com/DvpvklR.png");

    }

}

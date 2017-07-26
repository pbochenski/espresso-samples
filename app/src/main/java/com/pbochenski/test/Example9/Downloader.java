package com.pbochenski.test.Example9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by bochen on 15.09.2016.
 */
public class Downloader {

    interface OnDownloadListener {
        void finished(Bitmap downloaded);
    }

    OnDownloadListener listener;

    public void setOnDownloadListener(OnDownloadListener listener) {
        this.listener = listener;
    }

    public void startDownload(Context context, String url) {
        Picasso.with(context)
                .load(url)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        listener.finished(bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        //dont care in this example
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        //dont care in this exampl
                    }
                });
    }
}

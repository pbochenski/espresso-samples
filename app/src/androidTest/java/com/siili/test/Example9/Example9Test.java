package com.siili.test.Example9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.siili.test.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static com.siili.test.TestActions.click;

/**
 * Created by bochen on 15.09.2016.
 */

@RunWith(AndroidJUnit4.class)
public class Example9Test {

    @Rule
    public ActivityTestRule<Example9> activity = new ActivityTestRule<>(Example9.class);

    @Test
    public void loadTestFromFile() {
        activity.getActivity().downloader = new MockDownloader();
        click(R.id.start_download_button);
    }

    class MockDownloader extends Downloader {
        @Override
        public void startDownload(Context context, String url) {
            Bitmap bitmap = null;
            try {
                Context context1 = InstrumentationRegistry.getInstrumentation().getContext();
                bitmap = BitmapFactory.decodeStream(context1.getAssets().open("siili_logo_1200x.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            listener.finished(bitmap);
        }
    }
}
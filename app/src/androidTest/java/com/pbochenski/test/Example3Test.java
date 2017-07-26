package com.pbochenski.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.UriMatchers.hasHost;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by bochen on 09.09.2016.
 */
@RunWith(AndroidJUnit4.class)
public class Example3Test {

    @Rule
    public IntentsTestRule<Example3> activity = new IntentsTestRule<>(Example3.class);

    @Test
    public void outgoingTest() {
        onView(withId(R.id.outgoing)).perform(click());
        intended(allOf(
                hasAction(equalTo(Intent.ACTION_VIEW)),
                hasData(hasHost(equalTo("www.google.com")))));
    }

    @Test
    public void incomingTest() {
        Intent resultData = new Intent();
        resultData.setData(Uri.parse("content://com.android.contacts/data/1"));
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        intending(hasAction(equalTo(Intent.ACTION_PICK))).respondWith(result);

        onView(withId(R.id.incoming)).perform(click());

        onView(withId(R.id.incoming_result)).check(matches(withText("content://com.android.contacts/data/1")));
    }
}
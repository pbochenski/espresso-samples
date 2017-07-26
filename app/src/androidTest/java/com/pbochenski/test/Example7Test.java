package com.pbochenski.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by bochen on 15.09.2016.
 */

@RunWith(AndroidJUnit4.class)
public class Example7Test {

    @Rule
    public ActivityTestRule<Example7> activity = new ActivityTestRule<>(Example7.class);

    @Test
    public void testWaitingWithAsyncTask() {
        onView(withId(R.id.button1_async)).perform(click());
        //onView(withId(R.id.progressBar1)).check(matches(isDisplayed()));
        onView(withText("Data loaded")).check(matches(isDisplayed()));
    }

    @Test
    public void testWaitingWithThread() {
        onView(withId(R.id.button2_async)).perform(click());
        //onView(withId(R.id.progressBar1)).check(matches(isDisplayed()));
        onView(withText("Data loaded")).check(matches(isDisplayed()));
    }
}
package com.pbochenski.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by bochen on 09.09.2016.
 */
@RunWith(AndroidJUnit4.class)
public class Example1Test {

    @Rule
    public ActivityTestRule<Example1> activity = new ActivityTestRule<>(Example1.class);

    @Test
    public void shouldTestClickingButton() {
        for (int i = 0; i < 20; i++) {
            onView(withId(R.id.clickmebutton)).perform(click());
        }
        onView(withId(R.id.textView)).check(matches(withText("Clicked: 20 times")));
    }

    @Test
    public void shouldCheckInputs() {
        onView(withId(R.id.editText)).perform(typeText("test"));
        closeSoftKeyboard();
        onView(withId(R.id.editText2)).perform(typeText("test"));
        closeSoftKeyboard();
        onView(withId(R.id.submitbutton)).perform(click());


        onView(withId(R.id.passwordMatchText)).check(matches(withText("OK")));
    }
}
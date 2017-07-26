package com.pbochenski.test;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by bochen on 12.09.2016.
 */

@RunWith(AndroidJUnit4.class)
public class Example5Test {

    @Rule
    public ActivityTestRule<Example5> activity = new ActivityTestRule<>(Example5.class);

    @Test
    public void testCustomMatcher() {
        onView(withId(R.id.siili_text_view)).check(matches(withCustomText()));
        onView(withId(R.id.not_siili_text_view)).check(matches(not(withCustomText())));

        onView(allOf(withCustomText(), is(instanceOf(Button.class)))).perform(click());
    }


    private static Matcher<View> withCustomText() {

        return new BoundedMatcher<View, TextView>(TextView.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("with custom text");
            }

            @Override
            protected boolean matchesSafely(TextView item) {
                return item.getText().toString().startsWith("Siili");
            }
        };
    }


}
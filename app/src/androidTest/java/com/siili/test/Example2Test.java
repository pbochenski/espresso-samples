package com.siili.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


/**
 * Created by bochen on 12.09.2016.
 */
@RunWith(AndroidJUnit4.class)
public class Example2Test {

    @Rule
    public ActivityTestRule<Example2> activity = new ActivityTestRule<>(Example2.class);

    @Test
    public void spinner1Test() {
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("two"))).perform(click());
        onView(withText("two")).inRoot(withDecorView(is(activity.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void list1Test() {
        onData(allOf(is(instanceOf(String.class)), is("list two"))).inAdapterView(withId(R.id.list)).perform(click());
        onView(withText("list two")).inRoot(withDecorView(is(activity.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

}
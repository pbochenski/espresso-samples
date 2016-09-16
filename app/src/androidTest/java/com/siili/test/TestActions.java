package com.siili.test;

import android.support.annotation.IdRes;
import android.support.test.espresso.action.ViewActions;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by bochen on 15.09.2016.
 */

public class TestActions {

    public static void click(@IdRes int button) {
        onView(withId(button)).perform(ViewActions.click());
    }

    public static void input(@IdRes int view, String text) {
        onView(withId(view)).perform(typeText(text));
    }

    public static void checkIfVisible(@IdRes int view) {
        onView(withId(view)).check(matches(isDisplayed()));
    }
}

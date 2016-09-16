package com.siili.test;

import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by bochen on 12.09.2016.
 */
@RunWith(AndroidJUnit4.class)
public class Example4Test {

    @Rule
    public ActivityTestRule<Example4> activity = new ActivityTestRule<>(Example4.class);
    private UiDevice device;

    @Before
    public void setup() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testAcceptPermission() throws UiObjectNotFoundException {
        onView(withId(R.id.reqpermbut)).perform(click());

        //click on grant
        UiObject permit = device.findObject(new UiSelector().text("Allow"));
        permit.click();

        onView(withId(R.id.textView)).check(matches(withText("Permission granted")));
    }

    @Test
    public void testDenyPermission() throws UiObjectNotFoundException {
        onView(withId(R.id.reqpermbut)).perform(click());
        //click on grant
        UiObject permit = device.findObject(new UiSelector().text("Deny"));
        permit.click();

        onView(withId(R.id.textView)).check(matches(withText("Permission denied")));
    }

    @After
    public void after() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("pm reset-permissions");
        }
    }


}
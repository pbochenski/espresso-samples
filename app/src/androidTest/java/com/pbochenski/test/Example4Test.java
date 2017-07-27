package com.pbochenski.test;

import android.Manifest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.pbochenski.test.TestActions.checkIfText;
import static com.pbochenski.test.TestActions.click;

/**
 * Created by bochen on 12.09.2016.
 */
@RunWith(AndroidJUnit4.class)
public class Example4Test {
    @Rule
    public ActivityTestRule<Example4> activity = new ActivityTestRule<>(Example4.class);
    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(Manifest.permission.READ_CONTACTS);

    @Test
    public void permissionTest() {
        click(R.id.reqpermbut);

        checkIfText(R.id.textView, "Permission granted");
    }
}
package com.pbochenski.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.pbochenski.test.TestActions.checkIfVisible;
import static com.pbochenski.test.TestActions.click;
import static com.pbochenski.test.TestActions.input;
import static com.pbochenski.test.TestBuildingBlocks.login;
import static com.pbochenski.test.TestBuildingBlocks.writeComment;

/**
 * Created by bochen on 15.09.2016.
 */

@RunWith(AndroidJUnit4.class)
public class Example8Test {

    @Rule
    public ActivityTestRule<Example8> activity = new ActivityTestRule<>(Example8.class);

    @Test
    public void shouldLogin() {
        input(R.id.editText4, "Siili");
        input(R.id.editText5, "password");
        click(R.id.buttonLogin);
        checkIfVisible(R.id.comment_view);
    }

    @Test
    public void shouldBeAbleToWriteCommentAfterLogin() {
        login();
        writeComment();
        checkIfVisible(R.id.textView3);
    }
}
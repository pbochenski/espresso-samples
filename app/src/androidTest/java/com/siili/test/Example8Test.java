package com.siili.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.siili.test.TestActions.checkIfVisible;
import static com.siili.test.TestActions.click;
import static com.siili.test.TestActions.input;
import static com.siili.test.TestBuildingBlocks.login;
import static com.siili.test.TestBuildingBlocks.writeComment;

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
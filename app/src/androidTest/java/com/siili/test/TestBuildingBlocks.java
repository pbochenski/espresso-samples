package com.siili.test;

import android.support.test.espresso.Espresso;

import static com.siili.test.TestActions.click;
import static com.siili.test.TestActions.input;

/**
 * Created by bochen on 15.09.2016.
 */

class TestBuildingBlocks {

    static void login() {
        input(R.id.editText4, "Siili");
        input(R.id.editText5, "password");
        click(R.id.buttonLogin);
    }

    static void writeComment() {
        input(R.id.editText6, "Some very meaningful comment as seen on Internet");
        Espresso.closeSoftKeyboard();
        click(R.id.button_submit);
    }

}

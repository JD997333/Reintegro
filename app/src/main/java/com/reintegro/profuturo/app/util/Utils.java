package com.reintegro.profuturo.app.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.reintegro.profuturo.app.android.base.ActivityBase;

public class Utils {
    public static void hideSoftKeyboard(ActivityBase activity) {
        View view = activity.getCurrentFocus();

        InputMethodManager iim = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        assert view != null;
        if (iim != null && view != null)
            iim.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

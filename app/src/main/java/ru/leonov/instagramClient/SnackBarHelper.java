package ru.leonov.instagramClient;

import android.graphics.Color;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarHelper{
    public static Snackbar getCustomSnackbar(View view, String message) {
        Snackbar mSnackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE );
        View mSnackbarView = mSnackbar.getView();
        mSnackbarView.setBackgroundColor(Color.BLUE);
        //mSnackbarView.setTextColor(Color.RED);
        return mSnackbar;
    }
}


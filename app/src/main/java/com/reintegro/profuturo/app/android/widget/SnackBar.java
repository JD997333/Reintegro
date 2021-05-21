package com.reintegro.profuturo.app.android.widget;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.reintegro.profuturo.app.R;

public class SnackBar {

    public static void show(@NonNull View view, @NonNull String message) {
        Snackbar snackbar = createSnackbar(view);
        snackbar.setText(message);
        snackbar.setAction("X", v -> snackbar.dismiss());
        snackbar.show();
    }

    private static Snackbar createSnackbar(@NonNull View view) {

        Snackbar snackbar = Snackbar.make(view, "", 10000);
        View snackBarView = snackbar.getView();

        FrameLayout.LayoutParams layoutParamsSnackbar = new FrameLayout.LayoutParams(snackBarView.getLayoutParams());
        layoutParamsSnackbar.setMargins(0, 0, 0, 0);
        layoutParamsSnackbar.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        snackBarView.setLayoutParams(layoutParamsSnackbar);

        TextView snackbarTextView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);

        LinearLayout.LayoutParams layoutParamsTextView = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParamsTextView.weight = 1;
        layoutParamsTextView.gravity = Gravity.END;
        snackbarTextView.setLayoutParams(layoutParamsTextView);
        snackbarTextView.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
        snackbarTextView.setMaxLines(3);

        Button snackbarButton = snackBarView.findViewById(com.google.android.material.R.id.snackbar_action);
        LinearLayout.LayoutParams layoutParamsButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        snackbarButton.setLayoutParams(layoutParamsButton);
        snackbarButton.setGravity(Gravity.RIGHT | Gravity.TOP);
        snackbarButton.setPadding(0, 0, 10, 0);

        snackBarView.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.orange));
        int snackBarPadding = (int) view.getResources().getDimension(R.dimen.error_snack_bar_dimen);
        snackBarView.setPadding(snackBarPadding, snackBarPadding, snackBarPadding, snackBarPadding);

        snackbar.setActionTextColor(Color.WHITE);
        return snackbar;
    }
}

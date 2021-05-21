package com.reintegro.profuturo.app.android.ui.dialogs;

import android.view.View;

public class SimpleAlertDialogViewModel {
    private String message;
    private String negativeButtonText;
    private String positiveButtonText;
    private String title;
    private View.OnClickListener closeOnClickListener;
    private View.OnClickListener negativeButtonOnClickListener;
    private View.OnClickListener positiveButtonOnClickListener;
    private int closeVisibility = View.GONE;
    private int negativeButtonVisibility = View.GONE;
    private int positiveButtonVisibility = View.GONE;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNegativeButtonText() {
        return negativeButtonText;
    }

    public void setNegativeButtonText(String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
    }

    public String getPositiveButtonText() {
        return positiveButtonText;
    }

    public void setPositiveButtonText(String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View.OnClickListener getCloseOnClickListener() {
        return closeOnClickListener;
    }

    public void setCloseOnClickListener(View.OnClickListener closeOnClickListener) {
        this.closeOnClickListener = closeOnClickListener;
    }

    public View.OnClickListener getNegativeButtonOnClickListener() {
        return negativeButtonOnClickListener;
    }

    public void setNegativeButtonOnClickListener(View.OnClickListener negativeButtonOnClickListener) {
        this.negativeButtonOnClickListener = negativeButtonOnClickListener;
    }

    public View.OnClickListener getPositiveButtonOnClickListener() {
        return positiveButtonOnClickListener;
    }

    public void setPositiveButtonOnClickListener(View.OnClickListener positiveButtonOnClickListener) {
        this.positiveButtonOnClickListener = positiveButtonOnClickListener;
    }

    public int getCloseVisibility() {
        return closeVisibility;
    }

    public void setCloseVisibility(int closeVisibility) {
        this.closeVisibility = closeVisibility;
    }

    public int getNegativeButtonVisibility() {
        return negativeButtonVisibility;
    }

    public void setNegativeButtonVisibility(int negativeButtonVisibility) {
        this.negativeButtonVisibility = negativeButtonVisibility;
    }

    public int getPositiveButtonVisibility() {
        return positiveButtonVisibility;
    }

    public void setPositiveButtonVisibility(int positiveButtonVisibility) {
        this.positiveButtonVisibility = positiveButtonVisibility;
    }
}

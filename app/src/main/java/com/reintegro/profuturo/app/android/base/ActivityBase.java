package com.reintegro.profuturo.app.android.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.ui.dialogs.SimpleAlertDialog;
import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.util.Utils;

public class ActivityBase extends AppCompatActivity implements ContractBase.View, FragmentBase.OnVisibilityChangeListener {

    private boolean isKeyboardHidden;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        /*if (!isKeyboardHidden){
            Utils.hideSoftKeyboard(this);
        }*/
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isKeyboardHidden = newConfig.keyboardHidden ==Configuration.KEYBOARDHIDDEN_YES;
    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetworkUnavailable() {
        SimpleAlertDialog simpleAlertDialog;
        simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setMessage(getString(R.string.message_network_unavailable_1));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1), (view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setTitle(getString(R.string.notice_1));
        simpleAlertDialog.show(getSupportFragmentManager(), null);
    }
}

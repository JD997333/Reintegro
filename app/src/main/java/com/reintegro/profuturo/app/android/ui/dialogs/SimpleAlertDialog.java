package com.reintegro.profuturo.app.android.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.databinding.DialogSimpleAlertBinding;

public class SimpleAlertDialog extends AppCompatDialogFragment {
    private DialogSimpleAlertBinding viewDataBinding;
    private SimpleAlertDialogViewModel viewModel;

    public SimpleAlertDialog() {
        viewModel = new SimpleAlertDialogViewModel();
        setStyle(STYLE_NO_TITLE, R.style.SimpleAlertDialog);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_simple_alert, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((ViewGroup)view).getChildAt(0).addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            private boolean isWithChanged;

            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (!isWithChanged) {
                    isWithChanged = true;

                    FrameLayout.LayoutParams viewLayoutParams;
                    viewLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    viewLayoutParams.setMarginEnd(0);
                    viewLayoutParams.setMarginStart(0);
                    viewLayoutParams.width = FrameLayout.LayoutParams.WRAP_CONTENT;

                    view.setLayoutParams(viewLayoutParams);

                    WindowManager.LayoutParams windowLayoutParams;
                    windowLayoutParams = getDialog().getWindow().getAttributes();
                    windowLayoutParams.width = v.getWidth() + 64;

                    getDialog().getWindow().setAttributes(windowLayoutParams);
                }
            }
        });

        viewDataBinding = DataBindingUtil.bind(view);
        viewDataBinding.setModel(viewModel);
    }

    public void setCloseButton(View.OnClickListener closeOnClickListener) {
        viewModel.setCloseOnClickListener(closeOnClickListener);
        viewModel.setCloseVisibility(View.VISIBLE);
    }

    public void setMessage(String message) {
        viewModel.setMessage(message);
    }

    public void setNegativeButton(String title, View.OnClickListener negativeButtonOnClickListener) {
        viewModel.setNegativeButtonOnClickListener(negativeButtonOnClickListener);
        viewModel.setNegativeButtonText(title);
        viewModel.setNegativeButtonVisibility(View.VISIBLE);
    }

    public void setPositiveButton(String title, View.OnClickListener positiveButtonOnClickListener) {
        viewModel.setPositiveButtonOnClickListener(positiveButtonOnClickListener);
        viewModel.setPositiveButtonText(title);
        viewModel.setPositiveButtonVisibility(View.VISIBLE);
    }

    public void setTitle(String title) {
        viewModel.setTitle(title);
    }

}

package com.reintegro.profuturo.app.android.ui.dialogs;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.databinding.DialogAuthenticationFolioBinding;

public class AuthenticationFolioDialog extends AppCompatDialogFragment {
    private DialogAuthenticationFolioBinding viewDataBinding;
    private OnCaptureCompleteListener onCaptureCompleteListener;

    public AuthenticationFolioDialog() {
    }

    public interface OnCaptureCompleteListener{
        void onComplete(String folio);
    }

    private final View.OnClickListener acceptButtonOnClickListener = v -> {
        String folio;
        folio = viewDataBinding.folioEditText.getText() != null ? viewDataBinding.folioEditText.getText().toString() : "";
        onCaptureCompleteListener.onComplete(folio);
    };

    private final View.OnClickListener cancelButtonOnClickListener = v -> dismiss();

    private TextWatcher folioTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            viewDataBinding.negativeButton.setEnabled(true);
            viewDataBinding.positiveButton.setEnabled(true);
        }
    };

    public void setOnCaptureCompleteListener(OnCaptureCompleteListener onCaptureCompleteListener){
        this.onCaptureCompleteListener = onCaptureCompleteListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_authentication_folio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDataBinding.closeImageView.setOnClickListener(v -> dismiss());
        viewDataBinding.negativeButton.setOnClickListener(cancelButtonOnClickListener);
        viewDataBinding.positiveButton.setOnClickListener(acceptButtonOnClickListener);
        viewDataBinding.positiveButton.setEnabled(false);
        viewDataBinding.negativeButton.setEnabled(false);
        viewDataBinding.folioEditText.addTextChangedListener(folioTextWatcher);
    }
}

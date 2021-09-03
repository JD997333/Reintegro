package com.reintegro.profuturo.app.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.databinding.ActivitySignatureBinding;

public class SignatureActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_SIGNATURE = "EXTRA_SIGNATURE";

    private ActivitySignatureBinding viewDataBinding;

    private View.OnClickListener acceptOnClickListener = (view) -> {
        viewDataBinding.content.setVisibility(View.GONE);
        viewDataBinding.loading.setVisibility(View.VISIBLE);
        viewDataBinding.signatureView.buildBase64Signature(signature -> {
            Intent result;
            result = new Intent();
            result.putExtra(EXTRA_NAME, getIntent().getStringExtra(EXTRA_NAME));
            result.putExtra(EXTRA_SIGNATURE, signature);

            setResult(RESULT_OK, result);

            finish();
        });
    };

    private View.OnClickListener clearOnClickListener = (view) -> viewDataBinding.signatureView.clear();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_signature);

        viewDataBinding.acceptButton.setOnClickListener(acceptOnClickListener);
        viewDataBinding.clearButton.setOnClickListener(clearOnClickListener);
        viewDataBinding.content.setVisibility(View.VISIBLE);
        viewDataBinding.loading.setVisibility(View.GONE);
        viewDataBinding.titleTextView.setText(String.format(getString(R.string.electronic_signature_of_1), getIntent().getStringExtra(EXTRA_NAME)));
    }

}

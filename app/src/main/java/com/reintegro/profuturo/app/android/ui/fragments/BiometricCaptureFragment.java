package com.reintegro.profuturo.app.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.BiometricCaptureContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentBiometricCaptureBinding;
import com.reintegro.profuturo.app.domain.interactor.BiometricCaptureInteractor;
import com.reintegro.profuturo.app.presenter.BiometricCapturePresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

public class BiometricCaptureFragment extends NavigationAdapter.Fragment implements BiometricCaptureContract.View {
    private FragmentBiometricCaptureBinding viewDataBinding;
    private BiometricCaptureContract.Presenter presenter;

    private View.OnClickListener startCaptureClickListener = (view) -> {

    };

    private View.OnClickListener cancelClickListener = (view) ->{

    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BiometricCaptureContract.Interactor interactor;
        interactor = new BiometricCaptureInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()));
        presenter = new BiometricCapturePresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_biometric_capture, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDataBinding.cancelButton.setOnClickListener(cancelClickListener);
        viewDataBinding.captureButton.setOnClickListener(startCaptureClickListener);
    }

}

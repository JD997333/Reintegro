package com.reintegro.profuturo.app.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.databinding.FragmentInitialCaptureBinding;
import com.reintegro.profuturo.app.domain.interactor.InitialCaptureInteractor;
import com.reintegro.profuturo.app.presenter.InitialCapturePresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

public class InitialCaptureFragment extends NavigationAdapter.Fragment implements InitialCaptureContract.View {
    private FragmentInitialCaptureBinding viewDataBinding;
    private InitialCaptureContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitialCaptureContract.Interactor interactor;
        interactor = new InitialCaptureInteractor();
        presenter = new InitialCapturePresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);
        
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_initial_capture, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

}

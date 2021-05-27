package com.reintegro.profuturo.app.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.ui.adapters.RepaymentResultsAdapter;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.databinding.FragmentInitialCaptureBinding;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;
import com.reintegro.profuturo.app.domain.interactor.InitialCaptureInteractor;
import com.reintegro.profuturo.app.presenter.InitialCapturePresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

import java.util.List;

public class InitialCaptureFragment extends NavigationAdapter.Fragment implements InitialCaptureContract.View {
    private FragmentInitialCaptureBinding viewDataBinding;
    private InitialCaptureContract.Presenter presenter;
    private RepaymentResultsAdapter repaymentResultsAdapter;
    private List<RepaymentDto> repaymentEventsResult;

    private RecyclerView.Adapter.OnItemSelectedListener repaymentEventRadioButtonOnItemSelectedListener = position -> {

    };

    private View.OnClickListener cancelButtonOnClickListener = v -> {

    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitialCaptureContract.Interactor interactor;
        interactor = new InitialCaptureInteractor();
        presenter = new InitialCapturePresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);

        repaymentResultsAdapter = new RepaymentResultsAdapter(getLayoutInflater());
        repaymentResultsAdapter.setRadioButtonOnItemSelectedListener(repaymentEventRadioButtonOnItemSelectedListener);

        presenter.resume();
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
        viewDataBinding.cancelButton.setOnClickListener(cancelButtonOnClickListener);
        viewDataBinding.repaymentResultsRecyclerView.setAdapter(repaymentResultsAdapter);
        viewDataBinding.repaymentResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), androidx.recyclerview.widget.RecyclerView.VERTICAL, false));
    }

    @Override
    public void showRepaymentEvents(List<RepaymentDto> repaymentEventsResult) {
        this.repaymentEventsResult = repaymentEventsResult;
        repaymentResultsAdapter.setRepaymentEvents(repaymentEventsResult);
    }
}

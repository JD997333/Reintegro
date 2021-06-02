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
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.contract.SelectApplicantContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentInitialCaptureBinding;
import com.reintegro.profuturo.app.databinding.FragmentSelectApplicantBinding;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;
import com.reintegro.profuturo.app.domain.interactor.InitialCaptureInteractor;
import com.reintegro.profuturo.app.domain.interactor.SelectApplicantInteractor;
import com.reintegro.profuturo.app.presenter.InitialCapturePresenter;
import com.reintegro.profuturo.app.presenter.SelectApplicantPresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

import java.util.List;

public class SelectApplicantFragment extends NavigationAdapter.Fragment implements SelectApplicantContract.View {
    private FragmentSelectApplicantBinding viewDataBinding;
    private SelectApplicantContract.Presenter presenter;

    private View.OnClickListener cancelButtonOnClickListener = v -> {

    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SelectApplicantContract.Interactor interactor;
        interactor = new SelectApplicantInteractor(new RealmRepositoryFactory());
        presenter = new SelectApplicantPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);

        presenter.resume();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_applicant, container, false);
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
    }

}

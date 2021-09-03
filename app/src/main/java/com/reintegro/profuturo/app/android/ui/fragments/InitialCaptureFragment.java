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
import com.reintegro.profuturo.app.android.ui.dialogs.SimpleAlertDialog;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.android.widget.SnackBar;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentInitialCaptureBinding;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;
import com.reintegro.profuturo.app.domain.interactor.InitialCaptureInteractor;
import com.reintegro.profuturo.app.presenter.InitialCapturePresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;
import com.reintegro.profuturo.app.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class InitialCaptureFragment extends NavigationAdapter.Fragment implements InitialCaptureContract.View {
    private FragmentInitialCaptureBinding viewDataBinding;
    private InitialCaptureContract.Presenter presenter;
    private RepaymentResultsAdapter repaymentResultsAdapter;
    private List<RepaymentDto> repaymentEventsResult;

    private RecyclerView.Adapter.OnItemSelectedListener repaymentEventRadioButtonOnItemSelectedListener =
        position -> presenter.onRepaymentEventSelected(repaymentEventsResult.get(position));

    private View.OnClickListener cancelButtonOnClickListener = v -> presenter.onCancelButtonClicked();

    private View.OnClickListener nextButtonOnClickListener = v -> {
        setBackEnabled(false);
        navigationDelegate.pushRepaymentEventsDetail();
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitialCaptureContract.Interactor interactor;
        interactor = new InitialCaptureInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()));
        presenter = new InitialCapturePresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);
        setResettable(true);

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
        viewDataBinding.nextButton.setEnabled(false);
        viewDataBinding.cancelButton.setOnClickListener(cancelButtonOnClickListener);
        viewDataBinding.nextButton.setOnClickListener(nextButtonOnClickListener);
        viewDataBinding.repaymentResultsRecyclerView.setAdapter(repaymentResultsAdapter);
        viewDataBinding.repaymentResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), androidx.recyclerview.widget.RecyclerView.VERTICAL, false));
    }

    @Override
    public void reset() {
        repaymentResultsAdapter.clearRadioButtons();
        viewDataBinding.nextButton.setEnabled(false);
    }

    @Override
    public void showRepaymentEvents(List<RepaymentDto> repaymentEventsResult) {
        this.repaymentEventsResult = repaymentEventsResult;
        repaymentResultsAdapter.setRepaymentEvents(repaymentEventsResult);
    }

    @Override
    public void showClientData(ClientDto clientDto, String nameHeader) {
        viewDataBinding.clientDataTextView.setText(nameHeader);
        viewDataBinding.nameTextView.setText(clientDto.getName());
        viewDataBinding.lastNameTextView.setText(clientDto.getFatherLastName());
        viewDataBinding.motherLastNameTextView.setText(clientDto.getMotherLastName());
        viewDataBinding.accountNumberTextView.setText(Utils.formatClientAccountNumber(clientDto.getAccountNumber()));
        viewDataBinding.nssTextView.setText(clientDto.getNss());
        viewDataBinding.rfcTextView.setText(clientDto.getRfc());
    }

    @Override
    public void showCancelDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.cancel_message_title));
        simpleAlertDialog.setMessage(getString(R.string.cancel_message_ask));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1),(view) -> {
            simpleAlertDialog.dismiss();
            navigationDelegate.popToSearchClient();
        });
        simpleAlertDialog.setCloseButton((view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setNegativeButton(getString(R.string.cancel_1), (view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void enableNextButton() {
        viewDataBinding.nextButton.setEnabled(true);
    }

    @Override
    public void showNoEventsDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.no_events_title));
        simpleAlertDialog.setMessage(getString(R.string.no_events_message));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1),(view) -> {
            simpleAlertDialog.dismiss();
        });
        simpleAlertDialog.setCloseButton((view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setNegativeButton(getString(R.string.cancel_1), (view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.show(getFragmentManager(), null);
    }
}

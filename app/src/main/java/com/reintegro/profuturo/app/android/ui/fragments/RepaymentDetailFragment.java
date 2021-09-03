package com.reintegro.profuturo.app.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.ui.dialogs.SimpleAlertDialog;
import com.reintegro.profuturo.app.android.widget.SnackBar;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.RepaymentDetailContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentRepaymentDetailBinding;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;
import com.reintegro.profuturo.app.domain.interactor.RepaymentDetailInteractor;
import com.reintegro.profuturo.app.presenter.RepaymentDetailPresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

import java.text.DecimalFormat;

public class RepaymentDetailFragment extends NavigationAdapter.Fragment implements RepaymentDetailContract.View {
    private FragmentRepaymentDetailBinding viewDataBinding;
    private RepaymentDetailContract.Presenter presenter;
    private String weeksAvailable;
    private String weeksNum;

    private View.OnClickListener calculateButtonOnClickListener = v -> {
        if (viewDataBinding.requestedWeeksEditText.getText() != null)
            weeksNum = viewDataBinding.requestedWeeksEditText.getText().toString();
        else
            weeksNum = "0";
        presenter.onCalculateButtonClicked(weeksNum, weeksAvailable);
    };

    private View.OnClickListener backButtonOnClickListener = v -> {
        navigationDelegate.popToInitialCapture();
    };

    private View.OnClickListener cancelButtonOnClickListener = v -> {
        presenter.onCancelButtonClicked();
    };

    private View.OnClickListener confirmButtonOnClickListener = v -> {
        if (weeksNum != null && !weeksNum.isEmpty() && !weeksNum.equals("0")){
            presenter.onConfirmButtonClicked();
        }else{
            SnackBar.show(getView(), getString(R.string.insert_valid_weeks));
        }
    };



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RepaymentDetailContract.Interactor interactor;
        interactor = new RepaymentDetailInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()));
        presenter = new RepaymentDetailPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);

        presenter.resume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repayment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDataBinding.calculateButton.setOnClickListener(calculateButtonOnClickListener);
        viewDataBinding.backButton.setOnClickListener(backButtonOnClickListener);
        viewDataBinding.cancelButton.setOnClickListener(cancelButtonOnClickListener);
        viewDataBinding.confirmButton.setOnClickListener(confirmButtonOnClickListener);
    }

    @Override
    public void showRepaymentInformation(RepaymentDto repaymentDto) {
        viewDataBinding.dateRepaymentEventTextView.setText(repaymentDto.getTrdDate().toDate());
        viewDataBinding.weeksAvailableTextView.setText(String.valueOf(repaymentDto.getMaxWeeksRepayment()));
        viewDataBinding.amountWithdrawalTextView.setText(repaymentDto.getFormatAmountTrd());
        viewDataBinding.dayValue.setText(String.valueOf(repaymentDto.getRepaymentValueDay()));
        weeksAvailable = repaymentDto.getMaxWeeksRepayment().toString();
    }

    @Override
    public void showInsertDataErrorMessage() {
        SnackBar.show(getView(), getString(R.string.insert_valid_weeks));
    }

    @Override
    public void showCalculatedAmount(String repaymentAmount) {
        viewDataBinding.repaymentAmountTextView.setText(repaymentAmount);
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
    public void showConfirmDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.confirm_message_title));
        simpleAlertDialog.setMessage(getString(R.string.confirm_message_text));
        simpleAlertDialog.setPositiveButton(getString(R.string.button_confirm),(view) -> {
            simpleAlertDialog.dismiss();
            presenter.onConfirmRepaymentProcess();
        });
        simpleAlertDialog.setCloseButton((view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setNegativeButton(getString(R.string.modify_text1), (view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showProcedureSuccess() {

    }

    @Override
    public void showSaveInitialCaptureError() {
        SnackBar.show(getView(), getString(R.string.save_initial_capture_error));
    }

    @Override
    public void showNoAvailableWeeksMsg() {
        SnackBar.show(getView(), getString(R.string.no_available_weeks_msg));
    }

    @Override
    public void showIncorrectNumberWeeksMsg() {
        SnackBar.show(getView(), getString(R.string.superior_weeks_msg));
    }

    @Override
    public void showFinishProvisionalDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.procedure_saved_successful));
        simpleAlertDialog.setMessage(getString(R.string.finish_procedure_provisional));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1),(view) -> {
            simpleAlertDialog.dismiss();
            navigationDelegate.popToSearchClient();
        });
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showInsertClientDataMsg() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.confirm_message_title));
        simpleAlertDialog.setMessage(getString(R.string.client_data_error));
        simpleAlertDialog.setPositiveButton(getString(R.string.retry),(view) -> {
            simpleAlertDialog.dismiss();
            presenter.onRetryInsertClient();
        });
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void pushDocumentsCapture() {
        setBackEnabled(false);
        navigationDelegate.pushDocumentsCapture();
    }
}

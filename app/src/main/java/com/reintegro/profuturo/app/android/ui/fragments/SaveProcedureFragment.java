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
import com.reintegro.profuturo.app.android.ui.adapters.DocumentsAdapter;
import com.reintegro.profuturo.app.android.ui.dialogs.SimpleAlertDialog;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.SaveProcedureContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentSaveProcedureBinding;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.domain.interactor.SaveProcedureInteractor;
import com.reintegro.profuturo.app.domain.state.SaveProcedureState;
import com.reintegro.profuturo.app.presenter.SaveProcedurePresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

import java.util.List;

public class SaveProcedureFragment extends NavigationAdapter.Fragment implements SaveProcedureContract.View {
    private FragmentSaveProcedureBinding viewDataBinding;
    private SaveProcedureContract.Presenter presenter;
    private String cellPhone;
    private String email;

    private View.OnClickListener cancelOnClickListener = (view) ->{
        presenter.onClickCancel();
    };

    private View.OnClickListener saveProcedureOnClickListener = (v) ->{
        presenter.onClickSaveProcedure();
    };

    private View.OnClickListener modifyNotificationOnClickListener = (view) ->{
        presenter.onClickModifyNotification();
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SaveProcedureContract.Interactor interactor;
        interactor = new SaveProcedureInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()));
        presenter = new SaveProcedurePresenter();
        presenter.setInteractor(interactor);
        presenter.setState(new SaveProcedureState());
        presenter.setView(this);
        interactor.setPresenter(presenter);

        presenter.resume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_save_procedure, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDataBinding.cancelButton.setOnClickListener(cancelOnClickListener);
        viewDataBinding.finishProcedureButton.setOnClickListener(saveProcedureOnClickListener);
        viewDataBinding.modifyNotificationChannelButton.setOnClickListener(modifyNotificationOnClickListener);
        viewDataBinding.documentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void showClientData(String data) {
        viewDataBinding.clientDataTextView.setText(data);
    }

    @Override
    public void showCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        viewDataBinding.smsRadioButton.setText(cellPhone);
    }

    @Override
    public void showEmail(String email) {
        this.email = email;
        viewDataBinding.clientEmailRadioButton.setText(email);
    }

    @Override
    public void showDocuments(List<DocumentDto> documents) {
        RecyclerView.Adapter adapter;
        adapter = new DocumentsAdapter(getLayoutInflater(), documents);

        viewDataBinding.documentsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showUnselectedNotificationError() {
        SimpleAlertDialog simpleAlertDialog;
        simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setMessage(getString(R.string.unselected_notification_channel_error_1));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1), (view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setTitle(getString(R.string.notice_1));
        simpleAlertDialog.show(getFragmentManager(), null);
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
    public void showConfirmSaveDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.save_procedure_title));
        simpleAlertDialog.setMessage(getString(R.string.confirm_save_procedure));
        simpleAlertDialog.setPositiveButton(getString(R.string.yes),(view) -> {
            simpleAlertDialog.dismiss();
            presenter.onClickConfirmSaveProcedure();
        });
        simpleAlertDialog.setCloseButton((view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setNegativeButton(getString(R.string.not), (view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.show(getFragmentManager(), null);
    }
}

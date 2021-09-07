package com.reintegro.profuturo.app.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.ui.adapters.DocumentsAdapter;
import com.reintegro.profuturo.app.android.ui.dialogs.ModifyNotificationChannelDialog;
import com.reintegro.profuturo.app.android.ui.dialogs.SimpleAlertDialog;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.android.widget.SnackBar;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.SaveProcedureContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentSaveProcedureBinding;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.domain.dto.NotificationChannelDto;
import com.reintegro.profuturo.app.domain.interactor.SaveProcedureInteractor;
import com.reintegro.profuturo.app.domain.state.SaveProcedureState;
import com.reintegro.profuturo.app.presenter.SaveProcedurePresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;
import com.reintegro.profuturo.app.util.Constants;

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

    private CompoundButton.OnCheckedChangeListener emailOnCheckedChangeListener = (buttonView, isChecked) -> {
        if (isChecked) {
            NotificationChannelDto notificationChannelDto;
            notificationChannelDto = new NotificationChannelDto();
            notificationChannelDto.setCellPhone(cellPhone);
            notificationChannelDto.setEmail(email);
            notificationChannelDto.setSelectedNotificationChannel(Constants.NOTIFICATION_CHANNEL_EMAIL);

            presenter.onNotificationChannelSelected(notificationChannelDto);

            viewDataBinding.clientEmailRadioButton.setChecked(true);
            viewDataBinding.noNotifyRadioButton.setChecked(false);
            viewDataBinding.smsRadioButton.setChecked(false);
        }
    };

    private CompoundButton.OnCheckedChangeListener noNotifyOnCheckedChangeListener = (buttonView, isChecked) -> {
        if (isChecked) {
            NotificationChannelDto notificationChannelDto;
            notificationChannelDto = new NotificationChannelDto();
            notificationChannelDto.setCellPhone(cellPhone);
            notificationChannelDto.setEmail(email);
            notificationChannelDto.setSelectedNotificationChannel(Constants.NOTIFICATION_CHANNEL_NO_NOTIFY);

            presenter.onNotificationChannelSelected(notificationChannelDto);

            viewDataBinding.clientEmailRadioButton.setChecked(false);
            viewDataBinding.noNotifyRadioButton.setChecked(true);
            viewDataBinding.smsRadioButton.setChecked(false);
        }
    };

    private CompoundButton.OnCheckedChangeListener smsOnCheckedChangeListener = (buttonView, isChecked) -> {
        if (isChecked) {
            NotificationChannelDto notificationChannelDto;
            notificationChannelDto = new NotificationChannelDto();
            notificationChannelDto.setCellPhone(cellPhone);
            notificationChannelDto.setEmail(email);
            notificationChannelDto.setSelectedNotificationChannel(Constants.NOTIFICATION_CHANNEL_SMS);

            presenter.onNotificationChannelSelected(notificationChannelDto);

            viewDataBinding.clientEmailRadioButton.setChecked(false);
            viewDataBinding.noNotifyRadioButton.setChecked(false);
            viewDataBinding.smsRadioButton.setChecked(true);
        }
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
        viewDataBinding.documentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        viewDataBinding.clientEmailRadioButton.setOnCheckedChangeListener(emailOnCheckedChangeListener);
        viewDataBinding.smsRadioButton.setOnCheckedChangeListener(smsOnCheckedChangeListener);
        viewDataBinding.noNotifyRadioButton.setOnCheckedChangeListener(noNotifyOnCheckedChangeListener);

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
        viewDataBinding.documentsRecyclerView.setEnabled(false);
    }

    @Override
    public void setEmailRadioButtonCheck(boolean checked) {
        viewDataBinding.clientEmailRadioButton.setChecked(checked);
    }

    @Override
    public void setNoNotifyRadioButtonCheck(boolean checked) {
        viewDataBinding.noNotifyRadioButton.setChecked(checked);
    }

    @Override
    public void setSmsRadioButtonCheck(boolean checked) {
        viewDataBinding.smsRadioButton.setChecked(checked);
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

    @Override
    public void showModifyNotificationChannel(NotificationChannelDto notificationChannelDto) {
        ModifyNotificationChannelDialog dialog = new ModifyNotificationChannelDialog(notificationChannelDto);
        dialog.show(getFragmentManager(), null);
        dialog.setCancelable(false);
        dialog.setOnCompleteListener((notificationChannel) -> {
            dialog.dismiss();
            presenter.onNotificationChannelModified(notificationChannel);
        });
    }

    @Override
    public void showCellPhoneError() {
        SnackBar.show(getView(), getString(R.string.validate_cell_phone_error_1));
    }

    @Override
    public void showEmailError() {
        SnackBar.show(getView(), getString(R.string.validate_email_error_1));
    }

    @Override
    public void showSaveProcedureSuccess() {
        SimpleAlertDialog simpleAlertDialog;
        simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setMessage(getString(R.string.save_procedure_success_1));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1), (view) -> {
            simpleAlertDialog.dismiss();
            navigationDelegate.popToGreeting();
        });
        simpleAlertDialog.setTitle(getString(R.string.save_procedure_1));
        simpleAlertDialog.show(getFragmentManager(), null);
    }
}

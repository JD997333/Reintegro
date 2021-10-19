package com.reintegro.profuturo.app.android.ui.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.ui.adapters.ApplicantTypesAdapter;
import com.reintegro.profuturo.app.android.ui.dialogs.AuthenticationFolioDialog;
import com.reintegro.profuturo.app.android.ui.dialogs.SimpleAlertDialog;
import com.reintegro.profuturo.app.android.widget.SnackBar;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.SelectApplicantContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentSelectApplicantBinding;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.interactor.SelectApplicantInteractor;
import com.reintegro.profuturo.app.domain.state.SelectApplicantState;
import com.reintegro.profuturo.app.presenter.SelectApplicantPresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.vo.ApplicantType;

import java.util.ArrayList;
import java.util.List;

public class SelectApplicantFragment extends NavigationAdapter.Fragment implements SelectApplicantContract.View {
    private FragmentSelectApplicantBinding viewDataBinding;
    private SelectApplicantContract.Presenter presenter;
    private ArrayAdapter<String> applicantsAdapter;
    private ApplicantTypesAdapter applicantTypesAdapter;
    private String applicantType = "0";
    private String authFolio = "";
    private String applicantCurp = "";
    private List<ApplicantType> mApplicantTypes;
    private int applicantPosition;
    private ClientDto clientDto;
    private Bitmap identificationIndicatorIcon;
    private Bitmap biometricIndicatorIcon;

    private View.OnClickListener cancelButtonOnClickListener = v -> {
        navigationDelegate.popToSearchClient();
    };

    private View.OnClickListener confirmButtonOnClickListener = v -> {
        if (!applicantType.equals("0")){
            if (!applicantType.equals(Constants.ID_OWNER_APPLICANT.toString())){
                applicantCurp = viewDataBinding.saEtThirdApplicantCurp.getText() != null ? viewDataBinding.saEtThirdApplicantCurp.getText().toString() : "";
            }
            presenter.onConfirmButtonClicked(applicantType, applicantCurp, authFolio);
        }else {
            SnackBar.show(getView(), "Seleccione un tipo de solicitante");
        }
    };

    private AdapterView.OnItemSelectedListener applicantsSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (applicantPosition != position){
                viewDataBinding.confirmButton.setEnabled(true);
            }
            applicantPosition = position;
            authFolio = "";
            if (position > 0){
                presenter.onApplicantSelected(mApplicantTypes.get(position - 1), clientDto);
                applicantType = mApplicantTypes.get(position - 1).getId();
            }else {
                applicantType = "0";
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private final TextWatcher curpTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String inputString = s.toString();
            if (!inputString.equals(inputString.toUpperCase())){
                inputString = inputString.toUpperCase();
                viewDataBinding.saEtThirdApplicantCurp.setText(inputString);
            }
            viewDataBinding.saEtThirdApplicantCurp.setSelection(viewDataBinding.saEtThirdApplicantCurp.length());
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SelectApplicantContract.Interactor interactor;
        interactor = new SelectApplicantInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()));
        presenter = new SelectApplicantPresenter();
        presenter.setInteractor(interactor);
        presenter.setState(new SelectApplicantState());
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
        viewDataBinding.confirmButton.setOnClickListener(confirmButtonOnClickListener);
        viewDataBinding.saSpApplicantTypeSelect.setAdapter(applicantTypesAdapter);
        viewDataBinding.saSpApplicantTypeSelect.setOnItemSelectedListener(applicantsSelectedListener);
        viewDataBinding.saIvIdentificationRecordStatus.setImageBitmap(identificationIndicatorIcon);
        viewDataBinding.saIvBiometricRecordStatus.setImageBitmap(biometricIndicatorIcon);
        viewDataBinding.saEtThirdApplicantCurp.addTextChangedListener(curpTextWatcher);
    }

    @Override
    public void showSaveProcedureSuccessMessage() {
        SnackBar.show(getView(), getString(R.string.save_procedure_success_1));
    }

    @Override
    public void pushInitialCapture() {
        setBackEnabled(false);
        navigationDelegate.pushInitialCapture();
    }

    @Override
    public void showBiometricIndicatorTrue() {
        biometricIndicatorIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_done_gray);
        viewDataBinding.saIvBiometricRecordStatus.setImageBitmap(biometricIndicatorIcon);
    }

    @Override
    public void showBiometricIndicatorFalse() {
        biometricIndicatorIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_close_black);
        viewDataBinding.saIvBiometricRecordStatus.setImageBitmap(biometricIndicatorIcon);
    }

    @Override
    public void showIdentificationIndicatorTrue() {
        identificationIndicatorIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_done_gray);
        viewDataBinding.saIvIdentificationRecordStatus.setImageBitmap(identificationIndicatorIcon);
    }

    @Override
    public void showIdentificationIndicatorFalse() {
        identificationIndicatorIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_close_black);
        viewDataBinding.saIvIdentificationRecordStatus.setImageBitmap(identificationIndicatorIcon);
    }

    @Override
    public void showApplicantTypes(List<ApplicantType> applicantTypes) {
        this.mApplicantTypes = applicantTypes;
        List<String> applicantTypesList = new ArrayList<>();

        for (ApplicantType at : applicantTypes){
            applicantTypesList.add(at.getDescription());
        }

        //applicantsAdapter = new ArrayAdapter<>(getContext(), R.layout.item_simple_spinner, applicantTypesList);
        applicantTypesAdapter = new ApplicantTypesAdapter(getContext(), R.layout.item_simple_spinner);
        applicantTypesAdapter.setApplicantTypes(applicantTypesList);
        viewDataBinding.saSpApplicantTypeSelect.setAdapter(applicantTypesAdapter);
    }

    @Override
    public void showNeedExpedientDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.request_procesar_title));
        simpleAlertDialog.setMessage(getString(R.string.request_procesar_message));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1),(view) -> {
            simpleAlertDialog.dismiss();
            presenter.onNeedExpedientFromProcesar();
        });
        simpleAlertDialog.setCloseButton((view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setNegativeButton(getString(R.string.cancel_1), (view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void setClientData(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    @Override
    public void showCurp(String curp) {
        viewDataBinding.saTvPhCurp.setText(curp);
        viewDataBinding.saEtThirdApplicantCurp.setText("");
        viewDataBinding.saEtThirdApplicantCurp.setEnabled(true);
    }

    @Override
    public void showCurpTit(String curp) {
        viewDataBinding.saTvPhCurp.setText(curp);
        viewDataBinding.saEtThirdApplicantCurp.setText(" ");
        viewDataBinding.saEtThirdApplicantCurp.setEnabled(false);
        applicantCurp = curp;
    }

    @Override
    public void showConfirmDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.send_procesar_title));
        simpleAlertDialog.setMessage(getString(R.string.send_procesar_message));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1),(view) -> {
            simpleAlertDialog.dismiss();
            pushInitialCapture();
        });
        simpleAlertDialog.setCloseButton((view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setNegativeButton(getString(R.string.cancel_1), (view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showNoCoexistenceDialog(String noCoexistenceMessage) {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.no_coexistence_title));
        simpleAlertDialog.setMessage(getString(R.string.no_coexistence_message) + noCoexistenceMessage);
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1),(view) -> {
            simpleAlertDialog.dismiss();
            navigationDelegate.popToSearchClient();
        });
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showCoexistenceServiceError() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.no_coexistence_title));
        simpleAlertDialog.setMessage(getString(R.string.no_coexistence_error));
        simpleAlertDialog.setPositiveButton(getString(R.string.retry),(view) -> {
            simpleAlertDialog.dismiss();
            presenter.onValCoexistenceRetry();
        });
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showInvalidCurpMessage() {
        SnackBar.show(getView(), getString(R.string.invalid_curp));
    }

    @Override
    public void showNoExpedientFoundMessage() {
        SnackBar.show(getView(), getString(R.string.no_expedient_found_msg));
    }

    @Override
    public void setConfirmButtonDisabled() {
        viewDataBinding.confirmButton.setEnabled(false);
    }

    @Override
    public void showSelectApplicantNecesaryMsg() {
        SnackBar.show(getView(), getString(R.string.select_applicant_necesary));
    }

    @Override
    public void setTitleMsgSuccess() {
        viewDataBinding.saTitleTextView.setText(getString(R.string.select_applicant_title));
    }

    @Override
    public void setTitleMsgError() {
        viewDataBinding.saTitleTextView.setText(getString(R.string.select_applicant_title_error));
    }

    @Override
    public void showAuthenticationDialog() {
        AuthenticationFolioDialog dialog = new AuthenticationFolioDialog();
        dialog.setCancelable(false);
        dialog.setOnCaptureCompleteListener((folio) -> {
            dialog.dismiss();
            presenter.onValidateFolioRequired(folio);
        });
        dialog.show(getFragmentManager(), null);
    }

    @Override
    public void showAuthFolioInvalidMsg() {
        SnackBar.show(getView(), getString(R.string.introduce_folio_incorrect));
    }

    @Override
    public void showAuthFolioExpiredDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.auth_folio_title));
        simpleAlertDialog.setMessage(getString(R.string.auth_folio_expired));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1),(view) -> {
            simpleAlertDialog.dismiss();
        });
        simpleAlertDialog.setCloseButton(v -> simpleAlertDialog.dismiss());
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showAuthFolioConfirmDialog() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.auth_folio_title));
        simpleAlertDialog.setMessage(getString(R.string.auth_folio_correct));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1),(view) -> {
            simpleAlertDialog.dismiss();
            presenter.onConfirmAuthFolioDialog();
        });
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showAuthFolioServiceErrorMsg() {
        SnackBar.show(getView(), getString(R.string.auth_folio_service_error));
    }

    @Override
    public void showGetApplicantTypesError() {
        SimpleAlertDialog simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setTitle(getString(R.string.notice_1));
        simpleAlertDialog.setMessage(getString(R.string.get_applicant_error));
        simpleAlertDialog.setPositiveButton(getString(R.string.retry),(view) -> {
            simpleAlertDialog.dismiss();
            presenter.onRetryGetApplicants();
        });
        simpleAlertDialog.setCloseButton((view) -> simpleAlertDialog.dismiss());
        simpleAlertDialog.show(getFragmentManager(), null);
    }
}

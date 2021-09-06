package com.reintegro.profuturo.app.android.ui.fragments;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.BuildConfig;
import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.widget.SnackBar;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.BiometricCaptureContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentBiometricCaptureBinding;
import com.reintegro.profuturo.app.domain.dto.AgentDto;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.interactor.BiometricCaptureInteractor;
import com.reintegro.profuturo.app.presenter.BiometricCapturePresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;
import com.reintegro.profuturo.app.util.Constants;

public class BiometricCaptureFragment extends NavigationAdapter.Fragment implements BiometricCaptureContract.View {
    private FragmentBiometricCaptureBinding viewDataBinding;
    private BiometricCaptureContract.Presenter presenter;
    private ClientDto client;
    private AgentDto agent;

    private static final int BIOMETRIC_CAPTURE_CODE = 2;

    private final View.OnClickListener startCaptureClickListener = (view) -> {
        presenter.onCaptureClick();
    };

    private final View.OnClickListener cancelClickListener = (view) ->{
        presenter.onCancelCLick();
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BiometricCaptureContract.Interactor interactor;
        interactor = new BiometricCaptureInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()), getContext());
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == BIOMETRIC_CAPTURE_CODE){
            if (Activity.RESULT_OK == resultCode){
                presenter.onBiometricEngineResult();
            }else {
                SnackBar.show(getView(), getString(R.string.biometric_engine_failed));
            }
        }
    }

    @Override
    public void setClientData(ClientDto clientData) {
        client = clientData;
    }

    @Override
    public void setAgentData(AgentDto agentData) {
        agent = agentData;
    }

    @Override
    public void pushBiometricMotor(String fingers) {
        Intent biometricIntent = new Intent();

        biometricIntent.setComponent(new ComponentName(Constants.EXTRA_BIOMETRIC_PACKAGE_NAME, Constants.EXTRA_BIOMETRIC_CLASS_NAME));
        biometricIntent.putExtra(Constants.EXTRA_BIOMETRIC_AGENT_ID, agent.getAgentCode());
        biometricIntent.putExtra(Constants.EXTRA_BIOMETRIC_PACKAGE_TAG, BuildConfig.APPLICATION_ID);
        biometricIntent.putExtra(Constants.EXTRA_BIOMETRIC_OPERATION_TAG, Constants.EXTRA_BIOMETRIC_OP_FOUR_FINGERS);
        biometricIntent.putExtra(Constants.EXTRA_BIOMETRIC_TAG, Constants.EXTRA_BIOMETRIC_OP_FOUR_FINGERS);
        biometricIntent.putExtra(Constants.EXTRA_BIOMETRIC_FINGER_EVALUATION, Constants.EXTRA_BIOMETRIC_LEFT_FINGER_INDEX);
        biometricIntent.putExtra(Constants.EXTRA_BIOMETRIC_EMPLOYEE_ID_TAG, client.getCurp());
        biometricIntent.putExtra(Constants.EXTRA_BIOMETRIC_JSON_TAG, fingers);

        startActivityForResult(biometricIntent, BIOMETRIC_CAPTURE_CODE);
    }

    @Override
    public void showGetRecommendedFingersError() {
        SnackBar.show(getView(), getString(R.string.recommended_fingers_error));
    }

    @Override
    public void showGetVoluntarySealError() {
        SnackBar.show(getView(), "Error al obtener el sello de voluntad");
    }

    @Override
    public void showSaveVoluntarySealError() {
        SnackBar.show(getView(), "Error al guardar el sello de voluntad");
    }

    @Override
    public void showSaveVoluntarySealSuccess() {
        SnackBar.show(getView(), "Sello de voluntad guardado exitosamente");
    }
}

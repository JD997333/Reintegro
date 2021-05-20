package com.reintegro.profuturo.app.android.ui.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.BuildConfig;
import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.GreetingContract;
import com.reintegro.profuturo.app.data.factory.GoogleLocationProviderFactory;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentGreetingBinding;
import com.reintegro.profuturo.app.domain.dto.AgentDto;
import com.reintegro.profuturo.app.domain.dto.BranchOfficeDto;
import com.reintegro.profuturo.app.domain.interactor.GreetingInteractor;
import com.reintegro.profuturo.app.presenter.GreetingPresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

import java.util.ArrayList;
import java.util.List;

public class GreetingFragment extends NavigationAdapter.Fragment implements GreetingContract.View {
    private static final int REQUEST_CODE_PERMISSIONS = 0;

    private ArrayAdapter<String> branchOfficeAdapter;
    private FragmentGreetingBinding viewDataBinding;
    private GreetingContract.Presenter presenter;
    private List<BranchOfficeDto> branchOffices;
    private String agentName;
    private String version;

    View.OnClickListener searchClientOnClickListener = (view) -> navigationDelegate.pushSearchClient();

    View.OnClickListener getOutOnClickListener = (view) -> getActivity().finish();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        version = BuildConfig.VERSION_NAME;
        GreetingContract.Interactor interactor;
        interactor = new GreetingInteractor(
            new RetrofitDataProviderFactory(getContext()),
            new GoogleLocationProviderFactory(getContext()),
            new RealmRepositoryFactory()
        );

        presenter = new GreetingPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_greeting,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDataBinding.agentNameTextView.setText(agentName);
        viewDataBinding.versionTextView.setText(version);
        viewDataBinding.getOutButton.setOnClickListener(getOutOnClickListener);
        viewDataBinding.searchOfClientButton.setOnClickListener(searchClientOnClickListener);
    }

    @Override
    public void resumeFragment() {
        boolean hasPermissions;

        hasPermissions = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        if (hasPermissions) {
            if (isNetworkAvailable) {
                presenter.resume();
            } else {
                presenter.onNetworkUnavailable();
            }
        } else {
            requestPermissions(
                new String[] {Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_CODE_PERMISSIONS
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSIONS:
                boolean permissionsGranted = true;

                for (int grantResult : grantResults) {
                    if (grantResult == PackageManager.PERMISSION_DENIED) {
                        permissionsGranted = false;
                        break;
                    }
                }

                if (permissionsGranted) {
                    if (isNetworkAvailable) {
                        presenter.resume();
                    } else {
                        presenter.onNetworkUnavailable();
                    }
                } else {
                    getActivity().finish();
                }

                break;
        }
    }

    @Override
    public void showAgentInformation(AgentDto agentDto) {
        agentName = agentDto.getFullName();
        viewDataBinding.agentNameTextView.setText(agentName);
    }

    @Override
    public void showAgentAssignedBranchOffice(Integer position) {

    }

    @Override
    public void showBranchOffices(List<BranchOfficeDto> branchOfficeDtos) {
        branchOffices = branchOfficeDtos;
        List<String> branchOfficeList = new ArrayList<>();

        for(BranchOfficeDto branch : branchOfficeDtos){
            branchOfficeList.add(branch.getBranchOfficeName());
        }

        branchOfficeAdapter = new ArrayAdapter<>(getContext(),R.layout.item_simple_spinner,branchOfficeList);
        viewDataBinding.branchOfficesSpinner.setAdapter(branchOfficeAdapter);
    }
}

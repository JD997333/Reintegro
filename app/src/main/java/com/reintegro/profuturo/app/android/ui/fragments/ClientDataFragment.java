package com.reintegro.profuturo.app.android.ui.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.ClientDataContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentClientDataBinding;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.ClientEmailDto;
import com.reintegro.profuturo.app.domain.interactor.ClientDataInteractor;
import com.reintegro.profuturo.app.presenter.ClientDataPresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;

public class ClientDataFragment extends NavigationAdapter.Fragment implements ClientDataContract.View {
    private Bitmap clientImage;
    private Bitmap identificationIndicatorIcon;
    private ClientDataContract.Presenter presenter;
    private FragmentClientDataBinding viewDataBinding;
    private String accountNumber;
    private String birthday;
    private String cellPhone;
    private String curp;
    private String email1;
    private String email2;
    private String facebookAccount;
    private String fatherLastName;
    private String federalEntity;
    private String identificationIndicator;
    private String motherLastName;
    private String name;
    private String neighborhood;
    private String nss;
    private String phone;
    private String postalCode;
    private String rfc;
    private String sex;
    private String street;
    private String town;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clientImage = BitmapFactory.decodeResource(getResources(), R.drawable.ic_avatar);

        ClientDataContract.Interactor interactor;
        interactor = new ClientDataInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()));
        presenter = new ClientDataPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);

        presenter.resume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_client_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        viewDataBinding.accountNumberTextView.setText(accountNumber);
        viewDataBinding.birthdayTextView.setText(birthday);
        viewDataBinding.cellPhoneTextView.setText(cellPhone);
        viewDataBinding.clientImageImageView.setImageBitmap(clientImage);
        viewDataBinding.curpTextView.setText(curp);
        viewDataBinding.email1TextView.setText(email1);
        viewDataBinding.email2TextView.setText(email2);
        viewDataBinding.facebookAccountTextView.setText(facebookAccount);
        viewDataBinding.fatherLastNameTextView.setText(fatherLastName);
        viewDataBinding.federalEntityTextView.setText(federalEntity);
        viewDataBinding.identificationIndicatorIconImageView.setImageBitmap(identificationIndicatorIcon);
        viewDataBinding.identificationIndicatorTextView.setText(identificationIndicator);
        viewDataBinding.motherLastNameTextView.setText(motherLastName);
        viewDataBinding.nameTextView.setText(name);
        viewDataBinding.neighborhoodTextView.setText(neighborhood);
        viewDataBinding.nssTextView.setText(nss);
        viewDataBinding.phoneTextView.setText(phone);
        viewDataBinding.postalCodeTextView.setText(postalCode);
        viewDataBinding.rfcTextView.setText(rfc);
        viewDataBinding.sexTextView.setText(sex);
        viewDataBinding.streetTextView.setText(street);
        viewDataBinding.townTextView.setText(town);
    }


    @Override
    public void pushRegisterCapture() {

    }

    @Override
    public void showClient(ClientDto clientDto) {
        accountNumber = clientDto.getAccountNumber();
        birthday = clientDto.getBirthday().toDateExtended();
        cellPhone = clientDto.getCellPhone();
        curp = clientDto.getCurp();
        fatherLastName = clientDto.getFatherLastName();
        federalEntity = clientDto.getFederalEntity();
        motherLastName = clientDto.getMotherLastName();
        name = clientDto.getName();
        neighborhood = clientDto.getNeighborhood();
        nss = clientDto.getNss();
        phone = clientDto.getPhone();
        postalCode = String.valueOf(clientDto.getPostalCode());
        rfc = clientDto.getRfc();
        sex = clientDto.getSex();
        street = clientDto.getStreet();
        town = clientDto.getTown();

        for (ClientEmailDto emailDto : clientDto.getEmails()) {
            if (emailDto.isPreferential()) {
                email1 = emailDto.getEmail();
            } else {
                email2 = emailDto.getEmail();
            }
        }

        viewDataBinding.accountNumberTextView.setText(accountNumber);
        viewDataBinding.birthdayTextView.setText(birthday);
        viewDataBinding.cellPhoneTextView.setText(cellPhone);
        viewDataBinding.curpTextView.setText(curp);
        viewDataBinding.email1TextView.setText(email1);
        viewDataBinding.email2TextView.setText(email2);
        viewDataBinding.facebookAccountTextView.setText(facebookAccount);
        viewDataBinding.fatherLastNameTextView.setText(fatherLastName);
        viewDataBinding.federalEntityTextView.setText(federalEntity);
        viewDataBinding.identificationIndicatorTextView.setText(identificationIndicator);
        viewDataBinding.motherLastNameTextView.setText(motherLastName);
        viewDataBinding.nameTextView.setText(name);
        viewDataBinding.neighborhoodTextView.setText(neighborhood);
        viewDataBinding.nssTextView.setText(nss);
        viewDataBinding.phoneTextView.setText(phone);
        viewDataBinding.postalCodeTextView.setText(postalCode);
        viewDataBinding.rfcTextView.setText(rfc);
        viewDataBinding.sexTextView.setText(sex);
        viewDataBinding.streetTextView.setText(street);
        viewDataBinding.townTextView.setText(town);
    }

    @Override
    public void showClientImage(ClientDto clientDto) {

    }

    @Override
    public void showGetClientImageError() {

    }

    @Override
    public void showIdentificationIndicatorActive() {
        identificationIndicator = getString(R.string.message_identification_permanent_1);
        identificationIndicatorIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_done_gray);

        viewDataBinding.identificationIndicatorIconImageView.setImageBitmap(identificationIndicatorIcon);
        viewDataBinding.identificationIndicatorTextView.setText(identificationIndicator);
    }

    @Override
    public void showIdentificationIndicatorDisabled() {
        identificationIndicator = getString(R.string.message_identification_capture_required_1);
        identificationIndicatorIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_close_black);

        viewDataBinding.identificationIndicatorIconImageView.setImageBitmap(identificationIndicatorIcon);
        viewDataBinding.identificationIndicatorTextView.setText(identificationIndicator);
    }

    @Override
    public void showBiometricIndicatorActive() {

    }

    @Override
    public void showBiometricIndicatorDisabled() {

    }

    @Override
    public void showBiometricIndicatorInTransit() {
        
    }
}

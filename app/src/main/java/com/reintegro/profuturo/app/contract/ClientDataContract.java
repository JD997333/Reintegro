package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.ClientDto;

public interface ClientDataContract {
    interface Interactor extends ContractBase.Interactor<Presenter> {
        void getClient();
        void getClientImage();
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View> {
        void onGetClientImageError();
        void onGetClientImageSuccess(ClientDto clientDto);
        void onGetClientSuccess(ClientDto clientDto);
    }

    interface State extends ContractBase.State {

    }

    interface View extends ContractBase.View {
        void pushRegisterCapture();
        void showClient(ClientDto clientDto);
        void showClientImage(ClientDto clientDto);
        void showGetClientImageError();
        void showIdentificationIndicatorActive();
        void showIdentificationIndicatorDisabled();
        void showBiometricIndicatorActive();
        void showBiometricIndicatorDisabled();
        void showBiometricIndicatorInTransit();
    }
}

package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.ClientDataContract;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.util.Constants;

public class ClientDataPresenter extends PresenterBase<ClientDataContract.Interactor, ClientDataContract.State, ClientDataContract.View> implements ClientDataContract.Presenter {
    @Override
    public void resume() {
        interactor.getClient();
        view.pushRegisterCapture();
    }

    @Override
    public void onGetClientImageError() {
        view.showGetClientImageError();
    }

    @Override
    public void onGetClientImageSuccess(ClientDto clientDto) {
        if (clientDto.getImage() != null) {
            view.showClientImage(clientDto);
        }
    }

    @Override
    public void onGetClientSuccess(ClientDto clientDto) {
        if (clientDto.getIdentificationIndicatorValue() == Constants.IDENTIFICATION_INDICATOR_STATUS_ACTIVE) {
            view.showIdentificationIndicatorActive();
        } else {
            view.showIdentificationIndicatorDisabled();
        }

        view.showClient(clientDto);
    }
}
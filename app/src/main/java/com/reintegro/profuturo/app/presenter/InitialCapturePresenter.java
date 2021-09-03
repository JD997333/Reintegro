package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;
import com.reintegro.profuturo.app.util.Utils;

import java.util.List;

public class InitialCapturePresenter
    extends PresenterBase<InitialCaptureContract.Interactor, InitialCaptureContract.State, InitialCaptureContract.View>
    implements InitialCaptureContract.Presenter {

    @Override
    public void resume() {
        view.showLoading();
        interactor.getClientData();
    }

    @Override
    public void onCancelButtonClicked() {
        view.showCancelDialog();
    }

    @Override
    public void onGetRepaymentEventsSuccess(List<RepaymentDto> repaymentEventsResult) {
        //view.showRepaymentEvents(repaymentEventsResult);
        //view.dismissLoading();
    }

    @Override
    public void onGetRepaymentEventsError() {
        view.dismissLoading();
        view.showNoEventsDialog();
    }

    @Override
    public void onGetClientDataSuccess(ClientDto clientDto) {
        String nameHeader = clientDto.getFullName() + " • " + Utils.formatClientAccountNumber(clientDto.getAccountNumber());
        view.showClientData(clientDto, nameHeader);
        //TODO implement service for TEST
        //interactor.getRepaymentEventsDummy(clientDto);
        interactor.getRepaymentEvents(clientDto);

        //view.dismissLoading();
        //view.showNoEventsDialog();
    }

    @Override
    public void onGetClientDataError() {

    }

    @Override
    public void onRepaymentEventSelected(RepaymentDto repaymentDto) {
        interactor.setSelectedRepaymentEvent(repaymentDto);
    }

    @Override
    public void onSaveRepaymentEventsSuccess(List<RepaymentDto> repaymentEventsResult) {
        view.showRepaymentEvents(repaymentEventsResult);
        view.dismissLoading();
    }

    @Override
    public void onSetSelectedRepaymentEventSuccess() {
        view.enableNextButton();
    }
}

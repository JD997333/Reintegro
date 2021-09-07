package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.RepaymentDetailContract;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.text.DecimalFormat;

public class RepaymentDetailPresenter
    extends PresenterBase<RepaymentDetailContract.Interactor, RepaymentDetailContract.State, RepaymentDetailContract.View>
    implements RepaymentDetailContract.Presenter {

    @Override
    public void resume() {
        interactor.getRepaymentInformation();
    }

    @Override
    public void onCalculateButtonClicked(String weeksNum, String weeksAvailable) {
        view.showCalculatedAmount("");
        if (weeksNum != null && !weeksNum.isEmpty() && !weeksNum.equals("0") && weeksAvailable != null && !weeksAvailable.isEmpty()){
            int weeksSelected = Integer.parseInt(weeksNum);
            int weeksAvailableIn = Integer.parseInt(weeksAvailable);

            if (weeksAvailableIn > 0){
                if (weeksSelected <= weeksAvailableIn){
                    view.showLoading();
                    interactor.calculateRepaymentAmount(weeksSelected);
                    //TODO use this method for TEST
                    //interactor.calculateRepaymentAmountDummy(weeksSelected);
                }else {
                    view.showIncorrectNumberWeeksMsg();
                }
            }else {
                view.showNoAvailableWeeksMsg();
            }
        }else{
            view.showInsertDataErrorMessage();
        }

    }

    @Override
    public void onCalculateRepaymentAmountSuccess(RepaymentDto repaymentDto) {
        DecimalFormat amountFormat = new DecimalFormat("#,###.00");
        String result;

        try{
            result = "$" + amountFormat.format(repaymentDto.getCalculatedAmount());
        }catch (NumberFormatException exc){
            result = "";
        }
        view.showCalculatedAmount(result);
        view.dismissLoading();
    }

    @Override
    public void onCalculateRepaymentAmountError() {
        view.showNoAvailableWeeksMsg();
        view.dismissLoading();
    }

    @Override
    public void onGetRepaymentInformationSuccess(RepaymentDto repaymentDto) {
        view.showRepaymentInformation(repaymentDto);
    }

    @Override
    public void onCancelButtonClicked() {
        view.showCancelDialog();
    }

    @Override
    public void onConfirmButtonClicked() {
        view.showConfirmDialog();
    }

    @Override
    public void onConfirmRepaymentProcess() {
        view.showLoading();
        interactor.saveInitialCapture();
    }

    @Override
    public void onSaveInitialCaptureSuccess() {
        interactor.insertClientData();
    }

    @Override
    public void onSaveInitialCaptureError() {
        view.dismissLoading();
        view.showSaveInitialCaptureError();
    }

    @Override
    public void onInsertClientDataSuccess() {
        view.pushDocumentsCapture();
        view.dismissLoading();
    }

    @Override
    public void onInsertClientDataError() {
        view.showInsertDataErrorMessage();
        view.dismissLoading();
    }

    @Override
    public void onRetryInsertClient() {
        view.showLoading();
        interactor.insertClientData();
    }
}

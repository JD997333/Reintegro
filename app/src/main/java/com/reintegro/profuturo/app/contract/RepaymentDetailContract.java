package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

public interface RepaymentDetailContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void calculateRepaymentAmount(int weeksNum);
        void calculateRepaymentAmountDummy(int weeksNum);
        void getRepaymentInformation();
        void saveInitialCapture();
        void insertClientData();
        void updateProcedure(ProcedureEntity procedureEntity);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onCalculateButtonClicked(String weeksNum, String weeksAvailable);
        void onCalculateRepaymentAmountSuccess(RepaymentDto repaymentDto);
        void onCalculateRepaymentAmountError();
        void onGetRepaymentInformationSuccess(RepaymentDto repaymentDto);
        void onCancelButtonClicked();
        void onConfirmButtonClicked();
        void onConfirmRepaymentProcess();
        void onSaveInitialCaptureSuccess();
        void onSaveInitialCaptureError();
        void onInsertClientDataSuccess();
        void onInsertClientDataError();
        void onRetryInsertClient();
    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void showRepaymentInformation(RepaymentDto repaymentDto);
        void showInsertDataErrorMessage();
        void showCalculatedAmount(String repaymentAmount);
        void showCancelDialog();
        void showConfirmDialog();
        void showProcedureSuccess();
        void showNoAvailableWeeksMsg();
        void showIncorrectNumberWeeksMsg();
        void showFinishProvisionalDialog();
        void showInsertClientDataMsg();
        void pushDocumentsCapture();
        void showSaveInitialCaptureError();
    }

}

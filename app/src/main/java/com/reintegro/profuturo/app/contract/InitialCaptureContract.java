package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.util.List;

public interface InitialCaptureContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getRepaymentEvents();
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onGetRepaymentEventsSuccess(List<RepaymentDto> repaymentEventsResult);
        void onGetRepaymentEventsError();
    }

    interface State extends ContractBase.State {

    }

    interface View extends ContractBase.View{
        void showRepaymentEvents(List<RepaymentDto> repaymentEventsResult);
    }
}

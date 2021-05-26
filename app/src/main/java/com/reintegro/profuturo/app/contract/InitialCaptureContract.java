package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;

public interface InitialCaptureContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getRepaymentEvents();
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onGetRepaymentEventsSuccess();
        void onGetRepaymentEventsError();
    }

    interface State extends ContractBase.State {

    }

    interface View extends ContractBase.View{

    }
}

package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;

public interface BiometricCaptureContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getRecommendedFingers();
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onCancelCLick();
        void onCaptureClick();
    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{

    }
}

package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;

public class InitialCapturePresenter
    extends PresenterBase<InitialCaptureContract.Interactor, InitialCaptureContract.State, InitialCaptureContract.View>
    implements InitialCaptureContract.Presenter {

    @Override
    public void resume() {
        view.showLoading();
        interactor.getRepaymentEvents();
    }

    @Override
    public void onGetRepaymentEventsSuccess() {

    }

    @Override
    public void onGetRepaymentEventsError() {

    }
}

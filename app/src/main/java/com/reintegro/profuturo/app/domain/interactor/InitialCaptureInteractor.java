package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.util.Utils;

public class InitialCaptureInteractor extends InteractorBase<InitialCaptureContract.Presenter> implements InitialCaptureContract.Interactor {

    @Override
    public void getRepaymentEvents() {
        //TODO: Create dummy structure for simulate data
        presenter.onGetRepaymentEventsSuccess(Utils.getMockRepaymentEvents());
    }
}

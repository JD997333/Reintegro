package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.InitialCaptureContract;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.util.List;

public class InitialCapturePresenter
    extends PresenterBase<InitialCaptureContract.Interactor, InitialCaptureContract.State, InitialCaptureContract.View>
    implements InitialCaptureContract.Presenter {

    @Override
    public void resume() {
        view.showLoading();
        interactor.getRepaymentEvents();
    }

    @Override
    public void onGetRepaymentEventsSuccess(List<RepaymentDto> repaymentEventsResult) {
        view.showRepaymentEvents(repaymentEventsResult);
        view.dismissLoading();
    }

    @Override
    public void onGetRepaymentEventsError() {

    }
}

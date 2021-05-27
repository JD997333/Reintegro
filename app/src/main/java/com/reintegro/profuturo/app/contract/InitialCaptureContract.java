package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.RepaymentDto;

import java.util.List;

public interface InitialCaptureContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getClientData();
        void getRepaymentEvents();
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onGetRepaymentEventsSuccess(List<RepaymentDto> repaymentEventsResult);
        void onGetRepaymentEventsError();
        void onGetClientDataSuccess(ClientDto clientDto);
        void onGetClientDataError();
    }

    interface State extends ContractBase.State {

    }

    interface View extends ContractBase.View{
        void showClientData(ClientDto clientDto, String nameHeader);
        void showRepaymentEvents(List<RepaymentDto> repaymentEventsResult);
    }
}

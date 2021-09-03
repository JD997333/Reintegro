package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.ClientDto;

import java.util.List;

public interface SearchResultsContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getSearchResults();
        void setSelectSearchResult(ClientDto clientDto);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onClickCancel();
        void onClickNewSearch();
        void onClickSearchResult(ClientDto clientDto, boolean isSelectedSearchResultParent);
        void onGetSearchResultsSuccess(List<ClientDto> clientDtos);
        void onSetSelectedSearchResultSuccess(ClientDto clientDto);
    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void popToGreeting();
        void popToSearchClient();
        void pushClientDataImmediately();
        void showSearchResults(List<ClientDto> clientDtos);
        void pushRepaymentEvents();
        void pushSelectApplicant();
        void pushSelectApplicantNoGone();
    }
}

package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.SearchClientDto;

public interface SearchClientContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void searchClient(SearchClientDto searchClientDto);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onClickSearch(SearchClientDto searchClientDto);
        void onSearchClientError();
        void onSearchClientSuccess();
    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void pushSearchResults();
    }
}

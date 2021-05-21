package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.SearchClientDto;

public interface SearchClientContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void searchClient(SearchClientDto searchClientDto);
        void validateAccountNumber(SearchClientDto searchClientDto);
        void validateCurp(SearchClientDto searchClientDto);
        void validateNss(SearchClientDto searchClientDto);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onClickSearch(SearchClientDto searchClientDto);
        void onSearchClientError();
        void onSearchClientSuccess();
        void onAccountNumberTextChanged(SearchClientDto searchClientDto);
        void onCurpTextChanged(SearchClientDto searchClientDto);
        void onNssTextChanged(SearchClientDto searchClientDto);
        void onValidateAccountNumberError();
        void onValidateCurpError();
        void onValidateNssError();
    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void pushSearchResults();
        void clearCurp();
        void clearNss();
        void clearAccountNumber();
        void showEmptySearchClientDataError();
        void showSearchClientError();
        void showValidateAccountNumberError();
        void showValidateCurpError();
        void showValidateNssError();
    }
}

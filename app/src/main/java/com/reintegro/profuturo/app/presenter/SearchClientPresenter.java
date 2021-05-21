package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.SearchClientContract;
import com.reintegro.profuturo.app.domain.dto.SearchClientDto;

public class SearchClientPresenter extends PresenterBase<SearchClientContract.Interactor, SearchClientContract.State, SearchClientContract.View>
    implements SearchClientContract.Presenter {

    @Override
    public void onClickSearch(SearchClientDto searchClientDto) {
        view.showLoading();

        if (searchClientDto.getAccountNumber().isEmpty()) {
            searchClientDto.setAccountNumber(null);
        }

        if (searchClientDto.getCurp().isEmpty()) {
            searchClientDto.setCurp(null);
        }

        if (searchClientDto.getNss().isEmpty()) {
            searchClientDto.setNss(null);
        }

        if (searchClientDto.getAccountNumber() != null && !searchClientDto.getAccountNumber().isEmpty()) {
            interactor.validateAccountNumber(searchClientDto);
        } else if (searchClientDto.getCurp() != null && !searchClientDto.getCurp().isEmpty()) {
            interactor.validateCurp(searchClientDto);
        } else if (searchClientDto.getNss() != null && !searchClientDto.getNss().isEmpty()) {
            interactor.validateNss(searchClientDto);
        } else {
            view.showEmptySearchClientDataError();
            view.dismissLoading();
        }
    }

    @Override
    public void onSearchClientError() {
        view.showSearchClientError();
        view.dismissLoading();
    }

    @Override
    public void onSearchClientSuccess() {
        view.pushSearchResults();
        view.dismissLoading();
    }

    @Override
    public void onAccountNumberTextChanged(SearchClientDto searchClientDto) {
        if (!searchClientDto.getAccountNumber().isEmpty()) {
            if (!searchClientDto.getCurp().isEmpty()) {
                view.clearCurp();
            }

            if (!searchClientDto.getNss().isEmpty()) {
                view.clearNss();
            }
        }
    }

    @Override
    public void onCurpTextChanged(SearchClientDto searchClientDto) {
        if (!searchClientDto.getCurp().isEmpty()) {
            if (!searchClientDto.getNss().isEmpty()) {
                view.clearNss();
            }

            if (!searchClientDto.getAccountNumber().isEmpty()) {
                view.clearAccountNumber();
            }
        }
    }

    @Override
    public void onNssTextChanged(SearchClientDto searchClientDto) {
        if (!searchClientDto.getNss().isEmpty()) {
            if (!searchClientDto.getCurp().isEmpty()) {
                view.clearCurp();
            }

            if (!searchClientDto.getAccountNumber().isEmpty()) {
                view.clearAccountNumber();
            }
        }
    }

    @Override
    public void onValidateAccountNumberError() {
        view.showValidateAccountNumberError();
        view.dismissLoading();
    }

    @Override
    public void onValidateCurpError() {
        view.showValidateCurpError();
        view.dismissLoading();
    }

    @Override
    public void onValidateNssError() {
        view.showValidateNssError();
        view.dismissLoading();
    }
}

package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.SearchClientContract;
import com.reintegro.profuturo.app.domain.dto.SearchClientDto;

public class SearchClientPresenter extends PresenterBase<SearchClientContract.Interactor, SearchClientContract.State, SearchClientContract.View>
    implements SearchClientContract.Presenter {

    @Override
    public void onClickSearch(SearchClientDto searchClientDto) {
        interactor.searchClient(searchClientDto);
    }

    @Override
    public void onSearchClientError() {

    }

    @Override
    public void onSearchClientSuccess() {
        view.pushSearchResults();
    }
}

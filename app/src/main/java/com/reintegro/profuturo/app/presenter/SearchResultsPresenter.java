package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.SearchResultsContract;
import com.reintegro.profuturo.app.domain.dto.ClientDto;

import java.util.List;

public class SearchResultsPresenter extends PresenterBase<SearchResultsContract.Interactor, SearchResultsContract.State, SearchResultsContract.View> implements SearchResultsContract.Presenter {
    private boolean isSelectedSearchResultParent;

    @Override
    public void resume() {
        view.showLoading();
        interactor.getSearchResults();
    }

    @Override
    public void onClickCancel() {
        view.popToGreeting();
    }

    @Override
    public void onClickNewSearch() {
        view.popToSearchClient();
    }

    @Override
    public void onClickSearchResult(ClientDto clientDto, boolean isSelectedSearchResultParent) {
        this.isSelectedSearchResultParent = isSelectedSearchResultParent;
        interactor.setSelectSearchResult(clientDto);
    }

    @Override
    public void onGetSearchResultsSuccess(List<ClientDto> clientDtos) {
        view.showSearchResults(clientDtos);
        view.dismissLoading();
    }

    @Override
    public void onSetSelectedSearchResultSuccess(ClientDto clientDto) {
        if (isSelectedSearchResultParent){
            view.pushClientDataImmediately();
            //view.pushSelectApplicantNoGone();
        } else{
            view.pushSelectApplicant();
        }
    }
}

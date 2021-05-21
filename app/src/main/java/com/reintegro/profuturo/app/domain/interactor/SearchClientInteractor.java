package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.SearchClientContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.SearchClientEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.domain.converter.SearchClientConverter;
import com.reintegro.profuturo.app.domain.dto.SearchClientDto;
import com.reintegro.profuturo.app.util.ClientUtils;
import com.reintegro.profuturo.app.util.Constants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchClientInteractor extends InteractorBase<SearchClientContract.Presenter> implements SearchClientContract.Interactor{

    private RepositoryFactory repositoryFactory;
    private DataProviderFactory webServiceProviderFactory;

    public SearchClientInteractor(RepositoryFactory repositoryFactory, DataProviderFactory webServiceProviderFactory) {
        this.repositoryFactory = repositoryFactory;
        this.webServiceProviderFactory = webServiceProviderFactory;
    }

    @Override
    public void searchClient(SearchClientDto searchClientDto) {
        Single
            .create((SingleEmitter<Object> emitter) -> {
                ClientRepository clientRepository;
                clientRepository = repositoryFactory.createClientRepository();
                clientRepository.clear();

                SearchClientEntity searchClientEntity;
                searchClientEntity = SearchClientConverter.convertFromDto(searchClientDto);

                Provider<List<ClientEntity>> clientDataProvider;
                clientDataProvider = webServiceProviderFactory.createGetClientDataProvider(searchClientEntity);
                clientDataProvider.subscribe(new Provider.Subscriber<List<ClientEntity>>() {
                    @Override
                    public void onError(Throwable exception) {
                        emitter.onError(exception);
                    }

                    @Override
                    public void onSuccess(List<ClientEntity> results) {
                        List<ClientEntity> filteredResults;
                        filteredResults = new ArrayList<>();

                        for (ClientEntity result : results) {
                            if (result.getAccountValidity().equals(Constants.ACCOUNT_VALIDITY_VALID)) {
                                filteredResults.add(result);
                            }
                        }

                        filteredResults = clientRepository.addAll(filteredResults);
                        emitter.onSuccess(filteredResults);
                    }
                });
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<Object>() {
                @Override
                public void onError(Throwable e) {
                    presenter.onSearchClientError();
                }

                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onSuccess(Object object) {
                    presenter.onSearchClientSuccess();
                }
            });
    }

    @Override
    public void validateAccountNumber(SearchClientDto searchClientDto) {
        if (searchClientDto.getAccountNumber() != null &&  searchClientDto.getAccountNumber().length() <= Constants.LENGTH_ACCOUNT_NUMBER) {
            searchClientDto.setAccountNumber(ClientUtils.cleanAccountNumber(searchClientDto.getAccountNumber()));
            searchClient(searchClientDto);
        }else{
            presenter.onValidateAccountNumberError();
        }
    }

    @Override
    public void validateCurp(SearchClientDto searchClientDto) {
        if (searchClientDto.getCurp() != null && searchClientDto.getCurp().length() == Constants.LENGTH_CURP) {
            searchClient(searchClientDto);
        } else{
            presenter.onValidateCurpError();
        }
    }

    @Override
    public void validateNss(SearchClientDto searchClientDto) {
        if (searchClientDto.getNss() != null && searchClientDto.getNss().length() == Constants.LENGTH_NSS) {
            searchClient(searchClientDto);
        } else{
            presenter.onValidateNssError();
        }
    }
}

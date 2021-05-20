package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.SearchResultsContract;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.domain.converter.ClientConverter;
import com.reintegro.profuturo.app.domain.dto.ClientDto;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchResultsInteractor extends InteractorBase<SearchResultsContract.Presenter> implements SearchResultsContract.Interactor {
    private RepositoryFactory repositoryFactory;

    public SearchResultsInteractor(RepositoryFactory repositoryFactory){
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void getSearchResults() {
        Single
            .create((SingleEmitter<List<ClientDto>> emitter) -> {
                ClientRepository clientRepository;
                clientRepository = repositoryFactory.createClientRepository();

                List<ClientEntity> clientEntities = clientRepository.getAll();
                emitter.onSuccess(ClientConverter.convertFromEntities(clientEntities));

            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<List<ClientDto>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull List<ClientDto> clientDtos) {
                    presenter.onGetSearchResultsSuccess(clientDtos);
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }
            });
    }

    @Override
    public void setSelectSearchResult(ClientDto clientDto) {
        Single
            .create((SingleEmitter<ClientEntity> emitter) -> {
                ClientRepository clientRepository;
                clientRepository = repositoryFactory.createClientRepository();

                ClientEntity clientEntity;
                clientEntity = ClientConverter.convertFromDto(clientDto);
                clientEntity.setSelected(true);
                clientEntity = clientRepository.update(clientEntity);

                emitter.onSuccess(clientEntity);
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe(new SingleObserver<ClientEntity>() {
                @Override
                public void onError(Throwable error) {

                }

                @Override
                public void onSubscribe(Disposable disposable) {

                }

                @Override
                public void onSuccess(ClientEntity clientEntity) {
                    presenter.onSetSelectedSearchResultSuccess(ClientConverter.convertFromEntity(clientEntity));
                }
            });
    }
}

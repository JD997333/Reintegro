package com.reintegro.profuturo.app.domain.interactor;

import com.reintegro.profuturo.app.base.InteractorBase;
import com.reintegro.profuturo.app.contract.SelectApplicantContract;
import com.reintegro.profuturo.app.data.factory.RepositoryFactory;

public class SelectApplicantInteractor extends InteractorBase<SelectApplicantContract.Presenter> implements SelectApplicantContract.Interactor {
    RepositoryFactory repositoryFactory;

    public SelectApplicantInteractor(RepositoryFactory repositoryFactory){
        this.repositoryFactory = repositoryFactory;
    }


}

//aqui se hace toda la logica

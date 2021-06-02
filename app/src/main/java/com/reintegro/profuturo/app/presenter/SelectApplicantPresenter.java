package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.SelectApplicantContract;

public class SelectApplicantPresenter
        extends PresenterBase<SelectApplicantContract.Interactor, SelectApplicantContract.State, SelectApplicantContract.View>
        implements SelectApplicantContract.Presenter{

    @Override
    public void resume() {
        //similar al load, aqui se carga todo lo que se necesita en el inicio de la carga de la pantalla
        view.showLoading();
    }
}

//Aqui se ejecutan las funciones

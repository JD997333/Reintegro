package com.reintegro.profuturo.app.base;

public class PresenterBase<TInteractor extends ContractBase.Interactor, TState extends ContractBase.State, TView extends ContractBase.View> implements ContractBase.Presenter<TInteractor, TState, TView> {
    protected TInteractor interactor;
    protected TView view;
    protected TState state;

    @Override
    public void resume() {

    }

    @Override
    public void setInteractor(TInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onNetworkUnavailable() {

    }

    @Override
    public void setState(TState state) {
        this.state = state;
    }

    @Override
    public void setView(TView view) {
        this.view = view;
    }
}
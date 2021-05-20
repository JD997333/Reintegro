package com.reintegro.profuturo.app.base;

public class ContractBase {
    public interface Interactor<TPresenter extends Presenter>{
        void resume();
        void setPresenter(TPresenter presenter);
    }

    public interface Presenter<TInteractor extends Interactor, TState extends State, TView extends View> {
        void onNetworkUnavailable();
        void resume();
        void setInteractor(TInteractor interactor);
        void setState(TState state);
        void setView(TView view);
    }

    public interface State{

    }

    public interface View {
        void dismissLoading();
        void showLoading();
        void showNetworkUnavailable();
    }
}
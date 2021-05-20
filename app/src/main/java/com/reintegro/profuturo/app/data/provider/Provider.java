package com.reintegro.profuturo.app.data.provider;

public interface Provider<T> {
    interface Subscriber<T> {
        void onError(Throwable exception);
        void onSuccess(T result);
    }

    void subscribe(Subscriber<T> subscriber);
}

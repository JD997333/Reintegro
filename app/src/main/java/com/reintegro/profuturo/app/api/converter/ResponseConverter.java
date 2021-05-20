package com.reintegro.profuturo.app.api.converter;

public abstract class ResponseConverter<TResponse, TResult> {
    public abstract TResult convert(TResponse response);
}

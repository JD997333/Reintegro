package com.reintegro.profuturo.app.api.validator;

public abstract class ResponseValidator<T> {
    public abstract boolean validate(T response);
}

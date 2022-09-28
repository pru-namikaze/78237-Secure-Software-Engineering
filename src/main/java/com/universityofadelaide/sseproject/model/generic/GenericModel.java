package com.universityofadelaide.sseproject.model.generic;

public abstract class GenericModel<T> {
    public abstract Long getId();

    public abstract T updateParametersIfPresent(T dataCell);
}

package com.qe.core.interfaces;

public interface ResponseDispatcher<T> {

    void dispatch(T data);
}

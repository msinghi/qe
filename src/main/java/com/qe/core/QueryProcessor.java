package com.qe.core;

public interface QueryProcessor<T> {

    public void submit(T query);
}

package com.viv.behavioraldesignpatterns.iterator;

//Iterator interface allowing to iterate over  values of the aggregate
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

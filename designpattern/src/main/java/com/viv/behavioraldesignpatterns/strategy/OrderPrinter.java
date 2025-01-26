package com.viv.behavioraldesignpatterns.strategy;

import java.util.Collection;

public interface OrderPrinter {

    void printOrder(Collection<Order> orders);
}

package com.viv.behavioraldesignpatterns.strategy;

import java.util.Collection;

public class DetailPrinter implements OrderPrinter {

    @Override
    public void printOrder(Collection<Order> orders) {
        System.out.println("************ Detail Report ************");
        System.out.println("***************************************");
        orders.forEach(order -> {
            System.out.println("Order Id: " + order.getId());
            System.out.println("Order Date: " + order.getDate());
            System.out.println("***************************************");
        });

    }


}

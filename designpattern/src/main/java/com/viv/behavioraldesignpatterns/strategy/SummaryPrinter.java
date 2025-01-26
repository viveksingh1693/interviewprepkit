package com.viv.behavioraldesignpatterns.strategy;

import java.util.Collection;

public class SummaryPrinter implements OrderPrinter {

    @Override
    public void printOrder(Collection<Order> orders) {
        System.out.println("**************Summary Report *************");
        orders.forEach(order -> {
            System.out.println("Order Id: " + order.getId());
            System.out.println("Order Date: " + order.getDate());
            System.out.println("Items:");
            order.getItems().forEach((k, v) -> {
                System.out.println("Item: " + k + ", Price: " + v);
            });
            System.out.println("************************************");
        });
    }

    

}

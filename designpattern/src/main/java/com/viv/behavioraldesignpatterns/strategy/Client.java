package com.viv.behavioraldesignpatterns.strategy;

import java.util.LinkedList;

public class Client {

    private static LinkedList<Order> orders = new LinkedList<>();

    public static void main(String[] args) {
        createOrder();
        PrintService printService = new PrintService(new SummaryPrinter());
        printService.printOrder(orders);
        
        
    }

    public static void createOrder() {
        Order order = new Order("100");
        order.addItem("Keyboard", 100.0);
        order.addItem("Mouse", 50.0);
        order.addItem("Monitor", 200.0);
        orders.add(order);

        order = new Order("200");
        order.addItem("Monitor", 200.0);
        order.addItem("Mouse", 50.0);
        orders.add(order);
    }

}

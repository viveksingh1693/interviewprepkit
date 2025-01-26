package com.viv.behavioraldesignpatterns.strategy;

import java.util.LinkedList;

public class PrintService {

    private OrderPrinter printer;


    public PrintService(OrderPrinter printer) {
        this.printer = printer;
    }

    public void printOrder(LinkedList<Order> order) {
            printer.printOrder(order);
    }
}

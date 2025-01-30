package com.viv.structuraldesignpattern.facade;

public class Order {

    private String orderNumber;
    private double amount;

    public Order(String orderNumber, double amount) {
        this.orderNumber = orderNumber;
        this.amount = amount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", amount=" + amount +
                '}';
    }

}

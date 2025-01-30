package com.viv.structuraldesignpattern.facade;

public class Client {

    public static void main(String[] args) {
        EmailFacade emailFacade = new EmailFacade();
        Order order = new Order("101", 99.99);
        emailFacade.sendOrderMail(order);
    }

}

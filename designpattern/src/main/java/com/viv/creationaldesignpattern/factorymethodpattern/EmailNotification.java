package com.viv.creationaldesignpattern.factorymethodpattern;

public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println(message + " Send by Email");
    }
}

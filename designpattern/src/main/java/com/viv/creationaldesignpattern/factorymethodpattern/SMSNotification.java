package com.viv.creationaldesignpattern.factorymethodpattern;

public class SMSNotification implements  Notification{
    @Override
    public void send(String message) {
        System.out.println(message + " Send by SMS");
    }
}

package com.viv.creationaldesignpattern.factorymethodpattern;

public class Client {

    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();

        Notification email = notificationFactory.getNotification("Email");
        email.send("Hello");

        Notification sms = notificationFactory.getNotification("SMS");
        sms.send("Hello");

        Notification email1 = notificationFactory.getNotificationSupplier("EMAIL");
        email.send("Hello");

        Notification sms1 = notificationFactory.getNotificationSupplier("SMS");
        sms.send("Hello");

    }
}

package com.viv.creationaldesignpattern.factorymethodpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationFactory {

    private static final Map<String, Supplier<Notification>> notificationMap = new HashMap<>();

    static {
        notificationMap.put("EMAIL", EmailNotification::new);
        notificationMap.put("SMS", SMSNotification::new);
        notificationMap.put("PUSH", PushNotification::new);
    }

    public Notification getNotificationSupplier(String notificationType) {

        Supplier<Notification> notificationSupplier = notificationMap.get(notificationType);

        if (notificationSupplier != null) {
            return notificationSupplier.get();
        }

        throw new IllegalArgumentException("Notification Type not Supported");
    }

    public Notification getNotification(String notificationType) {
        if (notificationType == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }

        switch (NOTIFICATIONTYPE.fromString(notificationType)) {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + notificationType);
        }
    }


}

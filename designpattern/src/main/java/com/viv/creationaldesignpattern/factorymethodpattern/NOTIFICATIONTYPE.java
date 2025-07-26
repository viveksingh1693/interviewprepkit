package com.viv.creationaldesignpattern.factorymethodpattern;

public enum NOTIFICATIONTYPE {
    EMAIL,
    SMS,
    PUSH
    ;

    public static NOTIFICATIONTYPE fromString(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        switch (type.trim().toUpperCase()) {
            case "EMAIL":
                return EMAIL;
            case "SMS":
                return SMS;
            case "PUSH":
                return PUSH;
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

package com.viv.creationaldesignpattern.singletondesign;

public class Client {

    public static void main(String[] args) {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();

        System.out.println("Are both instances the same? " + (instance1 == instance2));
        instance1.doSomething();
        instance2.doSomething();
    }
}

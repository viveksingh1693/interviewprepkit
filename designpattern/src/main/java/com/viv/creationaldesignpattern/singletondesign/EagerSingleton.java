package com.viv.creationaldesignpattern.singletondesign;

/**
 * Eager Singleton implementation
 * This class is instantiated at the time of class loading.
 * It is thread-safe and does not require synchronization.
 * It is suitable for cases where the instance is needed immediately.
 * It can lead to resource wastage if the instance is never used.
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("Eager Singleton ");
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

    public void doSomething() {
        System.out.println("Doing something in LazySingleton");
    }

}

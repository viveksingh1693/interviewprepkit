package com.viv.creationaldesignpattern.singletondesign;

/**
 * Lazy Singleton implementation
 * This class is instantiated only when it is needed.
 * It is thread-safe and uses double-checked locking to ensure that
 * the instance is created only once in a multi-threaded environment.
 * It is suitable for cases where the instance may not be needed immediately.
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}

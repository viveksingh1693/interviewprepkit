package com.viv.creationaldesignpattern.singletondesign;

/**
 * Thread-Safe Singleton implementation
 * This class ensures that the instance is created in a thread-safe manner.
 * It uses synchronized method to control access to the instance creation.
 * It is suitable for cases where the instance may be accessed by multiple threads.
 * It may have performance overhead due to synchronization.
 * 
 */
public class ThreadSafeSingletonPattern {

    private static ThreadSafeSingletonPattern instance;

    private ThreadSafeSingletonPattern() {
    }

    public static synchronized ThreadSafeSingletonPattern getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingletonPattern();
        }
        return instance;
    }

}

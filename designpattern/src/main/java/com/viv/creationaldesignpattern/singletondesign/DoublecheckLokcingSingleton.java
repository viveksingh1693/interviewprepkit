package com.viv.creationaldesignpattern.singletondesign;

/**
 * Double-checked locking implementation of Singleton Design Pattern.
 * This approach ensures that the instance is created only when it is needed,
 * while also being thread-safe.
 * * It uses a volatile variable to ensure visibility of changes to variables across threads.
 * * This implementation is efficient and avoids the overhead of synchronization
 * * after the instance is initialized.
 * * Example usage:
 * * DoublecheckLokcingSingleton instance1 = DoublecheckLokcingSingleton.getInstance();
 * * * DoublecheckLokcingSingleton instance2 = DoublecheckLokcingSingleton.getInstance();
 * * * System.out.println(instance1 == instance2); // This will print true
 */
public class DoublecheckLokcingSingleton {
    
    private static volatile DoublecheckLokcingSingleton instance;

    private DoublecheckLokcingSingleton(){}

    public static DoublecheckLokcingSingleton getInstance(){
        if(instance == null){
            synchronized (DoublecheckLokcingSingleton.class){
                if(instance == null){
                    instance = new DoublecheckLokcingSingleton();
                }
            }
        }
        return instance;
    }

}

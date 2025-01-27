package com.viv.creationaldesignpattern.singleton;

/**
 * This class uses lazy initialization of singleton instance with double checked locking.
 * This is also a lazy initializing singleton.
 * Although this implementation solves the multi threading issue, with lazy initialization using volatile 
 * and double check locking, the volatile keywordis guaranteed to work only after JVMs starting with version
 * 1.5 and later
 */
public class LazyRegistryWithDcl {

    private LazyRegistryWithDcl() {
    }

    private static volatile LazyRegistryWithDcl INSTANCE;

    public static LazyRegistryWithDcl getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyRegistryWithDcl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyRegistryWithDcl();
                }
            }
        }
        return INSTANCE;
    }
}

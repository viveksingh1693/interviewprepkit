package com.viv.creationaldesignpattern.singleton;

/**
 * (Ref. Google I/O 2k8 Joshua Bloch)
 * Enum based singleton implementation
 * It handles serialization using java in-built mechanism and still ensure single instance
 */
public enum RegistryEnum {
    INSTANCE;

    public void getConfiguration() {
        System.out.println("Get Configuration");
    }

}

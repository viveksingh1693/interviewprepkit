package com.viv.creationaldesignpattern.singleton;

/**
 * Singleton pattern using lazy initialization holder class. This ensure that
 * we have a lazy initializing singleton without worrying about synchronization
 */
public class LazyRegistryWithIODH {

    private LazyRegistryWithIODH() {
        System.out.println("In LazyRegistryWithIODH constructor");
    }

    private static class RegistryHolder {
        static LazyRegistryWithIODH INSTANCE = new LazyRegistryWithIODH();
    }

    public static LazyRegistryWithIODH getInstance() {
        return RegistryHolder.INSTANCE;
    }

}

package com.viv.creationaldesignpattern.singleton;

public class Client {


    public static void main(String[] args) {
        EagerRegistry instance = EagerRegistry.getInstance();
        EagerRegistry instance2 = EagerRegistry.getInstance();
        System.out.println(instance == instance2);

        LazyRegistryWithDcl instance3 = LazyRegistryWithDcl.getInstance();
        LazyRegistryWithDcl instance4 = LazyRegistryWithDcl.getInstance();
        System.out.println(instance3 == instance4);

        @SuppressWarnings("unused")
        LazyRegistryWithIODH singleWithIODH ;
        singleWithIODH = LazyRegistryWithIODH.getInstance();
        singleWithIODH = LazyRegistryWithIODH.getInstance();
        singleWithIODH = LazyRegistryWithIODH.getInstance();
    }
}

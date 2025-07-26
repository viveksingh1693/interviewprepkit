package com.viv.creationaldesignpattern.prototypedesignpattern;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {

    private static final Map<String, Prototype> prototypes = new HashMap<>();

    static {
        prototypes.put("developer", new Employee("Default", "Developer"));
        prototypes.put("manager", new Employee("manager", "Manager"));
    }

    public static Prototype getClone(String type) {
        return prototypes.get(type).clone();
    }
}

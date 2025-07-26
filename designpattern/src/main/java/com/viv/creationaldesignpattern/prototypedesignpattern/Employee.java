package com.viv.creationaldesignpattern.prototypedesignpattern;

public class Employee implements Prototype {
    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }


    @Override
    public Prototype clone() {
        return new Employee(name, designation);
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', designation='" + designation + "'}";
    }
}

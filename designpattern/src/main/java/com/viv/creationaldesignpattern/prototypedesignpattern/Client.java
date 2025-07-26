package com.viv.creationaldesignpattern.prototypedesignpattern;

public class Client {

    public static void main(String[] args) {
        Employee employee = new Employee("Vivek", "Developer");
        System.out.println("Original Employee: " + employee);
        Employee clone =  (Employee)employee.clone();
        System.out.println("Clone Employee: " + clone);
    }
}

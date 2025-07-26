package com.viv.creationaldesignpattern.builderpattern;

public class Client {

    public static void main(String[] args) {
        Student student = new Student.Builder()
            .name("Joe")
            .phone("123356")
            .build();

        System.out.println(student);
    }
}

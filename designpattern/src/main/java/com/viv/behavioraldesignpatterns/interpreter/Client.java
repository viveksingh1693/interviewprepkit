package com.viv.behavioraldesignpatterns.interpreter;

public class Client {

    public static void main(String[] args) {
        Report report = new Report("Cashflow report", "NOT ADMIN");
        ExpressonBuilder builder = new ExpressonBuilder();
        PermissionExpression expression = builder.build(report);
        System.out.println(expression);
        User user1 = new User("Dave","ADMIN","USER");
        System.out.println("User access report: "+ expression.interpret(user1));

    }
}

package com.viv.behavioraldesignpatterns.interpreter;

//Abstract Expression
public interface PermissionExpression {

    boolean interpret(User user);
}

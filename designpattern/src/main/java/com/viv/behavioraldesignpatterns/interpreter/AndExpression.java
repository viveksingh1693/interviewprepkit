package com.viv.behavioraldesignpatterns.interpreter;

public class AndExpression implements PermissionExpression {

    private PermissionExpression expression1;
    private PermissionExpression expression2;

    public AndExpression(PermissionExpression expression1, PermissionExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(User user) {
        return expression1.interpret(user) && expression2.interpret(user);
    }

    @Override
    public String toString() {
        return String.format("(%s AND %s)", expression1, expression2);
    }

}

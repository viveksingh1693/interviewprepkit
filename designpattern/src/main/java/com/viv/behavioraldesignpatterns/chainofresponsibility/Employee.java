package com.viv.behavioraldesignpatterns.chainofresponsibility;

public abstract class Employee implements LeaveApprover {

    private String role;
    private LeaveApprover successor;

    public Employee(String role, LeaveApprover successor) {
        this.role = role;
        this.successor = successor;
    }

    @Override
    public void processLeaveApplication(LeaveApplication application) {
        if (processRequest(application)) {
            return;
        }
        if (successor != null) {
            successor.processLeaveApplication(application);
        }
    }

    protected abstract boolean processRequest(LeaveApplication application);

    @Override
    public String getApproverRole() {
        return role;
    }
}

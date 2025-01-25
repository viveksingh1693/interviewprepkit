package com.viv.behavioraldesignpatterns.chainofresponsibility;

public class Manager extends Employee {

    public Manager(LeaveApprover nextApprover) {
        super("Manager", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {

        switch (application.getType()) {
            case SICK:
                application.approve(getApproverRole());                
                break;
            case PTO:
                if(application.getNoOfDays() <= 5) {
                    application.approve(getApproverRole());
                    return true;
                }
                break;
            default:
                break;
        }

        return false;
    }

}

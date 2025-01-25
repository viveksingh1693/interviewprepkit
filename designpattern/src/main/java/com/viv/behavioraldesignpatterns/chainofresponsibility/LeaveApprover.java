package com.viv.behavioraldesignpatterns.chainofresponsibility;

public interface LeaveApprover {
    void processLeaveApplication(LeaveApplication application);
    String getApproverRole();
}

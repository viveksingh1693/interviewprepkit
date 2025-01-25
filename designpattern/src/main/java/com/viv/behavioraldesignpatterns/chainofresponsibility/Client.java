package com.viv.behavioraldesignpatterns.chainofresponsibility;

import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {
        LeaveApplication application = LeaveApplication.getBuilder()
        .withType(LeaveApplication.Type.SICK)
        .from(LocalDate.now())
        .to(LocalDate.now().plusDays(10))
        .build();
        
        System.out.println(application);
        System.out.println("************************************");
        LeaveApprover approver = createChain();
        approver.processLeaveApplication(application);
        System.out.println(application);

    }

    private static LeaveApprover createChain() {
        Director director = new Director(null);
        Manager projectManager = new Manager(director);
        ProjectLead projectLead = new ProjectLead(projectManager);
        return projectLead;
    }
}

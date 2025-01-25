package com.viv.behavioraldesignpatterns.command;

public class EWSService {

    public void addMember(String contact, String contactGroup) {
        // contact exchange web service
        System.out.println("Added " + contact + " to " + contactGroup);
    }

    public void removeMember(String contact, String contactGroup) {
        // contact exchange web service
        System.out.println("Removed " + contact + " from " + contactGroup);
    }

}

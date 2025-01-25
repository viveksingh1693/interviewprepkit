package com.viv.behavioraldesignpatterns.command;

public class AddMemberCommand implements Command {
    private String emailAddress;
    private String listName;

    private EWSService receiver;

    public AddMemberCommand(EWSService receiver, String emailAddress, String listName) {
        this.receiver = receiver;
        this.emailAddress = emailAddress;
        this.listName = listName;
    }

    @Override
    public void execute() {
        receiver.addMember(emailAddress, listName);
    }

}

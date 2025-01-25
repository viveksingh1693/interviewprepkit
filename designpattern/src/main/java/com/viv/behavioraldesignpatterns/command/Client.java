package com.viv.behavioraldesignpatterns.command;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Command c1 = new AddMemberCommand(new EWSService(), "a@a.com", "A List");
        MailTaskRunner.getInstance().addCommand(c1);
 
        Command c2 = new AddMemberCommand(new EWSService(), "b@b.com", "A List");
        MailTaskRunner.getInstance().addCommand(c2);

        Thread.sleep(3000);
        MailTaskRunner.getInstance().stop();
    }

}

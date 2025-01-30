package com.viv.structuraldesignpattern.facade;


//Facade provides simple methods for client to use
public class EmailFacade {

    public boolean sendOrderMail(Order order) {
        Template template = TemplateFactory.createTemplate(TemplateType.Email);
        Stationary stationary = StationaryFactory.createStationary();
        Email email = Email.getBuilder()
                .withTemplate(template)
                .withStationary(stationary)
                .forObject(order)
                .build();

           Mailer mailer =  Mailer.getMailer();
           return mailer.send(email);


    }
}

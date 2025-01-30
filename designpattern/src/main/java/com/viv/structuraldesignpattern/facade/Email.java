package com.viv.structuraldesignpattern.facade;

public class Email implements Template {
    

    @Override
    public String format(Object obj) {
        return "EMAIL";
    }

    public static EmailBuilder getBuilder() {
        return new EmailBuilder();
    }

    public static class EmailBuilder {
        private Template template;
        private Stationary stationary;
        private Object obj;

        public EmailBuilder withTemplate(Template template) {
            this.template = template;
            return this;
        }

        public EmailBuilder withStationary(Stationary stationary) {
            this.stationary = stationary;
            return this;
        }

        public EmailBuilder forObject(Object obj) {
            this.obj = obj;
            return this;
        }

        public Email build() {
            Email email = new Email();
            // Set the properties of email using the builder
            // For example:
            // email.setTemplate(this.template);
            // email.setStationary(this.stationary);
            // email.setObject(this.obj);
            
            return email;
        }
    }
}

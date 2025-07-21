public class Email {
    private Template template;
    private Stationary stationary;
    private Object order;

    // Add a private constructor to enforce the use of the builder
    public Email() {}

    public static EmailBuilder getBuilder() {
        return new EmailBuilder();
    }

    // Getters for the fields
    public Template getTemplate() {
        return template;
    }

    public Stationary getStationary() {
        return stationary;
    }

    public Object getOrder() {
        return order;
    }

    public static class EmailBuilder {
        private Template template;
        private Stationary stationary;
        private Object order;

        public EmailBuilder withTemplate(Template template) {
            this.template = template;
            return this;
        }

        public EmailBuilder withStationary(Stationary stationary) {
            this.stationary = stationary;
            return this;
        }

        public EmailBuilder forObject(Object order) {
            this.order = order;
            return this;
        }

        public Email build() {
            Email email = new Email();
            email.template = this.template;
            email.stationary = this.stationary;
            email.order = this.order;
            return email;
        }
    }
}
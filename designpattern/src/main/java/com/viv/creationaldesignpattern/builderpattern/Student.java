package com.viv.creationaldesignpattern.builderpattern;

public class Student {
    private String name;
    private String phone;

    Student(Builder builder) {
        this.name = builder.name;
        this.phone = builder.phone;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            '}';
    }

    public static class Builder {
        private String name;
        private String phone;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }
}

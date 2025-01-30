package com.viv.structuraldesignpattern.facade;

public class TemplateFactory {

    public static Template createTemplate(TemplateType type) {
        if (type == null) {
            return null;
        }
        if (type.equals(TemplateType.Email)) {
            return new Email();
        } else {
            return new Stationary();
        }
    }

}

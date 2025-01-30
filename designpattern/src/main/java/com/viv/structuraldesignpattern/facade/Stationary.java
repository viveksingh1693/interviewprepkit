package com.viv.structuraldesignpattern.facade;

public class Stationary implements Template {

    @Override
    public String format(Object obj) {
        return "STATIONARY";
    }

}

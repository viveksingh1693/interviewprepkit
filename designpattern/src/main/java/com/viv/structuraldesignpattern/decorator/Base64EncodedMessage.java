package com.viv.structuraldesignpattern.decorator;

public class Base64EncodedMessage implements Message {

    private Message msg;

    public Base64EncodedMessage(Message msg){
        this.msg = msg;
    }

    @Override
    public String getContent() {
        return msg.getContent().getBytes().toString();
    }

}

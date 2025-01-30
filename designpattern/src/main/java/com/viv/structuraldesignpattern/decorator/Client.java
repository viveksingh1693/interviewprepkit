package com.viv.structuraldesignpattern.decorator;

/**
 * Classes in Java I/O package are great example of decorator pattern
 * For example the java.io.BufferedReader class decorated any java.io.Outputstream objects adds buffering
 * to file writing operations. This improves the disk i/o performace by reducing number of writes
 */
public class Client {

    public static void main(String[] args) {
        Message m = new TextMessage("The <FORCE> is strong with this one.");
        System.out.println(m.getContent());
        Message decorator = new HtmlEncodedMessage(m);
        System.out.println(decorator.getContent());
        Message decorator2 = new Base64EncodedMessage(decorator);
        System.out.println(decorator2.getContent());
    }
}

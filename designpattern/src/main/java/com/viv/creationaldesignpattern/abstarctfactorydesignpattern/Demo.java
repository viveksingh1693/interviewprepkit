package com.viv.creationaldesignpattern.abstarctfactorydesignpattern;

public class Demo {

    public static void main(String[] args) {
        GUIFactory factory;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }

        Application app = new Application(factory);
        app.renderUI();
    }
}

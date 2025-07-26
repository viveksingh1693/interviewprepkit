package com.viv.creationaldesignpattern.abstarctfactorydesignpattern;

public class WindowsButton implements Button{

    @Override
    public void paint() {
        System.out.println("Rendering a Windows-style Button.");
    }
}

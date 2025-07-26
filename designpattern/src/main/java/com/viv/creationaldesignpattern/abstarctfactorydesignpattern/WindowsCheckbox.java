package com.viv.creationaldesignpattern.abstarctfactorydesignpattern;

public class WindowsCheckbox implements  Checkbox{
    @Override
    public void paint() {
        System.out.println("Rendering a Windows-style Checkbox.");
    }
}

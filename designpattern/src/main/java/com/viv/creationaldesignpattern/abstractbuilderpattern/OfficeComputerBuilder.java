package com.viv.creationaldesignpattern.abstractbuilderpattern;

public class OfficeComputerBuilder extends ComputerBuilder {
    public void buildCPU() {
        computer.setCPU("Intel i5");
    }

    public void buildRAM() {
        computer.setRAM("16GB");
    }

    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Graphics");
    }
}

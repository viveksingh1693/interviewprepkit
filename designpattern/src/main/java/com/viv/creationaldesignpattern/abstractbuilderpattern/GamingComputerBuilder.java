package com.viv.creationaldesignpattern.abstractbuilderpattern;

public class GamingComputerBuilder extends ComputerBuilder {

    public void buildCPU() {
        computer.setCPU("Intel i9");
    }

    public void buildRAM() {
        computer.setRAM("32GB");
    }

    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4090");
    }
}

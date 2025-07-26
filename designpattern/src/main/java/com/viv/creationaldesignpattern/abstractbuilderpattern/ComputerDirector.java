package com.viv.creationaldesignpattern.abstractbuilderpattern;

public class ComputerDirector {

    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }
    public void constructComputer() {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildGraphicsCard();
    }
    public Computer getComputer() {
        return builder.getComputer();
    }

}

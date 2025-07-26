package com.viv.creationaldesignpattern.abstractbuilderpattern;

public class BuilderPatternDemo {

    public static void main(String[] args) {
        // Use GamingComputerBuilder
        ComputerBuilder builder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);
        director.constructComputer();
        Computer gamingPC = director.getComputer();
        System.out.println("Gaming PC: " + gamingPC);

        // Use OfficeComputerBuilder
        builder = new OfficeComputerBuilder();
        director = new ComputerDirector(builder);
        director.constructComputer();
        Computer officePC = director.getComputer();
        System.out.println("Office PC: " + officePC);
    }
}

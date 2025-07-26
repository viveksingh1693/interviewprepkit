package com.viv.creationaldesignpattern.abstractbuilderpattern;

public class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;

    // Setters
    public void setCPU(String CPU) { this.CPU = CPU; }
    public void setRAM(String RAM) { this.RAM = RAM; }
    public void setStorage(String storage) { this.storage = storage; }
    public void setGraphicsCard(String graphicsCard) { this.graphicsCard = graphicsCard; }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", graphicsCard=" + graphicsCard + "]";
    }
}

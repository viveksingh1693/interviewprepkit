package com.viv.structuraldesignpattern.composite;

public class Client {

    public static void main(String[] args) {
        File treeOne = createTreeOne();
        treeOne.ls();
        System.out.println("************************************");
        File treeTwo = createTreeTwo();
        treeTwo.ls();
        
    }

    private static File createTreeOne(){
        Directory dir = new Directory("dir");
        File file1 = new BinaryFile("file1", 100);
        File file2 = new BinaryFile("file2", 200);
        dir.addFile(file1);
        dir.addFile(file2);
        return dir;
    }

    private static File createTreeTwo(){

        return new BinaryFile("file1", 100);

    }

}

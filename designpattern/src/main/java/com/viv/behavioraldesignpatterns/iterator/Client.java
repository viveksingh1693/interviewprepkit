package com.viv.behavioraldesignpatterns.iterator;

public class Client {

    public static void main(String[] args) {
        Iterator<ThemeColor> iterator = ThemeColor.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}

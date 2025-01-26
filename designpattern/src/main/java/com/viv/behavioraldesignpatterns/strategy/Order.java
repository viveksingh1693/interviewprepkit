package com.viv.behavioraldesignpatterns.strategy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private String id;

    private LocalDate date;

    private Map<String, Double> items = new HashMap<>();

    public Order(String id) {
        this.id = id;
        this.date = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Map<String, Double> getItems() {
        return items;
    }   

    public void addItem(String name, Double price) {
        items.put(name, price);
    }
}

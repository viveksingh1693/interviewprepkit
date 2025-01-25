package com.viv.behavioraldesignpatterns.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {

    private List<String> permissions;
    
    private String userName;

    public User(String userName, String ... permissions) {
        this.userName = userName;
        this.permissions = new ArrayList<>();
        Stream.of(permissions).forEach(e -> this.permissions.add(e.toLowerCase()));
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public String getUserName() {
        return userName;
    }
}

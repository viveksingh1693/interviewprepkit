package com.viv.behavioraldesignpatterns.interpreter;

public class Report {

    private String name;

    // "NOT ADMIN", "FINANCE_USER AND ADMIN"
    private String permissions;

    public Report(String name, String permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public String getPermissions() {
        return permissions;
    }
}

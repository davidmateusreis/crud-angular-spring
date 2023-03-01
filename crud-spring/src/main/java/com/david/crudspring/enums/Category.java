package com.david.crudspring.enums;

public enum Category {
    BACKEND("Backend"), FRONTEND("Frontend");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String gerValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}

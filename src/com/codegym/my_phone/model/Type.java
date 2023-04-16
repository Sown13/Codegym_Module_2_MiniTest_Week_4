package com.codegym.my_phone.model;

public class Type {
    private static int hidden = 1000;
    private String id;
    private String typeName = "Friend";

    public Type() {
        ++hidden;
        this.id = typeName + hidden;
    }

    public Type(String typeName) {
        ++hidden;
        this.id = typeName + hidden;
        this.typeName = typeName;
    }

    public String getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}

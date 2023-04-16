package com.codegym.my_phone.model;

import java.io.Serializable;

public class Type implements Serializable {
    private static int autoId = 1000;
    private String id;
    private String typeName = "Friend";

    public Type() {
        ++autoId;
        this.id = typeName + autoId;
    }

    public Type(String typeName) {
        ++autoId;
        this.id = typeName + autoId;
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

}

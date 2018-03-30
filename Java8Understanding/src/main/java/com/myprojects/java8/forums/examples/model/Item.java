package com.myprojects.java8.forums.examples.model;

public class Item {

    private Boolean status;
    private Integer val;

    public Item(Boolean status, Integer val) {
        this.status = status;
        this.val = val;
    }

    public Boolean isStatus() {
        return status;
    }

    public Integer getVal() {
        return val;
    }
}

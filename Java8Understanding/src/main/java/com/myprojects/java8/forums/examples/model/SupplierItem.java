package com.myprojects.java8.forums.examples.model;

public class SupplierItem {

    private String name;

    public SupplierItem(){

    }

    public SupplierItem(String name) {
        this.name = name;
    }

    public static String getStaticVal(){
        return "Static Val";
    }

    public String getMsg(){
        return "Hello World!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

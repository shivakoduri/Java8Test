package com.myprojects.java8.forums.examples.model;

public class RunnableDemoBook {

    private int id;
    private String name;

    public RunnableDemoBook(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("id:"+id+", Name:"+name);
    }
}

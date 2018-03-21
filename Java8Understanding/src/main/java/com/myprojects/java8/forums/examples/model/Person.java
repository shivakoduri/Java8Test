package com.myprojects.java8.forums.examples.model;

public class Person {

    private int id;
    private String name;
    private String personType;

    public Person(int id, String name, String personType) {
        this.id = id;
        this.name = name;
        this.personType = personType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPersonType() {
        return personType;
    }
}

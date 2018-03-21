package com.myprojects.java8.forums.examples.model;

public class Employee {

    private int id;
    private int age;

    public Employee(int id, int age) {
        this.id = id;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}

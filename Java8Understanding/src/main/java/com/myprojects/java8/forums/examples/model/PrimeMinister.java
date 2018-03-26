package com.myprojects.java8.forums.examples.model;

import java.util.function.Predicate;

public class PrimeMinister {

    private String name;
    private int age;

    public PrimeMinister(){}
    public PrimeMinister(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}

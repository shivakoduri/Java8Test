package com.myprojects.java8.inaction.examples.chap10;

import java.util.Optional;

public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar(){
        return car;
    }
}

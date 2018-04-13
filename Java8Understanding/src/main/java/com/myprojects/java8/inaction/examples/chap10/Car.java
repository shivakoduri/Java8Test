package com.myprojects.java8.inaction.examples.chap10;

import java.util.Optional;

public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance(){
        return insurance;
    }
}

package com.myprojects.java8.forums.examples.model;

import java.math.BigDecimal;

public class Person2 {

    private String name;
    private BigDecimal weight;

    public Person2(String name, BigDecimal weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}

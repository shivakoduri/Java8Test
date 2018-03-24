package com.myprojects.java8.forums.examples.model;

public class DoubleDemoPerson {

    private String name;
    private double[] weightsInAYear;

    public DoubleDemoPerson(String name, double[] weightsInAYear) {
        this.name = name;
        this.weightsInAYear = weightsInAYear;
    }

    public String getName() {
        return name;
    }

    public double[] getWeightsInAYear() {
        return weightsInAYear;
    }
}

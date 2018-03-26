package com.myprojects.java8.forums.examples.model;

import java.util.Optional;

public class FlatMapDemoPerson {

    Optional<Country > country;

    public  FlatMapDemoPerson(){}
    public FlatMapDemoPerson(Optional<Country> countr) {
        this.country = countr;
    }

    public Optional<Country> getCountry() {
        return country;
    }

    public void setCountry(Optional<Country> countr) {
        this.country = countr;
    }
}

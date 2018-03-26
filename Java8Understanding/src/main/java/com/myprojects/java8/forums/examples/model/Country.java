package com.myprojects.java8.forums.examples.model;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Country {

    Optional<PrimeMinister> primeminister;

    public Country(){}
    public Country(Optional<PrimeMinister> primeMinister){
        this.primeminister = primeMinister;
    }

    public Optional<PrimeMinister> getPrimeminister() {
        return primeminister;
    }

    public void setPrimeminister(Optional<PrimeMinister> primeminister) {
        this.primeminister = primeminister;
    }
}

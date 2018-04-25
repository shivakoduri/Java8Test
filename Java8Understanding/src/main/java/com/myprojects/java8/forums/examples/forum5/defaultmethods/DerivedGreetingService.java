package com.myprojects.java8.forums.examples.forum5.defaultmethods;

public class DerivedGreetingService extends AbstractGreetingService{

    @Override
    public String greet() {
        return "Salut le monde!";
    }
}

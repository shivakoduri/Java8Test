package com.myprojects.java8.forums.examples.forum5.defaultmethods;

public class ExtendedGreetingService implements GreetingService{
    private String name;

    public ExtendedGreetingService(String name) {
        this.name = name;
    }

    @Override
    public String greet() {
        return "Hello " + name + "!";
    }
}

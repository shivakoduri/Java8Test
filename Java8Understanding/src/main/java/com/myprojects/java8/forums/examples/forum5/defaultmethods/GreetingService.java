package com.myprojects.java8.forums.examples.forum5.defaultmethods;

public interface GreetingService {

    default String greet(){
        return "Hello World!";
    }

}

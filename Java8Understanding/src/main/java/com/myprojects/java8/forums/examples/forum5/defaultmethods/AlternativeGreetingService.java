package com.myprojects.java8.forums.examples.forum5.defaultmethods;

public interface AlternativeGreetingService {

    default String greet(){
        return "Alternative Greeting!";
    }
}

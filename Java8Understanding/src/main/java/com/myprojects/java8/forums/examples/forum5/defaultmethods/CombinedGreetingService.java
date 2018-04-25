package com.myprojects.java8.forums.examples.forum5.defaultmethods;

public class CombinedGreetingService implements GreetingService, AlternativeGreetingService{

    /**
     * An implementation of the {@code greet()} method which is defined in both, {@link GreetingService} and
     * {@link AlternativeGreetingService}. This implementation simply delegates to the default {@code greet()}
     * implementation of the {@code GreetingService} interface
     *
     * @return the result of calling {@link GreetingService#greet()}.
     */

    @Override
    public String greet() {
        return GreetingService.super.greet();
    }
}

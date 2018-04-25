package com.myprojects.java8.forums.examples.forum5;

import com.myprojects.java8.forums.examples.forum5.defaultmethods.CombinedGreetingService;
import com.myprojects.java8.forums.examples.forum5.defaultmethods.DefaultGreetingService;
import com.myprojects.java8.forums.examples.forum5.defaultmethods.DerivedGreetingService;
import com.myprojects.java8.forums.examples.forum5.defaultmethods.ExtendedGreetingService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingServiceTest {

    @Test
    public void greetFromDefault() throws Exception {
        assertEquals("Hello World!", new DefaultGreetingService().greet());
    }

    @Test
    public void greetFromExtended() throws Exception {
        assertEquals("Hello Pete!", new ExtendedGreetingService("Pete").greet());
    }

    @Test
    public void greetFromDerived() throws Exception {
        assertEquals("Salut le monde!", new DerivedGreetingService().greet());
    }

    @Test
    public void testName() throws Exception {
        assertEquals("Hello World!", new CombinedGreetingService().greet());

    }
}


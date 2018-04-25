package com.myprojects.java8.forums.examples.forum5;

import com.myprojects.java8.forums.examples.forum5.lambdas.LambdaExample;
import com.myprojects.java8.forums.examples.forum5.model.Personfrm5;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LambdaExampleTest {

    private LambdaExample<Personfrm5> example;
    private Personfrm5 peter;

    @Before
    public void setUp() throws Exception {
        // Nerd info: 5/15/1962 was the release date of Amazing Fantasy #15, where Spider Man had his first appearance
        peter = new Personfrm5("Peter", "Parker", LocalDate.of(1962, 8, 15), Personfrm5.Gender.MALE);
        example = new LambdaExample<>(peter);
    }

    @Test
    public void peterIsOlderThan30() throws Exception {
        // old school
        assertTrue(example.matches(new Predicate<Personfrm5>() {
            @Override
            public boolean test(Personfrm5 person) {
                return person.getAge() > 30;
            }
        }));
    }

    @Test
    public void peterIsOlderThan30WithBlockLambda() throws Exception {
        // new: implement the predicate using a block lambda expression
        assertTrue(example.matches((Personfrm5 p) -> {
            return p.getAge() > 30;
        }));
    }

    @Test
    public void peterIsOlderThan30WithOneLineLambda() throws Exception {
        // implement the predicate using a one line lambda expression
        assertTrue(example.matches((Personfrm5 person) -> person.getAge() > 30));
    }

    @Test
    public void peterIsOlderThan30WithTypeInference() throws Exception {
        // even shorter: let the compiler work out the correct type
        assertTrue(example.matches(p -> p.getAge() > 30));
    }

    @Test
    public void getAgeFromWrappedElementViaFunctionApplication() throws Exception {
        // type is inferred from context
        assertEquals("Parker", example.apply(p -> p.getLastName()));
        // different notation using a method reference
        assertEquals("Parker", example.apply(Personfrm5::getLastName));
    }

    @Test
    public void changeStateOfWrappedElementViaConsumer() throws Exception {
        // this will change the state of the wrapped element!
        example.consume(p -> p.setGender(oppositeOf(p.getGender())));

        assertEquals(Personfrm5.Gender.FEMALE, peter.getGender());
    }

    private static Personfrm5.Gender oppositeOf(Personfrm5.Gender gender) {
        if (gender.equals(Personfrm5.Gender.MALE))
            return Personfrm5.Gender.FEMALE;
        else
            return Personfrm5.Gender.MALE;
    }
}

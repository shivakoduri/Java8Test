package com.myprojects.java8.forums.examples.forum5;

import com.myprojects.java8.forums.examples.forum5.model.Personfrm5;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class LambdaBasedComparatorTest {

    private List<Personfrm5> persons;

    @Before
    public void setUp() throws Exception {
        persons = TestData.listOfPersons();
    }

    @Test
    public void lambdaBasedComparator() throws Exception {
        // comparator is defined on the fly
        Comparator<Personfrm5> byLastNameAsc = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

        Collections.sort(persons, byLastNameAsc);

        for (int i = 0; i < persons.size(); i++) {
            Personfrm5 current = persons.get(i);
            if (i < persons.size() - 1) {
                Personfrm5 next = persons.get(i + 1);
                assertThat(current.getLastName().compareTo(next.getLastName()), lessThanOrEqualTo(0));
            }
        }
    }
}

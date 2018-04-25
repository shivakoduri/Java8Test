package com.myprojects.java8.forums.examples.forum5;

import com.myprojects.java8.forums.examples.forum5.model.Invoice;
import com.myprojects.java8.forums.examples.forum5.model.Personfrm5;
import com.myprojects.java8.forums.examples.forum5.streaming.FilteringAndMapping;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class FilteringAndMappingTest {

    private List<Personfrm5> persons = TestData.listOfPersons();

    private List<Invoice> invoices = TestData.listOfInvoices();

    @Test
    public void collectFirstNamesOfFemales() throws Exception {
        // Matchers.contains should really be called "containsExactlyTheseElementsAndNoOtherElementsInExactlyThisOrder"
        // I hate hamcrest :(
        assertThat(FilteringAndMapping.extractFemaleFirstnames(persons), contains("Jane", "Mary", "Maggie"));
    }

    @Test
    public void extractNames() {
        assertThat(FilteringAndMapping.extractNames(persons.subList(0, 6)),
                contains("Jane Jungle", "Mary Smith", "John Dole", "Michael Abrahams", "Chris Cross", "Pete Power"));
    }

    @Test
    public void extractNamesSortedByLastname() {
        assertThat(FilteringAndMapping.extractNamesSortedByLastname(persons.subList(0, 6)),
                contains("Michael Abrahams", "Chris Cross", "John Dole", "Jane Jungle", "Pete Power", "Mary Smith"));
    }

    @Test
    public void extractAdultWomen() {
        // Yes, I know, this test is time-dependent and will break in a few months/years...
        assertThat(FilteringAndMapping.extractAdultWomen(persons), contains(persons.get(0), persons.get(1)));
    }

    @Test
    public void extractFirstnamesWhereLastnameStartsWith() {
        assertThat(FilteringAndMapping.extractFirstnamesWhereLastnameStartsWith(persons, "S"), contains("Maggie", "Mary"));
    }

    @Test
    public void testExtractAllProducts() throws Exception {
        MatcherAssert.assertThat(FilteringAndMapping.extractAllProducts(invoices),
                containsInAnyOrder("Beer", "Burger", "Corn Flakes", "Chips", "Coke", "Cake", "Left-Handed Scissors"));
    }
}

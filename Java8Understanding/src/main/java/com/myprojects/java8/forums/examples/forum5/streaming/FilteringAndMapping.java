package com.myprojects.java8.forums.examples.forum5.streaming;

import com.myprojects.java8.forums.examples.forum5.model.Invoice;
import com.myprojects.java8.forums.examples.forum5.model.InvoiceItem;
import com.myprojects.java8.forums.examples.forum5.model.Personfrm5;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilteringAndMapping {

    /**
     * Extract a list of names (firstname and lastname separated by space) from a given list of Person objects.
     */
    public static List<String> extractNames(List<Personfrm5> persons) {
        return persons.stream()//
                .<String> map(p -> p.getFirstName() + " " + p.getLastName())//
                .collect(Collectors.<String> toList());
    }

    /**
     * Extract a sorted (ascending by lastname) list of names (firstname and lastname separated by space) from a given list of Person objects.
     */
    public static List<String> extractNamesSortedByLastname(List<Personfrm5> persons) {
        return persons.stream()//
                .sorted((Personfrm5 p1, Personfrm5 p2) -> (p1.getLastName().compareTo(p2.getLastName())))//
                .<String> map(p -> p.getFirstName() + " " + p.getLastName())//
                .collect(Collectors.<String> toList());
    }

    /**
     * From a given list of Person objects, extract a list of female firstnames
     */
    public static List<String> extractFemaleFirstnames(List<Personfrm5> persons) {
        return persons.stream()//
                .filter(p -> p.getGender().equals(Personfrm5.Gender.FEMALE))//
                .<String> map(p -> p.getFirstName())//
                .collect(Collectors.<String> toList());
    }

    /**
     * Extract all females older than 18 years from a given list of Person objects.
     */
    public static List<Personfrm5> extractAdultWomen(List<Personfrm5> persons) {
        return persons.stream()//
                .filter(p -> p.getGender().equals(Personfrm5.Gender.FEMALE))//
                .filter((Personfrm5 p) -> Period.between(p.getBirthDay(), LocalDate.now()).getYears() >= 18)//
                .collect(Collectors.<Personfrm5> toList());
    }

    /**
     * From a given list of Person objects, extract a set of firstnames of the people whose lastname starts with the given string.
     */
    public static Set<String> extractFirstnamesWhereLastnameStartsWith(List<Personfrm5> persons, String startsWith) {
        return persons.stream()//
                .filter((Personfrm5 p) -> p.getLastName().startsWith(startsWith))//
                .<String> map(p -> p.getFirstName())//
                .collect(Collectors.<String> toSet());
    }

    /**
     * From a given list of invoices, extract a set of all product names.
     */
    public static Set<String> extractAllProducts(List<Invoice> invoices) {
        return invoices.stream()//
                .<InvoiceItem> flatMap((Invoice i) -> i.getItems().stream())//
                .<String> map((InvoiceItem i) -> i.getProduct())//
                .collect(Collectors.<String> toSet());
    }
}

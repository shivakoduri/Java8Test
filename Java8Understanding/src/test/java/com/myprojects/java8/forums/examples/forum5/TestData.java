package com.myprojects.java8.forums.examples.forum5;

import com.myprojects.java8.forums.examples.forum5.model.Invoice;
import com.myprojects.java8.forums.examples.forum5.model.InvoiceItem;
import com.myprojects.java8.forums.examples.forum5.model.Personfrm5;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static List<Personfrm5> listOfPersons() {
        return Arrays.asList(
                new Personfrm5("Jane", "Jungle", LocalDate.of(1978, 12, 15), Personfrm5.Gender.FEMALE),
                new Personfrm5("Mary", "Smith", LocalDate.of(1980, 10, 19), Personfrm5.Gender.FEMALE),
                new Personfrm5("John", "Dole", LocalDate.of(1973, 5, 31), Personfrm5.Gender.MALE),
                new Personfrm5("Michael", "Abrahams", LocalDate.of(1967, 2, 1), Personfrm5.Gender.MALE),
                new Personfrm5("Chris", "Cross", LocalDate.of(1985, 8, 22), Personfrm5.Gender.MALE),
                new Personfrm5("Pete", "Power", LocalDate.of(1981, 3, 18), Personfrm5.Gender.MALE),
                new Personfrm5("Maggie", "Simpson", LocalDate.of(2012, 10, 18), Personfrm5.Gender.FEMALE)
        );
    }

    public static List<Invoice> listOfInvoices() {
        return Arrays.asList(
                new Invoice("Crusty Burger", "Homer", Arrays.asList(
                        new InvoiceItem("Burger", 5, BigDecimal.valueOf(5)),
                        new InvoiceItem("Coke", 1, BigDecimal.valueOf(5)))),
                new Invoice("Crusty Burger", "Bart", Arrays.asList(
                        new InvoiceItem("Coke", 1, BigDecimal.valueOf(5)))),
                new Invoice("Moe", "Homer", Arrays.asList(
                        new InvoiceItem("Beer", 13, BigDecimal.valueOf(1.5)),
                        new InvoiceItem("Burger", 3, BigDecimal.valueOf(4.5)))),
                new Invoice("Kwik-E-Mart", "Homer", Arrays.asList(
                        new InvoiceItem("Beer", 9, BigDecimal.valueOf(0.9)),
                        new InvoiceItem("Chips", 2, BigDecimal.valueOf(0.5)))),
                new Invoice("Moe", "Marge", Arrays.asList(
                        new InvoiceItem("Beer", 1, BigDecimal.valueOf(1.5)))),
                new Invoice("Kwik-E-Mart", "Bart", Arrays.asList(
                        new InvoiceItem("Coke", 2, BigDecimal.valueOf(2.5)),
                        new InvoiceItem("Chips", 2, BigDecimal.valueOf(0.5)))),
                new Invoice("Kwik-E-Mart", "Marge", Arrays.asList(
                        new InvoiceItem("Cake", 2, BigDecimal.valueOf(3.4)),
                        new InvoiceItem("Corn Flakes", 5, BigDecimal.valueOf(2.3)))),
                new Invoice("Moe", "Homer", Arrays.asList(
                        new InvoiceItem("Beer", 5, BigDecimal.valueOf(1.5)))),
                new Invoice("Flander's Left-Handed Store", "Marge", Arrays.asList(
                        new InvoiceItem("Left-Handed Scissors", 1, BigDecimal.valueOf(10.0))))
        );
    }
}

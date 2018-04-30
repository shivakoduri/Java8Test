package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.comparator.BookComparator;
import com.myprojects.java8.forums.examples.model.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FlatMapDemo {

    public static void main(String... args) {

        // FlatMap with List
        flatMapWithList();

        //Stream flatMap with List of lists
        flatMapWithListOfList();

        //Stream flatMap with Array
        flatMapWithArray();

        //Stream flatMap with Array of Objects
        flatMapWithArrayOfObject();

        //Stream flatMap with Files.lines()
        flatMapWithFile();

        //Opitonal flatMap
        optionalFlatMap();

    }

    private static void optionalFlatMap() {
        //Optional has been introduced in Java 8. It behaves like a container that may keep non-null value.
        // It handles NullPointerException. flatMap is applied only if value is present.

        Optional<PrimeMinister> primeMinister = Optional.of(new PrimeMinister("AAA", 65));
        Optional<Country> country = Optional.of(new Country(primeMinister));
        Optional<FlatMapDemoPerson> person = Optional.of(new FlatMapDemoPerson(country));

        String pmName = person.flatMap(FlatMapDemoPerson::getCountry).flatMap(Country::getPrimeminister).map(PrimeMinister::getName).orElse("None");
        System.out.println(pmName);

    }

    private static void flatMapWithFile() {
        //Files.lines() has been introduced in Java 8
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(ClassLoader.getSystemResource("info.txt").toURI()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Stream<String> stream = lines.flatMap(line -> Stream.of(line.split(" +")));
        List<String> words = new ArrayList<>();
        stream.forEach(w -> words.add(w));
        words.forEach(w -> System.out.println(w));


    }

    private static void flatMapWithArrayOfObject() {
        List<Book> books = Arrays.asList(new Book("AAA", 10), new Book("BBB", 20));
        Writer w1 = new Writer("Mohan", books);

        books = Arrays.asList(new Book("CCC", 30), new Book("DDD", 15));
        Writer w2 = new Writer("Sohan", books);

        books = Arrays.asList(new Book("EEE", 45), new Book("FFF", 25));
        Writer w3 = new Writer("Vikas", books);

        books = Arrays.asList(new Book("GGG", 5), new Book("HHH", 15));
        Writer w4 = new Writer("Ramesh", books);

        Writer[][] writerArray = {{w1, w2}, {w3, w4}};

        Book book = Arrays.stream(writerArray).flatMap(row -> Arrays.stream(row)).flatMap(writer -> writer.getBooks().stream()).max(new BookComparator()).get();

        System.out.println("Name:" + book.getName() + ", Price:" + book.getPrice());

    }

    private static void flatMapWithArray() {
        Integer[][] data = {{1, 2}, {3, 4}, {5, 6}};
        Arrays.stream(data).flatMap(row -> Arrays.stream(row)).filter(num -> num % 2 == 0).forEach(System.out::println);
    }

    private static void flatMapWithListOfList() {
        List<Book> list1 = Arrays.asList(new Book("AAA", 10), new Book("BBB", 20));
        List<Book> list2 = Arrays.asList(new Book("YYY", 30), new Book("ZZZ", 15));
        List<List<Book>> finalList = Arrays.asList(list1, list2);

        Book book = finalList.stream().flatMap(list -> list.stream()).min(new BookComparator()).get();
        System.out.println("Name:" + book.getName() + ", Price:" + book.getPrice());

    }

    private static void flatMapWithList() {
        List<Book> books = Arrays.asList(new Book("AAA", 10), new Book("BBB", 20));
        Writer w1 = new Writer("Mohan", books);

        books = Arrays.asList(new Book("CCC", 10), new Book("DDD", 20));
        Writer w2 = new Writer("Sohan", books);

        List<Writer> writers = Arrays.asList(w1, w2);
        Book book = writers.stream().flatMap(writer -> writer.getBooks().stream()).max(new BookComparator()).get();

        System.out.println("Name:" + book.getName() + ", Price:" + book.getPrice());
    }


}

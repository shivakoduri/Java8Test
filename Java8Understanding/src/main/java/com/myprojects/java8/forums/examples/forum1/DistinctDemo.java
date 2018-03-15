package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DistinctDemo {

    public static void main(String[] args){

        //distinct simple demo
        distinctSimpleDemo();

        //distinct with user objects
        distinctWithUserObjects();

        //distinct by property
        distinctByProperty();
    }

    private static void distinctSimpleDemo(){
        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        long l = list.stream().distinct().count();

        System.out.println("No. of distnct elements:" + l);

        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);
    }

    private static void distinctWithUserObjects(){
        List<Book> list = new ArrayList<>();
        {
            list.add(new Book("Core Java", 200));
            list.add(new Book("Core Java", 200));
            list.add(new Book("Learning Freemarker", 150));
            list.add(new Book("Spring MVC", 300));
            list.add(new Book("Spring MVC", 300));

        }

        long l = list.stream().distinct().count();
        System.out.println("No. of distinct books:" + l);
        list.stream().distinct().forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));
    }

    private static void distinctByProperty(){
        List<Book> list = new ArrayList<>();
        {
            list.add(new Book("Core Java", 200));
            list.add(new Book("Core Java", 300));
            list.add(new Book("Learning Freemaker", 150));
            list.add(new Book("Spring MVC", 200));
            list.add(new Book("Hibernate", 300));
        }

        list.stream().filter(distinctByKey(b -> b.getName()))
                .forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
//        This method returns Predicate instance that maintains state about what is seen previously using ConcurrentHashMap.
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

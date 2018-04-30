package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Person1;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectDemo {

    public static void main(String... args) {

        //Stream.collect using Supplier, Accumulator andCombiner
        streamCollect();

        //Stream.collect() using Collector
        sumOfListDemo();

        //Stream.collect() with Collectors.joining()
        joiningExample();

        //Stream.collect() with Collectors.averageInt()
        averagingIntExample();

        //Stream.collect() with Collectors.counting()
        countingExample();

        //Stream.collect() with Collectors.toList()
        toListExample();

        //Stream.collect() with Collectors.toMap()
        toMapExample();
    }

    private static void toMapExample() {
        List<Person1> list = new ArrayList<>();
        list.add(new Person1(100, "Mohan"));
        list.add(new Person1(200, "Sohan"));
        list.add(new Person1(300, "Mahesh"));

        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person1::getId, Person1::getName));
        map.forEach((x, y) -> System.out.println("Key:" + x + ", Value:" + y));

    }

    private static void toListExample() {
        String[] strArray = {"AA", "BB", "CC"};
        List<String> list = Arrays.stream(strArray).collect(Collectors.toList());
        list.forEach(s -> System.out.println(s));
    }

    private static void countingExample() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        long result = list.stream().collect(Collectors.counting());
        System.out.println("Count:" + result);
    }

    private static void averagingIntExample() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Double result = list.stream().collect(Collectors.averagingInt(v -> v * 2));
        System.out.println("Average:" + result);
    }

    private static void joiningExample() {
        List<String> list = Arrays.asList("Ram", "Shyam", "Shiv", "Mahesh");
        String result = list.stream().collect(Collectors.joining(", "));
        System.out.println("Joining result:" + result);
    }

    private static void sumOfListDemo() {
        //Stream.collect() also accepts single argument
        //collect(Collector collector)

        //It is useful to perform many operations like summation, grouping, joining etc.

        List<Integer> list = Arrays.asList(23, 43, 12, 25);
        IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(i -> i + i));
        System.out.println("Sum:" + stats.getSum());
    }

    private static void streamCollect() {
        //collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)

        //supplier- creates a new result container which will be populated by accumulator and combiner and finally will
        // be returned by collect() method. In parallel processing the Supplier function will be called multiple times that
        // will return fresh value each time.

        //accumulator - It incorporates additional element into the result

        //combiner - It combines two values that must be compatible with accumulator. Combiner works in parallel processing.

        List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar");
        String result = list.parallelStream().collect(StringBuilder::new,
                (response, element) -> response.append(" ").append(element),
                (response1, response2) -> response1.append(",").append(response2.toString()))
                .toString();
        System.out.println("Result: " + result);
    }


}

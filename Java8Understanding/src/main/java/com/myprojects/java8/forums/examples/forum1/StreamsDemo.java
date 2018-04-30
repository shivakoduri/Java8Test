package com.myprojects.java8.forums.examples.forum1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String... args) {

        //matchElement
        matchElement();

        //stream Collect
        streamCollect();

        //stream concat
        streamConcat();

        //stream count
        streamCount();

        //stream distinct
        streamDistinct();

        //stream filter
        streamFilter();

        //stream findAny and findFirst
        streamFindAnyFindFirst();

        //stream forEach
        streamForEach();

        //stream generate and limit
        streamGenerate();

        //stream flatMap
        streamFlatMap();

        //stream iterate
        streamIterate();

        //stream map
        streamMap();

        //stream max and min
        streamMaxAndMin();

        //stream peek
        streamPeek();

        //stream reduce
        streamReduce();

        //stream skip
        streamSkip();

        //stream sorted
        streamSorted();

        //stream toArray
        streamToArray();

    }

    private static void streamToArray() {
        //returns an array containing the elements of stream
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Object[] array = list.stream().toArray();
        System.out.println("Length of array:" + array.length);
    }

    private static void streamSorted() {
        //returns a stream sorted with given Comparator
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "BBBB");
        map.put(2, "AAAA");
        map.put(3, "CCCC");

        System.out.println("--Sort by map value--");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(e -> System.out.println("Key:" + e.getKey() + ",value:" + e.getValue()));
    }

    private static void streamSkip() {
        //returns a stream skipping the given number of elements
        int[] array = {3, 5, 10, 15};
        Arrays.stream(array).skip(2).forEach(s -> System.out.println(s + " "));

    }

    private static void streamReduce() {
        //performs reduction on stream elements using a start value and accumulation function.
        int[] array = {3, 5, 10, 15};
        int sum = Arrays.stream(array).reduce(0, (x, y) -> x + y);
        System.out.println("Sum:" + sum);
    }

    private static void streamPeek() {
        //is an intermediate operation, returns a new stream
        // which consists all the elements of stream after applying the Consumer
        List<String> list = Arrays.asList("A", "B", "C");
        list.stream().peek(s -> System.out.println());
    }

    private static void streamMaxAndMin() {
        //max() finds maximum element for the given Comparator
        //min() finds minimum element for the given Comparator
        List<String> list = Arrays.asList("G", "B", "F", "E");
        String max = list.stream().max(Comparator.comparing(String::valueOf)).get();
        System.out.println("Max:" + max);
        String min = list.stream().min(Comparator.comparing(String::valueOf)).get();
        System.out.println("Min:" + min);
    }

    private static void streamMap() {
        //returns a stream after applying given function to each element of the stream
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().map(i -> i * i).forEach(s -> System.out.println(s + " "));

        //mapToInt(): It returns IntStream after applying the given function.
        //mapToLong(): It returns LongStream after applying the given function.
        //mapToDouble(): It returns DoubleStream after applying the given function.
    }

    private static void streamIterate() {
        //pass seed value and UnaryOperator to the method and will return an infinite sequential unordered stream
        Stream<Integer> stream = Stream.iterate(1, n -> n * 2).limit(5);
        stream.forEach(s -> System.out.println(s + " "));
    }

    private static void streamFlatMap() {
        //returns a stream of object after applying mapping function on each element and then flattens the result.
        Integer[][] data = {{1, 2}, {3, 4}, {5, 6}};
        Arrays.stream(data).flatMap(row -> Arrays.stream(row)).filter(num -> num % 2 == 1)
                .forEach(s -> System.out.println(s + " "));

        //flatMapToInt(): It is used with primitive data type int and returns IntStream.
        //flatMapToLong(): It is used with primitive data type long and returns LongStream.
        //flatMapToDouble(): It is used with primitive data type double and returns DoubleStream .
    }

    private static void streamGenerate() {
        //generate()  - pass Supplier to this method and it will return an infinite sequential unordered stream.
        //limit()  - pass a max value and it returns the stream up to the max number of elements
        String str = "Hello World!";
        Stream<String> stream = Stream.generate(str::toString).limit(5);
        stream.forEach(s -> System.out.println(s));
    }

    private static void streamForEach() {
        Integer[] data = {1, 2, 4, 3, 7, 5, 6};
        System.out.println("--forEach Demo--");
        Arrays.stream(data).filter(num -> num % 2 == 1).forEach(s -> System.out.println(s + " "));
        System.out.println("\n--forEachOrdered Demo--");
        Arrays.stream(data).filter(num -> num % 2 == 1).forEachOrdered(s -> System.out.println(s + " "));
    }

    private static void streamFindAnyFindFirst() {
        List<String> list = Arrays.asList("G", "B", "F", "E");
        String any = list.stream().findAny().get();
        System.out.println("FindAny:" + any);
        String first = list.stream().findFirst().get();
        System.out.println("FindFirst:" + first);
    }

    private static void streamFilter() {
        //Stream.filter returns the stream with the elements that matches the Predicate
        Predicate<Integer> p = num -> num % 2 == 0;
        List<Integer> list = Arrays.asList(3, 4, 6);
        list.stream().filter(p).forEach(e -> System.out.println(e + ""));
    }


    private static void streamDistinct() {
        List<Integer> list = Arrays.asList(3, 4, 6, 6, 4);
        System.out.println("Distinct Count:" + list.stream().distinct().count());
    }

    private static void streamCount() {
        //Stream.count() returns the number of elements in stream
        Predicate<Integer> p = num -> num % 2 == 0;
        List<Integer> list = Arrays.asList(3, 4, 6);
        System.out.println("Count:" + list.stream().filter(p).count());
    }

    private static void streamConcat() {
        //Stream.concat() creates a lazily concatenated stream including
        // all the elements of first stream and followed by next stream
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        Stream<Integer> resStream = Stream.concat(list1.stream(), list2.stream());
        resStream.forEach(s -> System.out.println(s + " "));
    }

    private static void matchElement() {
        Predicate<Integer> p = num -> num % 2 == 0;
        List<Integer> list = Arrays.asList(3, 5, 6);

        System.out.println("allMatch:" + list.stream().allMatch(p));
        System.out.println("anyMatch:" + list.stream().anyMatch(p));
        System.out.println("noneMatch:" + list.stream().noneMatch(p));
    }

    private static void streamCollect() {
        //Stream.collect() performs mutable reduction operation.
        List<Integer> list = Arrays.asList(3, 5, 6);
        int sum = list.stream().collect(Collectors.summingInt(i -> i));
        System.out.println("Sum:" + sum);
    }
}

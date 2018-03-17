package com.myprojects.java8.forums.examples.forum1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String... args){

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

    }

    private static void streamFindAnyFindFirst(){
        List<String> list = Arrays.asList("G", "G", "G");
    }

    private static void streamFilter(){
        //Stream.filter returns the stream with the elements that matches the Predicate
        Predicate<Integer> p = num -> num % 2 ==0;
        List<Integer> list = Arrays.asList(3, 4, 6);
        list.stream().filter(p).forEach(e -> System.out.println(e + ""));
    }


    private static void streamDistinct(){
        List<Integer> list = Arrays.asList(3, 4, 6, 6, 4);
        System.out.println("Distinct Count:" + list.stream().distinct().count());
    }

    private static void streamCount(){
        //Stream.count() returns the number of elements in stream
        Predicate<Integer> p = num -> num % 2 ==0;
        List<Integer> list = Arrays.asList(3, 4, 6);
        System.out.println("Count:" + list.stream().filter(p).count());
    }

    private static void streamConcat(){
        //Stream.concat() creates a lazily concatenated stream including
        // all the elements of first stream and followed by next stream
        List<Integer> list1  = Arrays.asList(1, 2, 3);
        List<Integer> list2 =  Arrays.asList(4, 5, 6);

        Stream<Integer> resStream = Stream.concat(list1.stream(), list2.stream());
        resStream.forEach(s -> System.out.println(s + " "));
    }

    private static void matchElement(){
        Predicate<Integer> p = num -> num % 2 == 0;
        List<Integer> list = Arrays.asList(3, 5, 6);

        System.out.println("allMatch:" + list.stream().allMatch(p));
        System.out.println("anyMatch:" + list.stream().anyMatch(p));
        System.out.println("noneMatch:" + list.stream().noneMatch(p));
    }

    private static void streamCollect(){
        //Stream.collect() performs mutable reduction operation.
        List<Integer> list = Arrays.asList(3, 5, 6);
        int sum = list.stream().collect(Collectors.summingInt(i -> i));
        System.out.println("Sum:" + sum);
    }
}

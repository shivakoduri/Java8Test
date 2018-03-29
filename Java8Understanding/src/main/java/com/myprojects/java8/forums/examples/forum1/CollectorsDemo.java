package com.myprojects.java8.forums.examples.forum1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static  void main(String... args){

        //Collectors.averagingDouble
        averagingDouble();

        //Collectors.averagingInt
        averagingInt();

        //Collectors.averagingLong
        averagingLong();

        //Collectors.collectingAndThen
        collectingAndThen();

        //Collectors.counting
        counting();

        //Collectors.joining
        joining();

        //Collectors.maxBy and Collectors.minBy
        maxByMinBy();

    }

    private  static void maxByMinBy(){
        List<Integer> list = Arrays.asList(30,10,20,35);
    }

    private static void joining(){
        List<String> list = Arrays.asList("A", "B", "C", "D");
        String result = list.stream().collect(Collectors.joining(",","(",")"));
        System.out.println(result);
    }

    private  static void counting(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        long result = list.stream().collect(Collectors.counting());
        System.out.println(result);
    }

    private static void collectingAndThen(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v->v*2), s->s*s));
        System.out.println(result);
    }

    private static void averagingLong(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double result = list.stream().collect(Collectors.averagingLong(v->v*2));
        System.out.println(result);
    }

    private static void averagingInt(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double result = list.stream().collect(Collectors.averagingInt(v->v*2));
        System.out.println(result);
    }

    private  static void averagingDouble(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double result = list.stream().collect(Collectors.averagingDouble(d->d*2));
        System.out.println(result);
    }
}

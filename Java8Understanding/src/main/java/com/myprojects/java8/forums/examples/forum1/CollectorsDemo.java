package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.comparator.IntegerComparator;
import com.myprojects.java8.forums.examples.model.Person3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        //Collectors.summingInt
        summingInt();

        //Collectors.summingLong
        summingLong();

        //Collectors.summingDouble
        summingDouble();

        //Collectors.toList
        toListExample();

        //Collectors.toSet
        toSetExample();

        //Collectors.toMap
        toMapExample();

        //Collectors.mapping
        mappingDemo();
    }

    private static void mappingDemo(){
        List<Person3> list = Person3.getList();
        Map<Integer, String> nameByAge = list
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Person3::getAge,
                                Collectors.mapping(
                                        Person3::getName,
                                        Collectors.joining(","))));
        nameByAge.forEach((k,v)-> System.out.println("Age:"+k+", Persons:"+v));
    }

    private static void toMapExample(){
        Map<String, String> map = Stream.of("AA", "BB", "CC").collect(Collectors.toMap(k->k, v->v));
        map.forEach((k,v)-> System.out.println("key:"+k+", value:"+v));
    }

    private static void toSetExample(){
        Set<String> set = Stream.of("AA", "AA", "BB").collect(Collectors.toSet());
        set.forEach(s-> System.out.println(s));
    }

    private static void toListExample(){
        List<String> list = Stream.of("AA", "BB", "CC").collect(Collectors.toList());
        list.forEach(s-> System.out.println(s));
    }

    private static void summingDouble(){
        List<Double> list =Arrays.asList(340.5, 234.56, 672.76);
        Double result = list.stream().collect(Collectors.summingDouble(d->d));
        System.out.println(result);
    }

    private static void summingLong(){
        List<Long> list = new ArrayList<>();
        list.add((long)340);
        list.add((long)240);
        list.add((long)360);
        long result = list.stream().collect(Collectors.summingLong(l->l));
        System.out.println(result);
    }

    private static void summingInt(){
        List<Integer> list = Arrays.asList(30,10,20,35);
        int result = list.stream().collect(Collectors.summingInt(i->i));
        System.out.println(result);
    }

    private  static void maxByMinBy(){
        List<Integer> list = Arrays.asList(30,10,20,35);
        //Get Max
        list.stream().collect(Collectors.maxBy(new IntegerComparator())).ifPresent(i -> System.out.println(i));

        //Get Min
        list.stream().collect(Collectors.minBy(new IntegerComparator())).ifPresent(i-> System.out.println(i));

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

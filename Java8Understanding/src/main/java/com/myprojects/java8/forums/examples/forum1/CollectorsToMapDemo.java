package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Person1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsToMapDemo {

    public static void main(String... args){

        //List to Map with Key Mapper and Value Mapper
        listToMap1();

        //List of user class Person. Convert the List to Map.
        listToMap2();

        //List to Map with Key Mapper, Value Mapper and Merge Function
        listToMapWithBinaryOperator();

        //List to Map with Key Mapper, Value Mapper, Merge Function and Map Supplier
        listToMapWithSupplier();

    }

    private static void listToMapWithSupplier(){
        // pass map with supplier in the toMap() method.
        // if want to return LinkedHashMap, need to pass supplier as LinkedHashMap::new

        // toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapSupplier)
        LinkedHashMap<Integer, String> map = getPersonListData().stream().collect(Collectors.toMap(Person1::getId, Person1::getName, (x,y) ->x+", "+y, LinkedHashMap::new));
        map.forEach((x,y) -> System.out.println("Key:"+x+", Value:"+y));

    }

    private static void listToMapWithBinaryOperator(){
        //pass BinaryOperator as merge function. When the toMap() method finds duplicate keys then the values are merged and does not throw exception.

        Map<Integer, String> map = getPersonListData().stream().collect(Collectors.toMap(Person1::getId, Person1::getName, (x,y) -> x+", "+y));
        map.forEach((x,y) -> System.out.println("Key:" + x + ", Value:" + y));
    }

    private static void listToMap2(){

        Map<Integer, String> map = getPersonListData().stream().collect(Collectors.toMap(Person1::getId, Person1::getName));
        map.forEach((x,y) -> System.out.println("Key:" + x +", Value:" + y));

        //if keys will be duplicate then, will throw IllegalStateException. To Solve it, pass merge function as BinaryOperator
    }

    private static void listToMap1(){
        // pass mapping function of key mapper and value mapper.
        // toMap(Function keyMapper, Function valueMapper)

        Map<String, Object> map = getStringListData().stream().collect(Collectors.toMap(Function.identity(), s->s));
        map.forEach((x,y) -> System.out.println());
    }

    private static List<Person1> getPersonListData(){
        List<Person1> list = new ArrayList<>();
        list.add(new Person1(100, "Mohan"));
        list.add(new Person1(200, "Sohan"));
        list.add(new Person1(300, "Mahesh"));

        return list;
    }

    private static List<String> getStringListData(){
        List<String> list = new ArrayList<>();
        list.add("Mohan");
        list.add("Sohan");
        list.add("Mahesh");

        return list;
    }
}

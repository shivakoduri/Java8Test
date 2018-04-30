package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Person;
import com.myprojects.java8.forums.examples.model.Person2;
import com.myprojects.java8.forums.examples.util.Utility;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BigDecimalSumDemo {

    public static void main(String... args) {

        //BigDecimal Sum with Lambda Expression
        bigDecimalSumUsingList();

        //BigDecimal Sum Using Array
        bigDecimalSumUsingArray();

        //BigDecimal Sum Using Map
        bigDecimalSumUsingMap();
    }

    private static void bigDecimalSumUsingMap() {
        Map<Integer, BigDecimal> map = new HashMap<>();
        map.put(1, new BigDecimal("45.23"));
        map.put(2, new BigDecimal("55.43"));
        map.put(3, new BigDecimal("65.21"));
        map.put(4, new BigDecimal("35.73"));

        BigDecimal sum = map.values().stream().reduce(BigDecimal.ZERO, (p, q) -> p.add(q));
        System.out.println("Sum:" + sum);

        sum = map.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sum:" + sum);

        sum = map.values().stream().reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println("Sum:" + sum);

    }

    private static void bigDecimalSumUsingArray() {
        BigDecimal b1 = new BigDecimal("45.23");
        BigDecimal b2 = new BigDecimal("55.43");
        BigDecimal b3 = new BigDecimal("65.21");
        BigDecimal b4 = new BigDecimal("35.73");

        BigDecimal[] bdArray = {b1, b2, b3, b4};

        BigDecimal sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, (p, q) -> p.add(q));
        System.out.println("Sum:" + sum);

        sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sum:" + sum);

        sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println("Sum:" + sum);

    }

    private static void bigDecimalSumUsingList() {

        Person2 p1 = new Person2("AAA", new BigDecimal("45.23"));
        Person2 p2 = new Person2("BBB", new BigDecimal("55.43"));
        Person2 p3 = new Person2("CCC", new BigDecimal("65.21"));
        Person2 p4 = new Person2("DDD", new BigDecimal("35.73"));

        List<Person2> list = Arrays.asList(p1, p2, p3, p4);
        BigDecimal sum = list.stream().map(Person2::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sum:" + sum);

        sum = list.stream().map(p -> p.getWeight()).reduce(BigDecimal.ZERO, (b1, b2) -> b1.add(b2));
        System.out.println("Sum:" + sum);

        sum = list.stream().map(Person2::getWeight).reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println("Sum:" + sum);
    }
}

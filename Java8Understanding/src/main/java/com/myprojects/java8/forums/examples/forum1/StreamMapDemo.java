package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMapDemo {

    public static void main(String... args) {

        //Convert Map to List using Stream map()
        mapToList();

        //Convert List to another List using Stream map()
        listToAnotherList();

        //stream mapToInt()
        mapToIntDemo();
    }

    private static void mapToIntDemo() {
        Employee e1 = new Employee(1, 20);
        Employee e2 = new Employee(2, 15);
        Employee e3 = new Employee(3, 30);

        List<Employee> list = Arrays.asList(e1, e2, e3);
        int sum = list.stream().mapToInt(e -> e.getAge()).sum();
        System.out.println("Sum:" + sum);
    }

    private static void listToAnotherList() {
        //convert a List of an object into another List of different object using Stream.map() as an intermediate operation
        Person p1 = new Person(1, "Mohan", "student");
        Person p2 = new Person(2, "Sohan", "teacher");
        Person p3 = new Person(3, "Dinesh", "student");

        List<Person> personList = Arrays.asList(p1, p2, p3);

        List<AnotherPerson> stdList = personList.stream()
                .filter(p -> p.getPersonType().equals("student"))
                .map(p -> new AnotherPerson(p.getId(), p.getName()))
                .collect(Collectors.toList());

        stdList.forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getName()));

    }

    private static void mapToList() {
        Map<Integer, String> map = new HashMap<>();
        map.put(111, "LalKrishna");
        map.put(154, "Atal");
        map.put(30, "Narendra");
        map.put(200, "Amit");

        List<User> list = map.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getKey()))
                .map(e -> new User(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        list.forEach(l -> System.out.println("Name:" + l.getName() + ", Id:" + l.getId()));
    }


}

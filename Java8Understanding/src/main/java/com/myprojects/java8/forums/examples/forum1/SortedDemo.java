package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Student;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

public class SortedDemo {

    public static void main(String... args) {

        //sortList
        sortList();

        //sortSet
        sortSet();

        //sortMap
        sortMap();

        //sortCustomObject
        sortMapOfCustomObject();

    }

    private static void sortMapOfCustomObject() {
        //sorting a map whose values are custom objects

        Map<Integer, Student> map = new HashMap<>();
        map.put(1, new Student(1, "Mahesh", 12));
        map.put(2, new Student(2, "Suresh", 15));
        map.put(3, new Student(3, "Nilesh", 10));

        //Map sorting by value i.e student's natural ordering i.e by name
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(e -> {
                    Integer key = (Integer) e.getKey();
                    Student student = (Student) e.getValue();
                    System.out.println("Key:" + key + ", Value: (" + student.getId() + ", " + student.getName() + ", " + student.getAge() + ")");
                });
    }

    private static void sortMap() {
        // sorting a Map by key as well as value
        Map<Integer, String> map = new HashMap<>();
        map.put(15, "Mahesh");
        map.put(10, "Suresh");
        map.put(30, "Nilesh");

        System.out.println("--Sort by  Map Value --");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(e -> System.out.println("Key:" + e.getKey() + ", Value:" + e.getValue()));

        System.out.println("--Sort by Map Key --");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e -> System.out.println("Key:" + e.getKey() + ", Value:" + e.getValue()));
    }

    private static void sortSet() {
        // Natural ordering Student class needs to implement Comparable interface.
        // In the example will sort our Set using natural ordering as well as ordering provided by Comparator.
        Set<Student> set = new HashSet<>();
        set.add(new Student(1, "Mahesh", 12));
        set.add(new Student(2, "Suresh", 15));
        set.add(new Student(3, "Nilesh", 10));

        System.out.println("--Natural Sorting by Name --");
        set.stream().sorted().forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getName() + ", Age:" + e.getAge()));

        System.out.println("-- Natural Sorting by Name in reverse order --");
        set.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getName() + ", Age:" + e.getAge()));

        System.out.println("-- Sorting using Comparator by Age --");
        set.stream().sorted(Comparator.comparing(Student::getAge)).forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getName() + ", Age:" + e.getAge()));

        System.out.println("-- Sorting using Comparator by Age in reverse order --");
        set.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getName() + ", Aage:" + e.getAge()));
    }


    private static void sortList() {
        // sorting a List of objects of Student class.
        // First sort by natural ordering and then using Comparator.
        // Reverse both ordering natural ordering as well as ordering provided by Comparator in the example.

        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Mahesh", 12));
        list.add(new Student(2, "Suresh", 15));
        list.add(new Student(3, "Nilesh", 10));

        System.out.println("--Natural Sorting by Name --");
        List<Student> slist = list.stream().sorted().collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getName() + ", Age:" + e.getAge()));

        System.out.println("--Natural Sorting by Name in reverse order");
        slist = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getName() + ", Age:" + e.getAge()));

        System.out.println("--Sorting using Comparator by Age--");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getAge() + ", Age:" + e.getAge()));

        System.out.println("--Sorting using comparator by Age with reverse order ---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name:" + e.getName() + ", Age:" + e.getAge()));
    }
}

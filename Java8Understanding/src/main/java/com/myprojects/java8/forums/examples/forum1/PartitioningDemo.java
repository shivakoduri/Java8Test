package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningDemo {

    public static void main(String... args) {

        //collectors partitioningBy
        collectorsPartioningBy();
    }

    private static void collectorsPartioningBy() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Ram", 18));
        list.add(new Student(2, "Shyam", 22));
        list.add(new Student(3, "Mohan", 19));
        list.add(new Student(3, "Mahesh", 20));
        list.add(new Student(3, "Krishna", 21));

        //partition of Student on the basis of age
        System.out.println("--Partition of Student on the basis of age>20");
        Map<Boolean, List<Student>> stdByClass = list.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 20));
        stdByClass
                .forEach((k, v) -> System.out.println("Key:" + k + " " + ((List<Student>) v).stream().map(s -> s.getName()).collect(Collectors.joining(","))));


    }
}

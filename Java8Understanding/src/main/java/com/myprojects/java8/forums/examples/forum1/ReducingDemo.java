package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.ReduceDemoStudent;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ReducingDemo {

    public static void main(String... args) {

        ReduceDemoStudent s1 = new ReduceDemoStudent("Shyam", 22, "A");
        ReduceDemoStudent s2 = new ReduceDemoStudent("Ram", 23, "A");
        ReduceDemoStudent s3 = new ReduceDemoStudent("Mohan", 22, "B");
        ReduceDemoStudent s4 = new ReduceDemoStudent(null, 21, "B");
        List<ReduceDemoStudent> list = Arrays.asList(s1, s2, s3, s4);

        Comparator<ReduceDemoStudent> ageComparator = Comparator.comparing(ReduceDemoStudent::getAge);
        Map<String, Optional<ReduceDemoStudent>> eldestByClass = list
                .stream()
                .collect(Collectors.groupingBy(ReduceDemoStudent::getClassName,
                        Collectors.reducing(BinaryOperator.maxBy(ageComparator))));

        eldestByClass
                .forEach(
                        (k, v) ->
                                System.out.println(
                                        "Class:" + k + ", " +
                                                "Age:" + ((Optional<ReduceDemoStudent>) v).get().getAge() + "," +
                                                "Name:" + ((Optional<ReduceDemoStudent>) v).get().getName()));
    }
}

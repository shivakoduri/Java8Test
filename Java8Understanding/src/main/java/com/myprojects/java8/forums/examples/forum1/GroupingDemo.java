package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.GroupingDemoStudent;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingDemo {

    public static void main(String... args) {

        //Collectors GroupingBy
        collectorsGroupingBy();

    }

    private static void collectorsGroupingBy() {
        GroupingDemoStudent s1 = new GroupingDemoStudent("Ram", 20, "A");
        GroupingDemoStudent s2 = new GroupingDemoStudent("Shyam", 22, "B");
        GroupingDemoStudent s3 = new GroupingDemoStudent("Mohan", 22, "A");
        GroupingDemoStudent s4 = new GroupingDemoStudent("Mahesh", 20, "C");
        GroupingDemoStudent s5 = new GroupingDemoStudent("Krishna", 21, "B");

        List<GroupingDemoStudent> list = Arrays.asList(s1, s2, s3, s4, s5);

        //Group Students on the basis of Classname
        Map<String, List<GroupingDemoStudent>> stdByClass = list.stream().collect(Collectors.groupingBy(GroupingDemoStudent::getClassName));
        stdByClass
                .forEach(
                        (k, v) -> System.out.println("Key:" + k + " " + ((List<GroupingDemoStudent>) v)
                                .stream()
                                .map(m -> m.getName())
                                .collect(Collectors.joining(","))));

        //Group Students on the basis of age
        Map<Integer, List<GroupingDemoStudent>> stdByAge = list.stream().collect(Collectors.groupingBy(GroupingDemoStudent::getAge));
        stdByAge.forEach(
                (k, v) -> System.out.println("Key:" + k + " " + ((List<GroupingDemoStudent>) v)
                        .stream()
                        .map(m -> m.getName())
                        .collect(Collectors.joining(",")))
        );


    }
}

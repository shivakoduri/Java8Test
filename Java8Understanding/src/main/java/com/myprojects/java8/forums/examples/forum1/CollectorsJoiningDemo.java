package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Person3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsJoiningDemo {

    public static void main(String... args) {

        //Collectors.joining() with List of String
        joiningExampleWithListOfString();

        //Collectors.joining with List of Objects
        joiningExampleWithListOfObject();
    }

    private static void joiningExampleWithListOfString() {
        List<String> list = Arrays.asList("Ram", "Shyam", "Shiv", "Mahesh");
        String result = list.stream().collect(Collectors.joining());
        System.out.println(result);

        result = list.stream().collect(Collectors.joining(","));
        System.out.println(result);

        result = list.stream().collect(Collectors.joining("-", "[", "]"));
        System.out.println(result);
    }

    private static void joiningExampleWithListOfObject() {
        List<Person3> list = Person3.getList();
        System.out.println("--Join Person name--");
        String result = list.stream().map(p -> p.getName()).collect(Collectors.joining());
        System.out.println(result);

        result = list.stream().map(p -> p.getName()).collect(Collectors.joining("|"));
        System.out.println(result);

        result = list.stream().map(p -> p.getName()).collect(Collectors.joining("-", "[", "]"));
        System.out.println(result);


        System.out.println("--Join Peson age--");
        result = list.stream().map(p -> String.valueOf(p.getAge())).collect(Collectors.joining());
        System.out.println(result);

        result = list.stream().map(p -> String.valueOf(p.getAge())).collect(Collectors.joining("|"));
        System.out.println(result);

        result = list.stream().map(p -> String.valueOf(p.getAge())).collect(Collectors.joining("-", "[", "]"));
        System.out.println(result);

        System.out.println("--Join person name-age--");
        result = list.stream().map(p -> p.getName() + "-" + p.getAge()).collect(Collectors.joining("|"));
        System.out.println(result);

        result = list.stream().map(p -> p.getName() + "-" + p.getAge()).collect(Collectors.joining("|", "[", "]"));
        System.out.println(result);

    }
}

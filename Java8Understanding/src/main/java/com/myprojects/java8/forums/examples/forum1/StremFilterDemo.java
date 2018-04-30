package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.User;
import com.myprojects.java8.forums.examples.model.User1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StremFilterDemo {

    public static void main(String... args) {

        //Stream filter() with findFirst(), orElse() and forEach()
        filterFindFirstAndForEach();

        //Stream filster() with mapToInt() and sum()
        filterMapToIntAndSum();

        //Stream filter() with collect()
        filterAndCollect();

        //Stream filter() with reduce()
        filterAndReduce();

        //Stream filter() with list
        filterListOfInteger();

    }

    private static void filterListOfInteger() {
        //filter the list into even and odd number of lists
        List<Integer> list = Arrays.asList(3, 12, 23, 44, 20, 10, 17, 8);
        System.out.println("--List with even Numbers --");
        List<Integer> evenList = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        evenList.forEach(s -> System.out.println(s + " "));

        System.out.println("\n --List with odd Numbers--");
        List<Integer> oddList = list.stream().filter(i -> i % 2 == 1).collect(Collectors.toList());
        oddList.forEach(s -> System.out.println(s + " "));

    }

    private static void filterAndReduce() {
        //calculate the sum of age of users whose name are matching to a given string
        List<User1> list = User1.getUsers();
        list.stream().filter(u -> u.getName().endsWith("sh")).mapToInt(u -> u.getAge()).reduce((a, b) -> a + b).ifPresent(s -> System.out.println("Sum of ages:" + s));
    }

    private static void filterAndCollect() {
        //filtering a list and counting the number of elements
        List<User1> list = User1.getUsers();
        long count = list.stream().filter(u -> u.getName().endsWith("sh")).collect(Collectors.counting());
        System.out.println("Number of users ending with name with 'sh' :" + count);
    }

    private static void filterMapToIntAndSum() {
        //filter list for a range of given user id and calculate the sum of age of the users
        List<User1> list = User1.getUsers();

        System.out.println("--Sum of age between the user id 2 and 4--");
        int sum = list.stream().filter(u -> u.getId() >= 2 && u.getId() <= 4).mapToInt(u -> u.getAge()).sum();
        System.out.println("Sum:" + sum);
    }


    private static void filterFindFirstAndForEach() {
        // filter a list of User objects on the basis of some string and will
        // find the first element in the list.If did not get any data will return null.

        List<User1> list = User1.getUsers();
        System.out.println("-- Using findFirst() --");
        User1 user = list.stream().filter(u -> u.getName().endsWith("sh")).findFirst().orElse(null);

        System.out.println(user.getName());
        System.out.println("Using forEach() ---");
        list.stream().filter(u -> u.getName().endsWith("sh")).forEach(u -> System.out.println(u.getName()));
    }
}

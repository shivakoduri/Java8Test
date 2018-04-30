package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.User3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public class ParallelSortDemo {

    public static void main(String... args) {

        //Arrays.parallelSort with Comparable
        parallelSortWithComparable();

        //Arrays.parallelSort with Comparator
        parallelSortWithComparator();

        //Arrays.parallelSort with Primitive Data Type
        parallelSortWithPrimitiveDataType();
    }

    private static void parallelSortWithPrimitiveDataType() {
        int[] num1 = {3, 6, 2, 10, 4, 1, 7};
        System.out.println("--Sort complete Integer array--");

        Arrays.parallelSort(num1);
        IntConsumer printInt = i -> System.out.println(i + " ");
        Arrays.stream(num1).forEach(printInt);

        System.out.println("\n--Sort Integer array from index 1 to 5--");
        int[] num2 = {3, 6, 2, 10, 4, 1, 7};
        Arrays.parallelSort(num2, 1, 5);
        Arrays.stream(num2).forEach(printInt);

        double[] db1 = {3.5, 1.2, 6.7, 8.9, 2.3, 5.5};
        System.out.println("\n--Sort complete double array--");
        Arrays.parallelSort(db1);
        DoubleConsumer printDB = d -> System.out.println(d + " ");
        Arrays.stream(db1).forEach(printDB);

        System.out.println("\n--Sort Double array from index 1 to 5--");
        double[] db2 = {3.5, 1.2, 6.7, 8.9, 0.6, 2.3, 5.5};
        Arrays.parallelSort(db2, 1, 5);
        Arrays.stream(db2).forEach(printDB);

    }

    private static void parallelSortWithComparator() {
        User3[] users = User3.getUsers();
        Comparator<User3> ageComparator = Comparator.comparing(User3::getAge);

        System.out.println("Sort complete array--");
        Arrays.parallelSort(users, ageComparator);
        Consumer<User3> printUser = u -> System.out.println(u.getName() + "-" + u.getAge());
        Arrays.stream(users).forEach(printUser);

        System.out.println("Sort array from index 1 to 4");
        users = User3.getUsers();
        Arrays.parallelSort(users, 1, 4, ageComparator);
        Arrays.stream(users).forEach(printUser);
    }

    private static void parallelSortWithComparable() {
        User3[] users = User3.getUsers();
        System.out.println("--Sort complete array--");
        Arrays.parallelSort(users);

        Consumer<User3> printUser = u -> System.out.println(u.getName() + "-" + u.getAge());
        Arrays.stream(users).forEach(printUser);

        System.out.println("--Sort array from index 1 to 4");
        users = User3.getUsers();
        Arrays.parallelSort(users, 1, 4);
        Arrays.stream(users).forEach(printUser);
    }


}

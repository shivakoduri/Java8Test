package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.ComparatorDemoStudent;
import com.myprojects.java8.forums.examples.model.Student;

import java.util.*;

public class ComparatorDemo {

    public static void main(String... args) {

        //Comparator.comparing and Comparator.reversed
        comparatorComparing();

        //Comparator.thenComparing
        thenComparing();

        //Comparator.naturalOrder and Comparator.reverseOrder
        comparatorNaturalOrder();
    }

    private static void comparatorNaturalOrder() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Mahesh", 12));
        list.add(new Student(2, "Suresh", 15));
        list.add(new Student(3, "Nilesh", 10));

        Collections.sort(list, Comparator.naturalOrder());
        list.forEach(s -> System.out.println("Name:" + s.getName() + ", Age:" + s.getAge()));

        //Using natural reversed order for sorting
        System.out.println("--Using natural order for sorting--");
        Collections.sort(list, Comparator.reverseOrder());
        list.forEach(s -> System.out.println("Name:" + s.getName() + ", Age:" + s.getAge()));
    }


    private static void thenComparing() {
        ComparatorDemoStudent s1 = new ComparatorDemoStudent("Shyam", 22);
        ComparatorDemoStudent s2 = new ComparatorDemoStudent("Ram", 22);
        ComparatorDemoStudent s3 = new ComparatorDemoStudent("Mohan", 19);

        List<ComparatorDemoStudent> list = Arrays.asList(s1, s2, s3);
        Comparator<ComparatorDemoStudent> ageComparator = Comparator.comparing(ComparatorDemoStudent::getAge);
        Comparator<ComparatorDemoStudent> nameComparator = Comparator.comparing(ComparatorDemoStudent::getName);

        Collections.sort(list, ageComparator.thenComparing(nameComparator));
        list.forEach(s -> System.out.println("Name:" + s.getName() + ", Age:" + s.getAge()));
    }

    private static void comparatorComparing() {
        //Comparator.comparing creates a Comparator for the given lambda expression as Function.
        // To reverse the Comparator we can use Comparator.reversed.

        List<ComparatorDemoStudent> list = ComparatorDemoStudent.getStudentList();
        Comparator<ComparatorDemoStudent> ageComparator = Comparator.comparing(ComparatorDemoStudent::getAge);
        Collections.sort(list, ageComparator);
        list.forEach(s -> System.out.println("Name:" + s.getName() + ", Age:" + s.getAge()));

        //Using reversed order for sorting
        System.out.println("--Using reversed order for sorting--");
        Collections.sort(list, ageComparator.reversed());
        list.forEach(s -> System.out.println("Name:" + s.getName() + ", Age:" + s.getAge()));
    }
}

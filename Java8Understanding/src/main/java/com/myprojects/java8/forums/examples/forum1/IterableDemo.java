package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.comparator.PersonComparatorByName;
import com.myprojects.java8.forums.examples.model.AnotherPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class IterableDemo {

    public static void main(String... args) {

        //forEach
        forEachDemo();

        //removeIf
        removeIfDemo();

        //replaceAll
        replaceAll();

        //sort
        sortDemo();

    }

    private static void sortDemo() {
        List<AnotherPerson> list = new ArrayList<>();
        list.add(new AnotherPerson(1, "Mahesh"));
        list.add(new AnotherPerson(2, "Ram"));
        list.add(new AnotherPerson(3, "Krishna"));

        Consumer<AnotherPerson> style = (AnotherPerson p) -> System.out.println("id:" + p.getId() + ", Name:" + p.getName());
        System.out.println("--Before Sorting --");

        list.forEach(style);

        list.sort(new PersonComparatorByName());
        System.out.println("--After Sorting--");
        list.forEach(style);


    }

    private static void replaceAll() {
        List<AnotherPerson> list = new ArrayList<>();
        list.add(new AnotherPerson(1, "Mahesh"));
        list.add(new AnotherPerson(2, "Ram"));
        list.add(new AnotherPerson(3, "Krishna"));

        Consumer<AnotherPerson> style = (AnotherPerson p) -> System.out.println("id:" + p.getId() + ", Name:" + p.getName());
        System.out.println("--Before replaceAll--");

        list.forEach(style);

        UnaryOperator<AnotherPerson> unaryOpt = pn -> modifyName(pn);
        list.replaceAll(unaryOpt);

        System.out.println("--After replaceAll--");
        list.forEach(style);

    }

    private static AnotherPerson modifyName(AnotherPerson p) {
        p.setName(p.getName().concat(" -God"));

        return p;
    }

    private static void removeIfDemo() {
        List<AnotherPerson> list = new ArrayList<>();
        list.add(new AnotherPerson(1, "Mahesh"));
        list.add(new AnotherPerson(2, "Ram"));
        list.add(new AnotherPerson(3, "Krishna"));

        Consumer<AnotherPerson> style = (AnotherPerson p) -> System.out.println("id:" + p.getId() + ", Name:" + p.getName());
        System.out.println("--Before Delete--");

        list.forEach(style);

        int id = 2;
        Predicate<AnotherPerson> personPredicate = p -> p.getId() == id;
        list.removeIf(personPredicate);

        System.out.println("After Delete --");
        list.forEach(style);

    }

    private static void forEachDemo() {
        List<AnotherPerson> list = new ArrayList<>();
        list.add(new AnotherPerson(1, "Mahesh"));
        list.add(new AnotherPerson(2, "Ram"));
        list.add(new AnotherPerson(3, "Krishna"));

        Consumer<AnotherPerson> style = (AnotherPerson p) -> System.out.println("Id:" + p.getId() + ", Name:" + p.getName());
        list.forEach(style);
    }


}

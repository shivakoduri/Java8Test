package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenateStreamsDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Concat Streams
        concatenateStreams();

        //Concat Lists
        concatenateLists();

        //Concat Arrays
        concatenateArrays();

        //Concat Sets
        concatenateSets();
    }

    private static void concatenateArrays(){
        Book[] bk1 = new Book[3];
        Book[] bk2 = new Book[3];
        {
            bk1[0] = new Book("Core Java", 200);
            bk1[1] = new Book("Spring MVC", 300);
            bk1[2] = new Book("Learning Freemarker", 150);
            bk2[0] = new Book("Core Java", 200);
            bk2[1] = new Book("Spring MVC", 300);
            bk2[2] = new Book("Learning Hibernate", 400);
        }
        Book[] bks = (Book[]) Stream.concat(Stream.of(bk1), Stream.of(bk2)).toArray(b -> new Book[b]);
        for(Book b : bks) {
            System.out.println(b.getName()+", "+ b.getPrice());
        }

        //Remove duplicates using distinct()
        System.out.println("--Remove duplicates using distinct()--");
        bks = (Book[]) Stream.concat(Stream.of(bk1), Stream.of(bk2)).distinct().toArray(b -> new Book[b]);
        for(Book b : bks) {
            System.out.println(b.getName()+", "+ b.getPrice());
        }
    }

    private static void concatenateSets(){
        Set<Book> set1 = new HashSet<>();
        Set<Book> set2 = new HashSet<>();
        {
            set1.add(new Book("Core Java", 200));
            set1.add(new Book("Spring MVC", 300));
            set1.add(new Book("Learning Freemarker", 150));

            set2.add(new Book("Core Java", 200));
            set2.add(new Book("Spring MVC", 300));
            set2.add(new Book("Learning Hibernate", 400));
        }
        Set<Book> set = Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
        set.forEach(b->System.out.println(b.getName()+", "+ b.getPrice()));

    }

    private static void concatenateStreams(){
        Stream<String> s1 = Stream.of("AA", "BB", "CC");
        Stream<String> s2 = Stream.of("AA", "BB", "DD");
        Stream<String> s = Stream.concat(s1, s2);
        s.forEach(e->System.out.print(e+" "));

        //Remove duplicates using distinct()
        s1 = Stream.of("AA", "BB", "CC");
        s2 = Stream.of("AA", "BB", "DD");
        System.out.println("\nRemove duplicates using distinct()");
        s = Stream.concat(s1, s2).distinct();
        s.forEach(e->System.out.print(e+" "));
    }


    private static void concatenateLists(){
        List<Book> list1 = new ArrayList<>();
        List<Book> list2 = new ArrayList<>();
        {
            list1.add(new Book("Core Java", 200));
            list1.add(new Book("Spring MVC", 300));
            list1.add(new Book("Learning Freemarker", 150));

            list2.add(new Book("Core Java", 200));
            list2.add(new Book("Spring MVC", 300));
            list2.add(new Book("Learning Hibernate", 400));
        }
        List<Book> list = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        list.forEach(b->System.out.println(b.getName()+", "+ b.getPrice()));

        //Remove duplicates using distinct()
        System.out.println("--Remove duplicates using distinct()--");
        list = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        list.forEach(b->System.out.println(b.getName()+", "+ b.getPrice()));

    }

}

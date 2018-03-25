package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.comparator.BookComparator;
import com.myprojects.java8.forums.examples.model.Book;
import com.myprojects.java8.forums.examples.model.Writer;

import java.util.Arrays;
import java.util.List;

public class FlatMapDemo {

    public static void main(String... args){

        // FlatMap with List
        flatMapWithList();

        //Stream flatMap with List of lists
        flatMapWithListOfList();

    }

    private static void flatMapWithListOfList(){
        List<Book> list1 = Arrays.asList(new Book("AAA", 10), new Book("BBB", 20));
        List<Book> list2 = Arrays.asList(new Book("YYY", 30), new Book("ZZZ", 15));
        List<List<Book>> finalList = Arrays.asList(list1, list2);

        Book book = finalList.stream().flatMap(list -> list.stream()).min(new BookComparator()).get();
        System.out.println("Name:" + book.getName() +", Price:" + book.getPrice());

    }

    private static void flatMapWithList(){
        List<Book> books = Arrays.asList(new Book("AAA", 10), new Book("BBB", 20));
        Writer w1 = new Writer("Mohan", books);

        books = Arrays.asList(new Book("CCC", 10), new Book("DDD", 20));
        Writer w2 = new Writer("Sohan", books);

        List<Writer> writers = Arrays.asList(w1, w2);
        Book book = writers.stream().flatMap(writer -> writer.getBooks().stream()).max(new BookComparator()).get();

        System.out.println("Name:"+ book.getName() +", Price:" + book.getPrice());
    }


}

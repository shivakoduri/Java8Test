package com.myprojects.java8.forums.examples.forum1;

import java.util.StringJoiner;

public class StringJoinerDemo {

    public static void main(String... args){

        stringJoinerExampleOne();
    }

    private static void stringJoinerExampleOne(){
        StringJoiner sj = new StringJoiner("-");
        sj.add("Ram");
        System.out.println(sj);
        sj.add("Shyam").add("Mohan");
        System.out.println(sj);

    }
}

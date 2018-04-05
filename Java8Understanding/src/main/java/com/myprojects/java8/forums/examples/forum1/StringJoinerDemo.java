package com.myprojects.java8.forums.examples.forum1;

import java.util.StringJoiner;

public class StringJoinerDemo {

    public static void main(String... args){

        stringJoinerExampleOne();

        stringJoinerExampleTwo();

    }

    private static void stringJoinerExampleTwo(){
        StringJoiner sjObj = new StringJoiner(",", "{", "}");
        //Add element
        sjObj.add("AA").add("BB").add("CC").add("DD").add("E");
        String output = sjObj.toString();
        System.out.println(output);

        //Create another StringJoiner
        StringJoiner otherSj = new StringJoiner(":", "(", ")");
        otherSj.add("10").add("20").add("30");
        System.out.println(otherSj);

        //Use StringJoiner.merge(StringJoiner o)
        StringJoiner finalSj = sjObj.merge(otherSj);
        System.out.println(finalSj);

        //get length using StringJoiner.length()
        System.out.println("Length of Final String:" + finalSj.length());
    }

    private static void stringJoinerExampleOne(){
        //StringJoiner(CharSequence d)
        //This constructor uses a delimiter to separate the added element.

        //StringJoiner.add(CharSequence element)

        //StringJoiner(CharSequence d, CharSequence p, CharSequence s)

        StringJoiner sj = new StringJoiner("-");
        sj.add("Ram");
        System.out.println(sj);
        sj.add("Shyam").add("Mohan");
        System.out.println(sj);
    }
}

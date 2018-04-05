package com.myprojects.java8.forums.examples.forum1;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperatorDemo {

    public static void main(String... args){

        unaryOperatorDemo();

        binaryOperatorDemo();
    }

    private static void binaryOperatorDemo(){
        Map<String, String> map = new HashMap<>();
        map.put("X", "A");
        map.put("Y", "B");
        map.put("Z", "C");

        List<String> biList = new ArrayList<>();
        BinaryOperator<String> binaryOpt = (s1, s2)-> s1+"_"+s2;
        map.forEach((s1, s2) -> biList.add(binaryOpt.apply(s1, s2)));

        biList.forEach(x-> System.out.println(x));
    }


    private static void unaryOperatorDemo(){
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> uniList = new ArrayList<>();
        UnaryOperator<Integer> unarOpt = i->i*i;

        list.forEach(i-> uniList.add(unarOpt.apply(i)));

        uniList.forEach(x-> System.out.println(x));
    }


}

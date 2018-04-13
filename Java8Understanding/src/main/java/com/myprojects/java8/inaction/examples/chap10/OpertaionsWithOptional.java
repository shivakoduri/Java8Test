package com.myprojects.java8.inaction.examples.chap10;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class OpertaionsWithOptional {

    public static void main(String... args){

        System.out.println(max(of(3), of(5)));
        System.out.println(max(empty(), of(5)));

        Optional<Integer> opt1 = of(5);
    }

    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j){
        return i.flatMap(a->j.map(b->Math.max(a,b)));
    }
}

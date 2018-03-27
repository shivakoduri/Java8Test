package com.myprojects.java8.forums.examples.forum1;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomDemo {

    private static final List<Integer> VALID_PWD_CHARS = new ArrayList<>();

    static {
        IntStream.rangeClosed('0', '9').forEach(VALID_PWD_CHARS::add); // 0-9
        IntStream.rangeClosed('a', 'z').forEach(VALID_PWD_CHARS::add); // a-z

        IntStream.rangeClosed('A', 'Z').forEach(VALID_PWD_CHARS::add); // A-Z
        IntStream.rangeClosed('!', '*').forEach(VALID_PWD_CHARS::add); //!-*

    }

    public static void main(String... args){
        //java.util.Random
        randomDemo();

        //java.security.SecureRandom
        secureRandomeDemo();
    }

    private static void secureRandomeDemo(){
        int passwordLength = 8;

        System.out.println("--Generated Password--");
        for(int i=0; i<5; i++){
            new SecureRandom().ints(passwordLength, 0, VALID_PWD_CHARS.size()).map(VALID_PWD_CHARS::get).forEach(s-> System.out.print((char)s));
            System.out.println();
        }
    }


    private static void randomDemo(){
        int passwordLength = 8;
        System.out.println("--Generated Password--");

        for(int i=0;i<5;i++){
            new Random().ints(passwordLength, 0 , VALID_PWD_CHARS.size()).map(VALID_PWD_CHARS::get).forEach(s -> System.out.print((char)s));
            System.out.println();
        }

    }
}

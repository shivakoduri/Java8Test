package com.myprojects.java8.examples.concepts.functionPackage;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class MainDemo {

    public static void main(String... args){

        //BiConsumer
        biConsumerDemo();

        //BiFunction
        biFunctionDemo();

        //BinaryOperator
        binaryOperatorDemo();
    }

    private static void binaryOperatorDemo(){
        //BinaryOperator represents an operation upon two operands of the same type, producing a result of the same type.
        //Method
        //BinaryOperator minBy
        //BinaryOperator maxBy

        BinaryOperator<Integer> adder = (n1, n2) -> n1+n2;
        System.out.println(adder.apply(3,4));
    }

    private static void biConsumerDemo(){
        //BiConsumer represents an operation that accepts two input arguments and returns no result
        BiConsumer<String, String> biConsumer = (x, y) ->{
            System.out.println(x);
            System.out.println(y);
        };
        biConsumer.accept("BiConsumer","Example");
    }

    private static void biFunctionDemo(){
        //BiFunction represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function.

        //    Method
        //BiFunction apply
        //BiFunction andThen

        BiFunction<String, String, String> bi = (x, y) ->{
            return x+y;
        };
        System.out.println(bi.apply("testing", " biFunction"));
    }
}

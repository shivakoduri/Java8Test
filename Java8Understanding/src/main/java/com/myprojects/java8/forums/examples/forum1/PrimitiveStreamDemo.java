package com.myprojects.java8.forums.examples.forum1;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamDemo {

    public static void main(String... args) {

        //IntStream
        intStreamDemo();

        //LongStream
        longStreamDemo();

        //DoubleStream
        doubleStreamDemo();
    }

    private static void doubleStreamDemo() {
        //java.util.stream.DoubleStream is a sequence of primitive double values and aggregate operations are performed using sequential and parallel operations.

        System.out.println("--Using DoubleStream.of--");
        DoubleStream.of(5.33, 2.34, 5.32, 2.31, 3.51).map(d -> d * 1.5).forEach(s -> System.out.println(s + " "));

        System.out.println("\n--Usingg DoubleStream.average--");
        double val = DoubleStream.of(12.1, 11.2, 13.3).average().getAsDouble();
        System.out.println(val);

        System.out.println("--Using DoubleStream.max--");
        val = DoubleStream.of(12.1, 11.2, 13.3).max().getAsDouble();
        System.out.println(val);

        System.out.println("--Using DoubleStream.filter--");
        DoublePredicate range = d -> d > 12.11 && d < 12.99;
        DoubleStream.of(12.1, 11.2, 12.3).filter(range).forEach(d -> System.out.println(d));

    }

    private static void longStreamDemo() {
        System.out.println("--Using LongStream.rangeClosed---");
        LongStream.rangeClosed(13, 15).map(n -> n * n).forEach(s -> System.out.println(s + " "));

        System.out.println("\n--Using LongStream.range");
        LongStream.range(13, 15).map(n -> n * n).forEach(s -> System.out.println(s + " "));

        System.out.println("\n--Sum of range 1 to 10--");
        System.out.println(LongStream.rangeClosed(1, 10).sum());

        System.out.println("\n--Sorted number--");
        LongStream.of(13, 4, 15, 2, 8).sorted().forEach(s -> System.out.println(s + " "));
    }

    private static void intStreamDemo() {
        System.out.println("--Using IntStream.rangeClosed--");
        IntStream.rangeClosed(13, 15).map(n -> n * n).forEach(s -> System.out.println(s + " "));

        System.out.println("\n--Using IntStream.range--");
        IntStream.range(13, 15).map(n -> n * n).forEach(s -> System.out.println(s + " "));

        System.out.println("\n--Sum of range 1 to 10--");
        System.out.println(IntStream.rangeClosed(1, 10).sum());

        System.out.println("\n--Sorted number--");
        IntStream.of(13, 4, 15, 2, 8).sorted().forEach(s -> System.out.println(s + " "));
    }


}

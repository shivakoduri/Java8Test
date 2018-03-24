package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Line;
import com.myprojects.java8.forums.examples.util.StatisticsUtility;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class SumDemo {

    public static void main(String... args){

        //Sum of Array Example
        sumOfArrayDemo();

        //Sum of List Example
        sumOfListDemo();

        //Sum of List of Array Example
        sumOfListOfArrayDemo();

        //Sum of Map Example
        sumOfMapValues();

    }

    private static void sumOfMapValues(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,12);
        map.put(2,24);
        map.put(3,10);

        System.out.println("---Using IntStream.sum()---");
        int sum = map.values().stream().mapToInt(i->1).sum();
        System.out.println("Sum:" + sum);

        System.out.println("--Using BinaryOperator");
        sum = map.values().stream().reduce(0, Integer::sum);
        System.out.println("Sum:" + sum);

        System.out.println("--Using Collectors.summingInt()---");
        sum = map.values().stream().collect(Collectors.summingInt(i ->1));
        System.out.println("Sum:" + sum);

        System.out.println("--Using Collectors.summarizingInt()---");
        IntSummaryStatistics stats = map.values().stream().collect(Collectors.summarizingInt(i->1));
        System.out.println("Sum:"+stats.getSum());

        System.out.println("--Using custom method--");
        sum = map.values().stream().reduce(0, StatisticsUtility::addIntData);
        System.out.println("Sum:" + sum);

    }

    private static void sumOfListOfArrayDemo(){
        List<Integer[]> list = new ArrayList<>();
        Integer[] a1 = {6,3,8,12};
        list.add(a1);

        Integer[] a2 = {8,13,9,22};
        list.add(a2);

        System.out.println("--Using Collectors.summingInt() --");
        int sum = list.stream().flatMap(a->Arrays.stream(a)).collect(Collectors.summingInt(i->i));
        System.out.println("Sum:" + sum);

        System.out.println("--Using Collectors.summarizingInt()---");
        IntSummaryStatistics stats = list.stream().flatMap(a -> Arrays.stream(a)).collect(Collectors.summarizingInt(i -> 1));
        System.out.println(stats.getSum());

        System.out.println("--Using IntStream.sum()--");
        sum = list.stream().flatMap(a->Arrays.stream(a)).mapToInt(Integer::intValue).sum();
        System.out.println("Sum:" + sum);
    }

    private static void sumOfListDemo(){
        List<Line> list = new ArrayList<>();
        list.add(new Line(213));
        list.add(new Line(233));
        list.add(new Line(243));
        list.add(new Line(253));

        System.out.println("--Using IntStream.sum()--");
        int sum = list.stream().map(Line::getLength).mapToInt(Integer::intValue).sum();
        System.out.println("Sum:" + sum);

        System.out.println("--Using Collectors.summingInt()--");
        sum = list.stream().map(Line::getLength).collect(Collectors.summingInt(i->i));
        System.out.println("Sum:" + sum);

        System.out.println("--Using summarizingInt() --");
        IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(Line::getLength));
        System.out.println("Sum:"+ stats.getSum());

        System.out.println("--Using Stream.reduce() with combiner --");
        sum = list.parallelStream().reduce(0, (output, ob) -> output+ob.getLength(), (a,b) -> a+b);
        System.out.println("Sum:" + sum);

    }

    private static void sumOfArrayDemo(){
        int[] array = {23,43,56,97,32};
        System.out.println("--Using IntStream.sum()--");
        int sum = Arrays.stream(array).sum();
        System.out.println("Sum:" + sum);

        System.out.println("--Using Stream.reduce() with IntBinaryOperator --");
        IntBinaryOperator ibop = (x,y) -> x+y;
        sum = Arrays.stream(array).reduce(0, ibop);
        System.out.println("Sum:"+ sum);

        System.out.println("--Using Stream.reduce() with Integer.sum() --");
        sum = Arrays.stream(array).reduce(0, Integer::sum);
        System.out.println("Sum:" +sum);

        System.out.println("--Using custom method --");
        sum = Arrays.stream(array).reduce(0, StatisticsUtility::addIntData);
        System.out.println("Sum:" + sum);

    }
}

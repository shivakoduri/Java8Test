package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.util.StatisticsUtility;

import java.util.Arrays;
import java.util.List;

public class StreamReduceDemo {

    public static void main(String... args){
        //Stream.reduce() with Accumulator
        reduceDemo1();

        //Stream.reduce() with Identity and Accumulator
        reduceDemo2();

        //Stream.reduce() with Identity, Accumulator and Combiner
        reduceDemo3();

        //Reduce List and Array into String
        reduceToString();
    }

    private static  void reduceToString(){
        //Reduce Array to String
        String[] array = {"Mohan", "Sohan", "Mahesh"};
        Arrays.stream(array).reduce((x,y) -> x+ "," +y).ifPresent(s-> System.out.println("Array to String:" + s));

        //Reduce List to String
        List<String> list = Arrays.asList("Mohan", "Sohan", "Mahesh");
        list.stream().reduce((x,y) -> x+ "," + y).ifPresent(s-> System.out.println("List to String:" + s));
    }

    private static void reduceDemo3(){
        //pass three arugments identity, accumulator and combiner in reduce() method.
        // reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)

        // This method is used in parallel processing. Combiner works with parallel streams only, otherwise there is nothing to combine.
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        //result will be 2*2 + 2*3+ 2*4  =18

        int res = list2.parallelStream().reduce(2, (s1, s2) -> s1 * s2, (p, q) -> p + q);
        System.out.println(res);

    }

    private static void reduceDemo2(){
        //will use an identity and accumulator. Passing the identity as start value

        // reduce(T identity, BinaryOperator<T> accumulator)
        int[] array = {23, 43, 56, 97, 32};
        //Set start value. Result will be start value + sum of array.

        int startValue = 100;
        int sum = Arrays.stream(array).reduce(startValue, (x,y) -> x+y);
        System.out.println(sum);

        sum = Arrays.stream(array).reduce(startValue, Integer::sum);
        System.out.println(sum);

        sum = Arrays.stream(array).reduce(startValue, StatisticsUtility::addIntData);
        System.out.println(sum);

    }

    private static void reduceDemo1(){
        //passing BinaryOperator as accumulator.
        //In case of numeric BinaryOperator, the start value will be 0.
        //In case of string, the start value will be blank string.

        //reduce(BinaryOperator accumulator)
        // The method will return Optional instance

        int[] array = {23, 43, 56, 97, 32};
        Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s->System.out.println(s));
        Arrays.stream(array).reduce(Integer::sum).ifPresent(s->System.out.println(s));
        Arrays.stream(array).reduce(StatisticsUtility::addIntData).ifPresent(s -> System.out.println(s));
    }


}

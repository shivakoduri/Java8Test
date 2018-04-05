package com.myprojects.java8.inaction.examples.chap05;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {

    public static void main(String... args){
        List<Dish> menu = ApplicationDataRepository.getDishes();

        List<Integer> numbers = Arrays.asList(3,4,5,1,2);

        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        int calories = menu
                .stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories:"+ calories);

        //max and OptionalInt
        OptionalInt maxCalories = menu
                .stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max=1;
        if(maxCalories.isPresent()){
            max = maxCalories.getAsInt();
        }
        System.out.println(max);

        // numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1,100).filter(n->n%2==0);
        System.out.println(evenNumbers.count());

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1,100).boxed()
                        .flatMap(a->IntStream.rangeClosed(a,100)
                                .filter(b->Math.sqrt(a*a + b*b) %1 ==0 ).boxed()
                                .map(b->new int[]{a, b, (int) Math.sqrt(a*a + b*b)}));
        pythagoreanTriples.forEach(t-> System.out.println(t[0]+","+t[1]+","+t[2]));
    }
}

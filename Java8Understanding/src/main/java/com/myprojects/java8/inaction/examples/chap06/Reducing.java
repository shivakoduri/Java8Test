package com.myprojects.java8.inaction.examples.chap06;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Reducing {
    private static List<Dish> menu = ApplicationDataRepository.getDishes();

    public static void main(String... args){
        System.out.println("Total calories in menu:"+ calculateTotalCalories());
        System.out.println("Total calories in menu:"+ calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu:"+ calculateTotalCaloriesWithoutCollectors());
        System.out.println("Total calories in menu:"+ calculateTotalCaloriesUsingSum());
    }

    private static int calculateTotalCalories(){
        return menu.stream().collect(Collectors.reducing(0,Dish::getCalories,(Integer i, Integer j) -> i+j));
    }

    private static int calculateTotalCaloriesWithMethodReference(){
        return menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors(){
        return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }

    private static int calculateTotalCaloriesUsingSum(){
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }


}

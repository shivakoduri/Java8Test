package com.myprojects.java8.inaction.examples.chap06;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Summarizing {

    private static List<Dish> menu = ApplicationDataRepository.getDishes();

    public static void main(String... args){
        System.out.println("No of dishes:" + howManyDishes());
        System.out.println("The most caloric dish is:" + findMostCaloricDish());
        System.out.println("The most caloric dish is:" + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu:" + calculateTotalCalories());
        System.out.println("Average calories in menu:" + calculateAverageCalories());
        System.out.println("Menu statistics:" + calculateMenuStatistics());
        System.out.println("Short menu:" + getShotrMenu());
        System.out.println("Short menu comma sepertaed:" + getShortMenuCommaSeperated());
    }

    private static long howManyDishes(){
        return menu.stream().collect(Collectors.counting());
    }

    private static Dish findMostCaloricDish(){
        return menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static Dish findMostCaloricDishUsingComparator(){
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloriesOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return menu.stream().collect(Collectors.reducing(moreCaloriesOf)).get();
    }

    private static int calculateTotalCalories(){
        return menu.stream().collect(Collectors.summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories(){
        return menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics(){
        return menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
    }

    private static String getShotrMenu(){
        return menu.stream().map(Dish::getName).collect(Collectors.joining());
    }

    private static String getShortMenuCommaSeperated(){
        return menu.stream().map(Dish::getName).collect(Collectors.joining(","));
    }
}

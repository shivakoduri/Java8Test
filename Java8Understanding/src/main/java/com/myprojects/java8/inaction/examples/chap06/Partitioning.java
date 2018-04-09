package com.myprojects.java8.inaction.examples.chap06;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

import java.util.*;
import java.util.stream.Collectors;

public class Partitioning {

    public static void main(String... args){
        System.out.println("Dishes partitioned by vegetatrian:" + partitionByVegeterian());
        System.out.println("Vegeterian Dishesh by type:" + vegeterainDishesByType());
        System.out.println("Most caloric dishes by vegeterian:" + mostCaloricPartitionedByVegeterian());
    }

    private static Map<Boolean, List<Dish>> partitionByVegeterian(){
        return ApplicationDataRepository.getDishes().stream().collect(Collectors.partitioningBy(Dish::isVegeterian));

        //{false=[pork, beef, chicken, prawns, salmon], true=[french fries, rice, season fruit, pizza]}
    }

    private static Map<Boolean, Map<Dish.Type, List<Dish>>> vegeterainDishesByType(){
        return ApplicationDataRepository.getDishes().stream().collect(Collectors.partitioningBy(Dish::isVegeterian, Collectors.groupingBy(Dish::getType)));

        //{false={MEAT=[pork, beef, chicken], FISH=[prawns, salmon]}, true={OTHER=[french fries, rice, season fruit, pizza]}}
    }

    private static Object mostCaloricPartitionedByVegeterian(){
        return ApplicationDataRepository.getDishes().stream()
                                                    .collect(
                                                            Collectors.partitioningBy(Dish::isVegeterian,
                                                                                      Collectors.collectingAndThen(
                                                                                              Collectors.maxBy(
                                                                                                      Comparator.comparingInt(Dish::getCalories)),
                                                                                                      Optional::get)));
        //{false=pork, true=pizza}
    }
}

package com.myprojects.java8.inaction.examples.chap06;

import com.myprojects.java8.model.CaloricLevel;
import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Grouping {

    public static void main(String... args){
        List<Dish> dishes = ApplicationDataRepository.getDishes();
        System.out.println("Dishes grouped by type:" + groupDishesByType(dishes));
        System.out.println("Dish names grouped by type:" + groupDishNamesByType(dishes));
//        System.out.println("Dish tags grouped by type:" + groupDishTagsByType(dishes));
//        System.out.println("Caloric dishes grouped by type:" + groupCaloricDishesByType());
        System.out.println("Dishes grouped by caloric level:" + groupingDishesByCaloricLevel(dishes));
        System.out.println("Dishes grouped by type and caloric leve:" + groupDishesByTypeAndCaloricLevel(dishes));
        System.out.println("Count dishes in groups:" + countDishesInGroups(dishes));
        System.out.println("Most caloric dishes by type:" + mostCaloricDishesByType(dishes));
        System.out.println("Most caloric dishes by type:" + mostCaloricDishesByTypeWithoutOptionals(dishes));
        System.out.println("Sum Calories by type:" + sumCaloriesByType(dishes));
        System.out.println("Caloric Levels by type:" + caloricLevelByType(dishes));

    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType(List<Dish> menu){
        return menu.stream().collect(Collectors.groupingBy(Dish::getType));
    }

    private static Map<Dish.Type, List<String>> groupDishNamesByType(List<Dish> menu){
        return menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
    }

//    private static Map<Dish.Type, Set<String>> groupDishTagsByType(List<Dish> menu){
//        return menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.flatMapping(dish -> Dish.dishTags.get(dish.getName()).stream(), toSet())))
//    }  // Collectors.flatMapping - Java9


//    private static Map<Dish.Type, List<Dish>> groupCaloricDishesByType(List<Dish> menu){
//        return menu.stream().collect(Collectors.groupingBy(Dish::getType, Collections.filtering(dish -> dish.getCalories() > 500, toList())))
//    } // Collectors.filtering - Java9

    private static Map<CaloricLevel, List<Dish>> groupingDishesByCaloricLevel(List<Dish> menu){
        return menu.stream().collect(
                Collectors.groupingBy(dish -> {
                    if(dish.getCalories() <= 400)  return CaloricLevel.DIET;
                    else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })
        );
    }

    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishesByTypeAndCaloricLevel(List<Dish> menu){
        return  menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy((Dish dish) -> {
                            if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if(dish.getCalories() <= 700) return  CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }))
        );
    }

    private static Map<Dish.Type, Long> countDishesInGroups(List<Dish> menu){
        return menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
    }

    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType(List<Dish> menu){
        return menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2))
        );
    }

    private static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOptionals(List<Dish> menu){
        return menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(Collectors.reducing((d1,d2)->d1.getCalories() > d2.getCalories() ? d1 : d2),Optional::get)));
    }

    private static Map<Dish.Type, Integer> sumCaloriesByType(List<Dish> menu){
        return menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
    }

    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType(List<Dish> menu){
        return menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.mapping(
                        dish->{
                            if(dish.getCalories() <=400) return CaloricLevel.DIET;
                            else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }, Collectors.toSet())));
    }
}

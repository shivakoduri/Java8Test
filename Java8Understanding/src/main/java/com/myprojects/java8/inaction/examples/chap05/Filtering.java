package com.myprojects.java8.inaction.examples.chap05;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

public class Filtering {

	public static void main(String[] args) {
		
		List<Dish> menu = ApplicationDataRepository.getDishes();
		//Filtering with predicate
		List<Dish> vegeterianMenu = menu.stream().filter(Dish::isVegeterian).collect(toList());
		
		vegeterianMenu.forEach(System.out::println);
		
		//Filtering unique elements
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		numbers.stream().filter(i -> i%2 ==0).distinct().forEach(System.out::println);
		
		//Truncating a stream
		List<Dish> dishesLimit3 = menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());
		dishesLimit3.forEach(System.out::println);
		
		//Skipping elements
		List<Dish> dishesSkip2 = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
		dishesSkip2.forEach(System.out::println);

	}

}

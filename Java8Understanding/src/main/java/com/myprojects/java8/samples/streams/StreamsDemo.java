package com.myprojects.java8.samples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

public class StreamsDemo {

	public static void main(String[] args) {
		
		filterUniqueElements();
		truncatingStream();
		skippingElementsInStream();
		filterFirstTwoMeatDishes();

	}
	
	private static void filterUniqueElements(){
		System.out.println("Executing filterUniqueElements()..");
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		numbers.stream().filter(i -> i%2 == 0).distinct().forEach(System.out::println);
		
	}
	
	private static void truncatingStream(){
		System.out.println("\nExecuting truncatingStream()..");
		List<Dish> dishes = ApplicationDataRepository.getDishes().stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());
		
		dishes.stream().map(Dish::getName).forEach(System.out::println);
		
	}
	
	private static void skippingElementsInStream(){
		System.out.println("\nExecuting skippingElementsInStream()..");
		List<Dish> dishes = ApplicationDataRepository.getDishes().stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors.toList());
		
		dishes.stream().map(Dish::getName).forEach(System.out::println);
	}
	
	private static void filterFirstTwoMeatDishes(){
		System.out.println("\nExecuting filterFirstTwoMeatDishes()..");
		List<Dish> dishes = ApplicationDataRepository.getDishes().stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(Collectors.toList());
		
		dishes.stream().map(Dish::getName).forEach(System.out::println);
	}

}

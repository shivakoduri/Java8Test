package com.myprojects.java8.samples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

public class StreamsDemo {

	public static void main(String[] args) {
		
		filterUniqueElements();
		truncatingStream();
		skippingElementsInStream();
		filterFirstTwoMeatDishes();
		calculateWordLength();
		calculateNamesLength();
		
		exampleForArraysStream();
		calSquareOfNumber();
		
		problem1();

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
	
	private static void calculateWordLength(){
		System.out.println("\nExecuting calculateWordLength()..");
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
		wordLengths.stream().forEach(System.out::println);
	}
	
	private static void calculateNamesLength(){
		System.out.println("\nExecuting calculateNamesLength()..");
		List<Integer> namesLength = ApplicationDataRepository.getDishes().stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
		namesLength.stream().forEach(System.out::println);
	}
	
	
	private static void exampleForArraysStream(){
		System.out.println("\nExecuting exampleForArraysStream()..");
		
		String[] arryOfWords = {"Goodbye", "World"};
		Stream<String> streamOfWords = Arrays.stream(arryOfWords);
		
		streamOfWords.map(String::toString).forEach(System.out::println);
	}
	
	
	private static void calSquareOfNumber(){
		System.out.println("\nExecuting calSquareOfNumber()..");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().map(n -> n*n).collect(Collectors.toList()).forEach(System.out::println);
		
	}
	
	
	private static void problem1(){
		//  Given two lists of numbers, how would you return all pairs of numbers? For example, given a
		//	list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. 
		
		
		
	}

}

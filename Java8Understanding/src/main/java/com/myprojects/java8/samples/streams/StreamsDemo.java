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

	}
	
	private static void filterUniqueElements(){
		
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		numbers.stream().filter(i -> i%2 == 0).distinct().forEach(System.out::println);
		
	}
	
	private static void truncatingStream(){
		List<Dish> dishes = ApplicationDataRepository.getDishes().stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());
		
		dishes.stream().map(Dish::getName).forEach(System.out::println);
		
	}

}

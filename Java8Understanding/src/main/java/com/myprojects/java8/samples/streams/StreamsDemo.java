package com.myprojects.java8.samples.streams;

import java.util.Arrays;
import java.util.List;

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
		
	}

}

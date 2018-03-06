package com.myprojects.java8.inaction.examples.chap05;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

public class Mapping {

	public static void main(String[] args) {
		
		List<Dish> menu = ApplicationDataRepository.getDishes();
		
		//map
		List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
		System.out.println(dishNames);
		
		//map
		List<String> words = Arrays.asList("Hello", "World");
		List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
		System.out.println(wordLengths);
		
		//flatMap
		words.stream().flatMap((String line) -> Arrays.stream(line.split(""))).distinct().forEach(System.out::println);
		
		//flatMap
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> numbers2 = Arrays.asList(6, 7, 8);
		List<int[]> pairs = numbers1.stream().flatMap((Integer i) -> numbers2.stream().map((Integer j) -> new int[]{i ,j})).filter(pair -> (pair[0] + pair[1])%3 ==0).collect(toList());
		pairs.forEach(pair -> System.out.println("(" + pair[0] +","+pair[1]+")"));
		
		//flatMap example
		flatMapExamples();
	}
	
	private static void flatMapExamples(){
		
		flatMapExample1();
		flatMapExample2();
		
	}
	
	private static void flatMapExample1(){
		
		//convert Stream<List<Integer>> to Stream<Integer>
		
		//pre-Java 8 you just need a loops:
		List<List<Integer>> integerLists = Arrays.asList(
				  Arrays.asList(1, 2), 
				  Arrays.asList(3, 4), 
				  Arrays.asList(5)
				);

		List<Integer> flattened = new ArrayList<>();

		for (List<Integer> integerList : integerLists){
			flattened.addAll(integerList);
		}

		for (Integer i : flattened){
		     System.out.println(i);
		}
		
		
		//Java-8 using flatMap
		Stream<List<Integer>> integerListStream = Stream.of(
				Arrays.asList(1, 2),
				Arrays.asList(3, 4),
				Arrays.asList(5));
		
		Stream<Integer> integerStream = integerListStream.flatMap(Collection::stream);
		integerStream.forEach(System.out::println);
	}
	
	private static void flatMapExample2(){
//		create the following sequence: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 etc. (in other words: 1x1, 2x2, 3x3 etc.)
		
		//pre Java-8
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <=4; i++){
			for(int j=0; j < i; j++){
				list.add(i);
			}
		}
		System.out.println("pre java-8 list->" + list);
		
//		IntStream sequence = IntStream.rangeClosed(1, 4).flatMap(i -> IntStream.iterate(i, identity()).limit(i));
//		sequence.forEach(System.out::println);
		
		//IntStream.rangeClosed(1, 4) creates a stream of int from 1 to 4, inclusive
		//IntStream.iterate(i, identity()).limit(i) creates a stream of length i of int i - so applied to i = 4 it creates a stream: 4, 4, 4, 4
		//flatMap "flattens" the stream and "concatenates" it to the original stream
		
	}

}

package com.myprojects.java8.inaction.examples.chap04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollection {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
		Stream<String> s = names.stream();
		s.forEach(System.out::println);

	}

}

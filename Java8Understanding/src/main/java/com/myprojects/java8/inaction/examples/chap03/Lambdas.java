package com.myprojects.java8.inaction.examples.chap03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.myprojects.java8.inaction.examples.DataSource;
import com.myprojects.java8.inaction.examples.model.Apple;
import com.myprojects.java8.inaction.examples.spec.ApplePredicate;

public class Lambdas {

	public static void main(String[] args) {
		// Simple example
		Runnable r = () -> System.out.println("Hello!");
		r.run();

		// Filtering with lambdas
		List<Apple> inventory = DataSource.getApples();

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filter(inventory,
				(Apple a) -> "green".equals(a.getColor()));
		System.out.println(greenApples);

		Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(
				a2.getWeight());

		// [Apple{color='green', weight=80}, Apple{color='red', weight=120},
		// Apple{color='green', weight=155}]
		inventory.sort(c);
		System.out.println(inventory);

	}
	
	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {

		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}

		return result;
	}

}

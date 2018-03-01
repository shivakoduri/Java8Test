package com.myprojects.java8.inaction.examples.chap03;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.myprojects.java8.inaction.examples.model.Apple;

public class Sorting {

	public static void main(String[] args) {
		// 1
		List<Apple> inventory = new ArrayList<>();
		inventory.addAll(Arrays.asList(new Apple(80, "green"), new Apple(155,
				"green"), new Apple(120, "red")));

		// [Apple{color='green', weight=80}, Apple{color='red', weight=120},
		// Apple{color='green', weight=155}]
		inventory.sort(new AppleComparator());
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(30, "green"));

		// 2
		// [Apple{color='green', weight=30}, Apple{color='green', weight=80},
		// Apple{color='green', weight=155}]
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(20, "red"));

		// 3
		// [Apple{color='red', weight=20}, Apple{color='green', weight=30},
		// Apple{color='green', weight=155}]
		inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(10, "red"));

		// 4
		// [Apple{color='red', weight=10}, Apple{color='red', weight=20},
		// Apple{color='green', weight=155}]
		inventory.sort(comparing(Apple::getWeight));
		System.out.println(inventory);

	}

}

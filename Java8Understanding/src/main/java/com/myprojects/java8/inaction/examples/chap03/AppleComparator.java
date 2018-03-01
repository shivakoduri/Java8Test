package com.myprojects.java8.inaction.examples.chap03;

import java.util.Comparator;

import com.myprojects.java8.inaction.examples.model.Apple;

public class AppleComparator implements Comparator<Apple> {

	@Override
	public int compare(Apple a1, Apple a2) {
		return a1.getWeight().compareTo(a2.getWeight());
	}


}

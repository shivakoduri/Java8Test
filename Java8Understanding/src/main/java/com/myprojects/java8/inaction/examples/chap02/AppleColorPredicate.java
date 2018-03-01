package com.myprojects.java8.inaction.examples.chap02;


import com.myprojects.java8.inaction.examples.model.Apple;
import com.myprojects.java8.inaction.examples.spec.ApplePredicate;

public class AppleColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}


}

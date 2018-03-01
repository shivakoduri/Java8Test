package com.myprojects.java8.inaction.examples;

import java.util.Arrays;
import java.util.List;

import com.myprojects.java8.inaction.examples.model.Apple;

public class DataSource {
	
	public static List<Apple> getApples(){
		return  Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
	}

}

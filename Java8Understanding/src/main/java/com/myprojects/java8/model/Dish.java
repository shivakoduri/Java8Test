package com.myprojects.java8.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dish {
	
	private final String name;
	private final boolean vegeterian;
	private int calories;
	private Type type;
	
	public Dish(String name, boolean vegeterian, int calories, Type type){
		this.name = name;
		this.vegeterian = vegeterian;
		this.calories = calories;
		this.type= type;
	}
	
	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegeterian() {
		return vegeterian;
	}

	public enum Type{
		MEAT, FISH, OTHER
	}

	@Override
	public String toString(){
		return name;
	}

	public static final Map<String, List<String>> dishTags = new HashMap<>();

	static{
		dishTags.put("pork", Arrays.asList("greasy", "salty"));
		dishTags.put("beef", Arrays.asList("salty", "roasted"));
		dishTags.put("chicken", Arrays.asList("fried", "crisp"));
		dishTags.put("french fries", Arrays.asList("greasy", "fried"));
		dishTags.put("rice", Arrays.asList("light", "natural"));
		dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
		dishTags.put("pizza", Arrays.asList("tasty", "salty"));
		dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
		dishTags.put("salmon", Arrays.asList("delicious", "fresh"));
	}
}

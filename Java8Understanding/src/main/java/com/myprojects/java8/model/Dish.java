package com.myprojects.java8.model;

public class Dish {
	
	private final String name="";
	private final boolean vegeterian = false;
	private int calories;
	private Type type;
	
	
	
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
	

}

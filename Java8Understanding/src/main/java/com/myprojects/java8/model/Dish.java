package com.myprojects.java8.model;

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
	

}

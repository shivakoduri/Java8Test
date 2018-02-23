package com.myprojects.java8.samples.data;

import java.util.Arrays;
import java.util.List;

import com.myprojects.java8.model.Dish;

public class ApplicationDataRepository {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	public static List<Dish> getDishes(){
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", false, 530, Dish.Type.OTHER),
				new Dish("rice", false, 350, Dish.Type.OTHER),
				new Dish("season fruit", false, 120, Dish.Type.OTHER),
				new Dish("pizza", false, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH)
				);
		
		return menu;
		
	}

}

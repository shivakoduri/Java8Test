package com.myprojects.java8.inaction.examples.chap05;

import java.util.Optional;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

public class Finding {

	public static void main(String[] args) {
		
		if(isVegeterianFriendlyMenu()){
			System.out.println("Vegeterian friendly");
		}
		
		System.out.println(isHealthyMenu());
		System.out.println(isHealthyMenu2());
		
		Optional<Dish> dish = findVegeterianDish();
		dish.ifPresent(d -> System.out.println(d.getName()));
	}
	
	private static boolean isVegeterianFriendlyMenu(){
		return ApplicationDataRepository.getDishes().stream().anyMatch(Dish::isVegeterian);
	}
	
	private static boolean isHealthyMenu(){
		return ApplicationDataRepository.getDishes().stream().allMatch(d -> d.getCalories() < 1000);
	}
	
	private static boolean isHealthyMenu2(){
		return ApplicationDataRepository.getDishes().stream().noneMatch(d -> d.getCalories() >= 1000);
	}
	
	private static Optional<Dish> findVegeterianDish(){
		return ApplicationDataRepository.getDishes().stream().filter(Dish::isVegeterian).findAny();
	}

}

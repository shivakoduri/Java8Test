package com.myprojects.java8.samples.functionalInterface;

import java.util.function.Function;

public class FunctionExamples {
	
	 /* java.util.function.Function is a functional interface whose functional method (single abstract method) is R apply(T t) . 
	  * The Function interface represents an operation that takes single argument T and returns a result R.*/
	
	public static void main(String[] args) {
		
		functionExample_1();
		functionExample_2();

	}
	
	private static void functionExample_1(){
		/*The following example shows how to use the apply() method 
		 * of the Function interface using Lambda expression.*/
		
		Function<Integer, String> function = (t) -> {
			if (t % 2 == 0) {
				return t+ " is even number";
			} else {
				return t+ " is odd number";
			}
		};

		System.out.println(function.apply(5));
		System.out.println(function.apply(8));
	}
	
	private static void functionExample_2(){
		/*The following example shows how to use the default methods (andThen()  and compose()) 
		 * of the Function interface using Lambda expression.*/
		
		Function<Integer, Integer> function1 = t -> (t - 5);
		Function<Integer, Integer> function2 = t -> (t * 2);
		
		//Using andThen() method
		int a=function1.andThen(function2).apply(50);
		System.out.println(a);
		
		//Using compose function
		int c=function1.compose(function2).apply(50);
		System.out.println(c);
	}

}

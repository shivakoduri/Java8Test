package com.myprojects.java8.samples.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.model.Trader;
import com.myprojects.java8.model.Transaction;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

public class StreamsDemo {

	public static void main(String[] args) {
		
		filterUniqueElements();
		truncatingStream();
		skippingElementsInStream();
		filterFirstTwoMeatDishes();
		calculateWordLength();
		calculateNamesLength();
		
		exampleForArraysStream();
		calSquareOfNumber();
		
		problem1();
		
		findAndMatching(); //short-circuiting
		
		reducingOperations(); //a stream is reduced to a value
		
		traders_transaction_Operations();//traders and transactions examples
	}
	
	private static void filterUniqueElements(){
		System.out.println("Executing filterUniqueElements()..");
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		numbers.stream().filter(i -> i%2 == 0).distinct().forEach(System.out::println);
		
	}
	
	private static void truncatingStream(){
		System.out.println("\nExecuting truncatingStream()..");
		List<Dish> dishes = ApplicationDataRepository.getDishes().stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());
		
		dishes.stream().map(Dish::getName).forEach(System.out::println);
		
	}
	
	private static void skippingElementsInStream(){
		System.out.println("\nExecuting skippingElementsInStream()..");
		List<Dish> dishes = ApplicationDataRepository.getDishes().stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors.toList());
		
		dishes.stream().map(Dish::getName).forEach(System.out::println);
	}
	
	private static void filterFirstTwoMeatDishes(){
		System.out.println("\nExecuting filterFirstTwoMeatDishes()..");
		List<Dish> dishes = ApplicationDataRepository.getDishes().stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(Collectors.toList());
		
		dishes.stream().map(Dish::getName).forEach(System.out::println);
	}
	
	private static void calculateWordLength(){
		System.out.println("\nExecuting calculateWordLength()..");
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
		wordLengths.stream().forEach(System.out::println);
	}
	
	private static void calculateNamesLength(){
		System.out.println("\nExecuting calculateNamesLength()..");
		List<Integer> namesLength = ApplicationDataRepository.getDishes().stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
		namesLength.stream().forEach(System.out::println);
	}
	
	
	private static void exampleForArraysStream(){
		System.out.println("\nExecuting exampleForArraysStream()..");
		
		String[] arryOfWords = {"Goodbye", "World"};
		Stream<String> streamOfWords = Arrays.stream(arryOfWords);
		
		streamOfWords.map(String::toString).forEach(System.out::println);
	}
	
	
	private static void calSquareOfNumber(){
		System.out.println("\nExecuting calSquareOfNumber()..");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().map(n -> n*n).collect(Collectors.toList()).forEach(System.out::println);
		
	}
	
	
	private static void problem1(){
		//Unsolved
		
		//  Given two lists of numbers, how would you return all pairs of numbers? For example, given a
		//	list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. 
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		
//		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i,j})).collect(Collectors.toList());
		
		
		//Appending the question
		//eturn only pairs whose sum is divisible by 3 //For example, (2, 4) and (3, 3) are valid.
		
//		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i,j})).collect(Collectors.toList());
		
	}
	
	private static void findAndMatching(){
		
		matchAtleastOneElement();
		matchesAllElements();
		matchesNone();
		
		findingAnElement();
		findFirstElement();
	}
	
	private static void matchAtleastOneElement(){
		System.out.println("\nExecuting findAndMatching:: matchAtleastOneElement()..");
		List<Dish> menu = ApplicationDataRepository.getDishes();
		
		if(menu.stream().anyMatch(Dish::isVegeterian)){
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
			}
	}
	
	
	private static void matchesAllElements(){
		System.out.println("\nExecuting findAndMatching:: matchesAllElements()..");
		
		boolean isHealthy = ApplicationDataRepository.getDishes().stream()
				.allMatch(d -> d.getCalories() < 1000);
		
	}
	
	private static void matchesNone(){
		System.out.println("\nExecuting findAndMatching:: matchesNone()..");
		
		boolean isHealthy = ApplicationDataRepository.getDishes().stream()
				.noneMatch(d -> d.getCalories() >= 1000);
	}
	
	private static void findingAnElement(){
		System.out.println("\nExecuting findAndMatching:: findingAnElement()..");
		
		Optional<Dish> dish = ApplicationDataRepository.getDishes().stream().filter(Dish::isVegeterian).findAny();
		
		System.out.println(dish.isPresent() ? dish.get().getName() : null);
		
	}
	
	private static void findFirstElement(){
		System.out.println("\nExecuting findAndMatching:: findFirstElement()..");
		
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst(); // 9
		
	}
	
	private static void reducingOperations(){
		//In functional programming-language jargon, this is referred to as a fold
		
		summingElements();
		multiplyingElements();
		
		maxElement();
		minElement();
	}
	
	
	private static void summingElements(){
		System.out.println("\nExecuting reducingOperations:: summingElements()..");
		
		int sum = Arrays.asList(1,2,3,4).stream().reduce(0, (a, b) -> a + b);  // sum
		
		int sumUsingLambda = Arrays.asList(1,2,3,4).stream().reduce(0, Integer::sum);  // Using lambda
		
		Optional<Integer> sumWithNoInitialValue = Arrays.asList(1,2,3,4).stream().reduce((a, b) -> (a + b));  //No initial value
	}
	
	private static void multiplyingElements(){
		System.out.println("\nExecuting reducingOperations:: multiplyingElements()..");

		int product = Arrays.asList(1,2,3,4).stream().reduce(1, (a, b) -> a * b);   //multiply
		
	}
	
	
	private static void maxElement(){
		System.out.println("\nExecuting reducingOperations:: maxElement()..");
		Optional<Integer> max = Arrays.asList(1,2,3,4).stream().reduce(Integer::max);
	}
	
	private static void minElement(){
		System.out.println("\nExecuting reducingOperations:: minElement()..");
		Optional<Integer> min = Arrays.asList(1,2,3,4).stream().reduce(Integer::min);
	}
	
	
	private static void countNumOfDishes(){
		System.out.println("\nExecuting reducingOperations:: countNumOfDishes()..");
		int countNumOfDishes = ApplicationDataRepository.getDishes().stream().map(d -> 1).reduce(0, (a, b) -> a + b); //Count number od dishes

	}
	
	
	private static void traders_transaction_Operations(){
		
//		1. Find all transactions in the year 2011 and sort them by value (small to high).
		
		List<Transaction> tr2011 = ApplicationDataRepository.getTransactions()
				.stream()
				.filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
		
//		2. What are all the unique cities where the traders work?
		
		List<String> citiesList = ApplicationDataRepository.getTransactions()
				.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.distinct()
				.collect(Collectors.toList());
		
		Set<String> citiesSet = ApplicationDataRepository.getTransactions()
				.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.collect(Collectors.toSet());
		
//		3. Find all traders from Cambridge and sort them by name.
		
		List<Trader> traders = ApplicationDataRepository.getTransactions()
				.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		
//		4. Return a string of all traders’ names sorted alphabetically.
		
		String traderStr_using_reduce = ApplicationDataRepository.getTransactions()
				.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("",(n1,n2) -> n1+ n2);
		
		String traderStr_using_joining = ApplicationDataRepository.getTransactions()
				.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.joining());
				
		
//		5. Are any traders based in Milan?
		
		boolean milanBased = ApplicationDataRepository.getTransactions().stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")); 
		
//		6. Print all transactions’ values from the traders living in Cambridge.
		
		ApplicationDataRepository.getTransactions().stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);
		
//		7. What’s the highest value of all the transactions?
		
		Optional<Integer> highestValue = ApplicationDataRepository.getTransactions().stream().map(Transaction::getValue).reduce(Integer::max);
		
//		8. Find the transaction with the smallest value.
		
		Optional<Transaction> smallestTransactions = ApplicationDataRepository.getTransactions().stream().reduce( (t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		
	}
	

}

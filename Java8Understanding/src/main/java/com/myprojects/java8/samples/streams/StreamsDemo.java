package com.myprojects.java8.samples.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
		
		numericStreamsExample();
		
		optionalInt();
		
		numericRanges();
		
		buildingStreams();
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
		
		boolean milanBased = ApplicationDataRepository.getTransactions()
				.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")); 
		
//		6. Print all transactions’ values from the traders living in Cambridge.
		
		ApplicationDataRepository.getTransactions()
		.stream()
		.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
		.map(Transaction::getValue)
		.forEach(System.out::println);
		
//		7. What’s the highest value of all the transactions?
		
		Optional<Integer> highestValue = ApplicationDataRepository.getTransactions()
				.stream()
				.map(Transaction::getValue)
				.reduce(Integer::max);
		
//		8. Find the transaction with the smallest value.
		
		Optional<Transaction> smallestTransactions = ApplicationDataRepository.getTransactions()
				.stream()
				.reduce( (t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		
		Optional<Transaction> smallestTransaction = ApplicationDataRepository.getTransactions()
				.stream()
				.min(Comparator.comparing(Transaction::getValue));    //stream supports the methods min and max that take a Comparator as
				                                                      //argument to specify which key to compare with when calculating the minimum or maximum:
	}
	
	
	private static void numericStreamsExample(){
		
		//calculate the number of calories in the menu 
		int calories_with_reduce = ApplicationDataRepository.getDishes().stream().map(Dish::getCalories).reduce(0, Integer::sum);
		
		//In the above code there’s an insidious boxing cost. Behind the scenes each
		//Integer needs to be unboxed to a primitive before performing the summation
		
//		int calories_with_sum = ApplicationDataRepository.getDishes().stream().map(Dish::getCalories).sum();  //The problem is that the method map generates a Stream<T>
		
		//Eventhough the elements of the stream are of type Integer, the Streams interface doesn’t define asum method
		//Say you had only a Stream<Dish> like the menu; it wouldn’t make any sense to be able to sum dishes.
		
//		the Streams API also supplies primitive stream[IntStream,DoubleStream, and LongStream] specializations that support specialized methods to work with streams of numbers
		
		
		int calories_with_sum = ApplicationDataRepository.getDishes().stream().mapToInt(Dish::getCalories).sum();
		//the method mapToInt extracts all the calories from each dish (represented as an Integer) and returns an IntStream as the result (rather than a Stream<Integer>).
		
		
		//
		//To convert from a primitive stream to a general stream(each int will be boxed to anInteger) you can use the method boxed as follows:
		
		IntStream  intStream = ApplicationDataRepository.getDishes().stream().mapToInt(Dish::getCalories);
		Stream<Integer> stream = intStream.boxed();
	}
	
	private static void optionalInt(){
//		The sum example was convenient because it has a default value: 0. But if you want to calculate
//		the maximum element in an IntStream, you need something different because 0 is a wrong result.
		
//		There’s a primitive specialized version of Optional as well for the three primitive
//		stream specializations: OptionalInt, OptionalDouble, and OptionalLong.
		
		OptionalInt maxCalories = ApplicationDataRepository.getDishes()
				.stream()
				.mapToInt(Dish::getCalories)
				.max();
		
		 //process the OptionalInt explicitly to define a default value if there’s no maximum:
		int max = maxCalories.orElse(1); //provide an explicit default value if there's no value.
	}
	
	private static void numericRanges(){
		//Java 8 introduces two static methods available on IntStream and LongStream to help generate such ranges: range and rangeClosed.
		
		IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n%2 == 0);
		System.out.println(evenNumbers.count());
		
	}
	
	private static void buildingStreams(){
		//create a stream from a sequence of values, from an array, from a file, and even from a generative function to create infinite streams
		
		//streams from values
		streamsFromValues();
		streamsFromArrays();
		streamsFromFiles();
		streamsFromFunctions(); //creating infinite streams
	}
	
	private static void streamsFromValues(){
		//create a stream with explicit values by using the static method Stream.of
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
		
//		empty stream using the empty method as follows:
		Stream<String> emptyStream = Stream.empty();
	}
	
	private static void streamsFromArrays(){
		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum();
	}
	
	
	private static void streamsFromFiles(){
		long uniqueWords = 0;
		try(Stream<String> lines =
				Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		}catch(IOException e){
			
		}
		
	}
	
	
	private static void streamsFromFunctions(){ 
//		    generate a stream from a function: Stream.iterate and Stream.generate. These two operations let you create what we call an infinite
//			stream: a stream that doesn’t have a fixed size like when you create a stream from a fixed collection.
		
		//Stream.iterate
		Stream.iterate(0, n -> n + 2)
		.limit(10)
		.forEach(System.out::println);
		
		
		//Stream.generate
		Stream.generate(Math::random)
		.limit(5)
		.forEach(System.out::println);
	}
	

}

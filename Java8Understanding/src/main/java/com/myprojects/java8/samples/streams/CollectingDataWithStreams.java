package com.myprojects.java8.samples.streams;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.myproject.java8.samples.model.Currency;
import com.myproject.java8.samples.model.Transaction;
import com.myprojects.java8.model.CaloricLevel;
import com.myprojects.java8.model.Dish;
import com.myprojects.java8.samples.data.ApplicationDataRepository;
import com.myprojects.java8.samples.data.LoadData;

public class CollectingDataWithStreams {
	
	
	public void runExamples(){
		//Grouping transactions by currency
		groupingTransactions();
		
		//1. Reducing and summarizing
		ReducingAndSummarizing();
		
		//2. Grouping
		grouping(ApplicationDataRepository.getDishes());
		
		//3.Partitioning
		partitioning(ApplicationDataRepository.getDishes());
		
	}
	
	private void partitioning(List<Dish> menu){
		//partitioning the menu into vegetarian and nonvegetarian dishes
		Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegeterian)); //{false={FISH=[prawns, salmon], MEAT=[pork, beef, chicken]},true={OTHER=[french fries, rice, season fruit, pizza]}}
		
		//find the most caloric dish among both vegetarian and nonvegetarian dishes:
		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
		 menu.stream().collect(
					partitioningBy(Dish::isVegeterian,
							collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));  //{false=pork, true=pizza}
		
		
	}
	
	private void grouping(List<Dish> menu){
		Map<Dish.Type, List<Dish>> dishesByType = ApplicationDataRepository.getDishes().stream().collect(groupingBy(Dish::getType));
		
		//
		dishesByCaloricLevel();
		
		//Multilevelgrouping
		multiLevelGrouping();
		
		//Collecting Data in subgroups
		collectingDataInSubGroups();
		
		//find the highest-calorie dish in the menu
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = 
				ApplicationDataRepository.getDishes()
				.stream()
				.collect(
						groupingBy(
								Dish::getType, 
								maxBy(
										comparingInt(
												Dish::getCalories
												)
									  )
							    )
						);
		
//		reuse the collector created to sum the calories of all the dishes in the menu to obtain a similar result, but this time for each group of Dishes
		Map<Dish.Type, Integer> totalCaloriesByType = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
		
		//to know which CaloricLevels are available in the menu for each type of Dish
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = 
				menu
				.stream()
				.collect(
						groupingBy(
								Dish::getType, 
								mapping(
										dish -> { 
											if (dish.getCalories() <= 400) return CaloricLevel.DIET; 
											else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
											else return CaloricLevel.FAT; 
											},
											toSet() 
										)
								)
						); //{OTHER=[DIET, NORMAL], MEAT=[DIET, NORMAL, FAT], FISH=[DIET, NORMAL]}
		
		//HashSet by passing a constructor reference
//		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType_ =
//				menu.stream().collect(
//				groupingBy(Dish::getType, mapping(
//				dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//				else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
//				else return CaloricLevel.FAT; },
//				toCollection(HashSet::new) )));
	}
	
	private void collectingDataInSubGroups(){
		Map<Dish.Type, Long> typesCount = ApplicationDataRepository.getDishes().stream().collect(groupingBy(Dish::getType, counting()));
	}
	
	
	
	private void multiLevelGrouping(){
//		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = 
//				ApplicationDataRepository.getDishes().stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
//					if(dish.getCalories() <= 400) return CaloricLevel.DIET ;
//					else if(dish.getCalories() <= 700)return CaloricLevel.NORMAL;
//					else return CaloricLevel.FAT;
//				})));
		
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = 
				ApplicationDataRepository.getDishes()
				.stream()
				.collect(
						groupingBy(
								Dish::getType, 
								groupingBy(
										(Dish dish) -> {
												if (dish.getCalories() <= 400)
													return CaloricLevel.DIET;
												else if (dish.getCalories() <= 700)
													return CaloricLevel.NORMAL;
												else
													return CaloricLevel.FAT;
										}
								)
						)
				);		
	}
	
	
	private void dishesByCaloricLevel(){
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = ApplicationDataRepository
				.getDishes().stream().collect(groupingBy(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return

						CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}));
	}
	
	private void groupingTransactions(){
		
		//Grouping transactions by currency in imperative style
		Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();
		for(Transaction transaction : LoadData.getTransactions()){
			Currency currency = transaction.getCurrency();
			List<Transaction> transactionForCurrencies = transactionByCurrencies.get(currency);
			
			if(transactionForCurrencies == null){
				transactionForCurrencies = new ArrayList<>();
				transactionByCurrencies.put(currency, transactionForCurrencies);
			}
			transactionForCurrencies.add(transaction);
		}
		
		//Grouping transactions by currency in functional style
		Map<Currency, List<Transaction>> transactionsByCurrencies =
				LoadData.getTransactions().stream().collect(groupingBy(Transaction::getCurrency));
//		the argument passed to the collect method is an implementation of the Collector
//		interface, which is a recipe for how to build a summary of the elements in the Stream.
	}
	
	private void ReducingAndSummarizing(){
		//
		countNumberOfDishes();
		
		//Finding maximum and minimum in a stream of values
		maxAndminValue();
		
		//summarization
		summarization();
		
		//joinig strings
		joiningStrings();
		
		//generalized summarization with reduction
		generalizedSummarization();
	}
	
	private void generalizedSummarization(){
		//calculate the total calories in your menu with a collector created from the reducing method 
		int totalCalories = ApplicationDataRepository.getDishes().stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
		
		//find the highest-calorie dish using the one-argument version of reducing
		Optional<Dish> mostCalorieDish = ApplicationDataRepository.getDishes().stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		
		//without using a collector
		  //by mapping the stream of dishes into the number of calories of each dish and then reducing this resulting stream with the same method reference
		int totalCalories_ = ApplicationDataRepository.getDishes().stream().map(Dish::getCalories).reduce(Integer::sum).get();
		
		//mapping the stream to an IntStream and then invoking the sum method on it
		int _totalCalories = ApplicationDataRepository.getDishes().stream().mapToInt(Dish::getCalories).sum();
		
	}
	
	private void joiningStrings(){
		//
		String shortMenu = ApplicationDataRepository.getDishes().stream().map(Dish::getName).collect(joining()); //porkbeefchickenfrench friesriceseason fruitpizzaprawnssalmon
		//
		String shortMenu_ = ApplicationDataRepository.getDishes().stream().map(Dish::getName).collect(joining(", ")); //pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon
		
		otherExample();
		
	}
	
	private void otherExample(){
//		Joining strings with reducing
//		reducing collector are valid replacements for this joining collector 
		String shortMenu = ApplicationDataRepository.getDishes().stream().map(Dish::getName).collect(joining());
		
		//1
		String _shortMenu = ApplicationDataRepository.getDishes().stream().map(Dish::getName).collect( reducing( (s1, s2) -> s1 + s2 ) ).get();
		
		//2
		String shortMenu_ = ApplicationDataRepository.getDishes().stream().collect( reducing( "", Dish::getName, (s1, s2) -> s1 + s2 ) );
	}
	
	private void summarization(){
//		The Collectors class provides a specific factory method for summing: Collectors .summingInt. 
		int totalCalories = ApplicationDataRepository.getDishes().stream().collect(summingInt(Dish::getCalories));
		
		double avgCalories = ApplicationDataRepository.getDishes().stream().collect(averagingInt(Dish::getCalories));
		
		//summarization
		IntSummaryStatistics menuStatistics = ApplicationDataRepository.getDishes().stream().collect(summarizingInt(Dish::getCalories));
	}
	
	private void countNumberOfDishes(){
		//count the number of dishes in the menu, using the collector returned by the counting factory method
		long howManyDishes = ApplicationDataRepository.getDishes().stream().collect(counting());
		
		//another way
		long howManyDishes_ = ApplicationDataRepository.getDishes().stream().count();
	}
	
	private void maxAndminValue(){
//        Collectors.maxBy and Collectors.minBy, to calculate the maximum or minimum value in a stream. 
//		These two collectors take a Comparator as argument to compare the elements in the stream. 
//		Here you create a Comparator comparing dishes based on their calorie content and pass it to Collectors.maxBy:
		
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCalorieDish = ApplicationDataRepository.getDishes().stream().collect(maxBy(dishCaloriesComparator));
	}

}

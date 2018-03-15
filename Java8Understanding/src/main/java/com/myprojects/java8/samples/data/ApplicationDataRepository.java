package com.myprojects.java8.samples.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.myprojects.java8.model.Dish;
import com.myprojects.java8.model.SalesTerritory;
import com.myprojects.java8.model.Trader;
import com.myprojects.java8.model.Transaction;

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
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH)
				);
		
		return menu;
		
	}
	
	public static List<Transaction> getTransactions(){
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
		
		return transactions;
	}
	
	public static Set<SalesTerritory> getSaleTerritories(){
		Set<SalesTerritory> territories = new HashSet<>(
            Arrays.asList(
                new SalesTerritory[]{
                    new SalesTerritory( "North-East, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "Maine", "New Hampshire", "Vermont",
                                                                                    "Rhode Island", "Massachusetts", "Connecticut",
                                                                                    "New York", "New Jersey", "Delaware", "Maryland",
                                                                                    "Eastern Pennsylvania", "District of Columbia" } ) ) ),
                    new SalesTerritory( "Appalachia, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "West-Virgina", "Kentucky",
                                                                                    "Western Pennsylvania" } ) ) ),
                    new SalesTerritory( "South-East, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "Virginia", "North Carolina", "South Carolina",
                                                                                    "Georgia", "Florida", "Alabama", "Tennessee",
                                                                                    "Mississippi", "Arkansas", "Louisiana" } ) ) ),
                    new SalesTerritory( "Mid-West, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "Ohio", "Michigan", "Wisconsin", "Minnesota",
                                                                                    "Iowa", "Missouri", "Illinois", "Indiana" } ) ) ),
                    new SalesTerritory( "Great Plains, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "Oklahoma", "Kansas", "Nebraska",
                                                                                    "South Dakota", "North Dakota",
                                                                                    "Eastern Montana",
                                                                                    "Wyoming", "Colorada" } ) ) ),
                    new SalesTerritory( "Rocky Mountain, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "Western Montana", "Idaho", "Utah", "Nevada" } ) ) ),
                    new SalesTerritory( "South-West, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "Arizona", "New Mexico", "Texas" } ) ) ),
                    new SalesTerritory( "Pacific North-West, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "Washington", "Oregon", "Alaska" } ) ) ),
                    new SalesTerritory( "Pacific South-West, USA",
                                        new HashSet<>( Arrays.asList( new String[]{ "California", "Hawaii" } ) ) )
                }
            )
        );
		
		return territories;
	}

}

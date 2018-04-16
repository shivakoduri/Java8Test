package com.myprojects.java8.examples.concepts;

import static java.util.AbstractMap.SimpleEntry;

import java.util.Collections;
import java.util.Set;

import com.myprojects.java8.model.SalesTerritory;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

public class FlatMapExamples {

	public static void main(String[] args) {
		//SalesTerritories
		getSalesTerritories();
	}
	
	private static void getSalesTerritories(){
		
		System.out.println( "We can use 'flatMap' in combination with the 'AbstractMap.SimpleEntry' " +
				"class to flatten a hierarchical data-structure to a set of Key/Value pairs..." );
	    getAllTerritories()
	    .stream()
	    .flatMap( t -> t.getGeographicExtents()
	        .stream()
	        .map( ge -> new SimpleEntry<>( t.getTerritoryName(), ge ) )
	    )
//	    .map( e -> String.format( "%-30s : %s",e.getKey(),e.getValue() ) )
	    .map( e -> e.toString() )
	    .forEach( System.out::println );
		
	}
	
	private static Set<SalesTerritory> getAllTerritories(){
		
		return Collections.unmodifiableSet(ApplicationDataRepository.getSaleTerritories());
	}

}

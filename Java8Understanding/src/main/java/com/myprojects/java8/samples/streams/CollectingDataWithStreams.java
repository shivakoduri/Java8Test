package com.myprojects.java8.samples.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.myproject.java8.samples.model.Currency;
import com.myproject.java8.samples.model.Transaction;
import com.myprojects.java8.samples.data.LoadData;

public class CollectingDataWithStreams {
	
	
	public void runExamples(){
		
		//Grouping transactions by currency
		groupingTransactions();
		
	}
	
	public void groupingTransactions(){
		
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
				LoadData.getTransactions().stream().collect(Collectors.groupingBy(Transaction::getCurrency));
//		the argument passed to the collect method is an implementation of the Collector
//		interface, which is a recipe for how to build a summary of the elements in the Stream.
	}

}

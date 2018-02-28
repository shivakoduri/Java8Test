package com.myprojects.java8.samples.data;

import java.util.Arrays;
import java.util.List;

import com.myproject.java8.samples.model.Currency;
import com.myproject.java8.samples.model.Transaction;


public class LoadData {
	
	
	public static List<Transaction> getTransactions(){
		List<Transaction> transactions = Arrays.asList( new Transaction(Currency.EUR, 1500.0),
		        new Transaction(Currency.USD, 2300.0),
		        new Transaction(Currency.GBP, 9900.0),
		        new Transaction(Currency.EUR, 1100.0),
		        new Transaction(Currency.JPY, 7800.0),
		        new Transaction(Currency.CHF, 6700.0),
		        new Transaction(Currency.EUR, 5600.0),
		        new Transaction(Currency.USD, 4500.0),
		        new Transaction(Currency.CHF, 3400.0),
		        new Transaction(Currency.GBP, 3200.0),
		        new Transaction(Currency.USD, 4600.0),
		        new Transaction(Currency.JPY, 5700.0),
		        new Transaction(Currency.EUR, 6800.0) );
		
		return transactions;
	}


}

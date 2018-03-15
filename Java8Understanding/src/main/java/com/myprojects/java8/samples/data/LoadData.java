package com.myprojects.java8.samples.data;

import com.myprojects.java8.model.Currency;
import com.myprojects.java8.model.Transaction_;

import java.util.Arrays;
import java.util.List;


public class LoadData {
	
	
	public static List<Transaction_> getTransactions(){
		List<Transaction_> transactions = Arrays.asList( new Transaction_(Currency.EUR, 1500.0),
		        new Transaction_(Currency.USD, 2300.0),
		        new Transaction_(Currency.GBP, 9900.0),
		        new Transaction_(Currency.EUR, 1100.0),
		        new Transaction_(Currency.JPY, 7800.0),
		        new Transaction_(Currency.CHF, 6700.0),
		        new Transaction_(Currency.EUR, 5600.0),
		        new Transaction_(Currency.USD, 4500.0),
		        new Transaction_(Currency.CHF, 3400.0),
		        new Transaction_(Currency.GBP, 3200.0),
		        new Transaction_(Currency.USD, 4600.0),
		        new Transaction_(Currency.JPY, 5700.0),
		        new Transaction_(Currency.EUR, 6800.0) );
		
		return transactions;
	}


}

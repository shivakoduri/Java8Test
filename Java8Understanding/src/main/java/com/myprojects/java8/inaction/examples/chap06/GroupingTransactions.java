package com.myprojects.java8.inaction.examples.chap06;

import com.myprojects.java8.model.Currency;
import com.myprojects.java8.model.Transaction_;
import com.myprojects.java8.samples.data.LoadData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingTransactions {

    public static void main(String... args){

        groupImeratively();
        groupFunctionally();

    }

    private static void groupImeratively(){
        Map<Currency, List<Transaction_>> transactionByCurrencies = new HashMap<>();
        for(Transaction_ transaction : LoadData.getTransactions()){
            Currency currency = transaction.getCurrency();
            List<Transaction_> transactionsForCurrency = transactionByCurrencies.get(currency);
            if(transactionsForCurrency == null){
                transactionsForCurrency = new ArrayList<>();
                transactionByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
        System.out.println(transactionByCurrencies);
    }

    private static void groupFunctionally(){
        Map<Currency, List<Transaction_>> transactionByCurrencies = LoadData.getTransactions().stream().collect(Collectors.groupingBy(Transaction_::getCurrency));
        System.out.println(transactionByCurrencies);
    }
}

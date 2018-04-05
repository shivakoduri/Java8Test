package com.myprojects.java8.inaction.examples.chap05;

import com.myprojects.java8.model.Trader;
import com.myprojects.java8.model.Transaction;
import com.myprojects.java8.samples.data.ApplicationDataRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractise {

    public static void main(String... args){

        //Query 1: Find all transactions for the year 2011 and sort them by value(small to high)
        List<Transaction> tr2011 =
                ApplicationDataRepository.getTransactions().stream()
                                                           .filter(transaction -> transaction.getYear() == 2011)
                                                           .sorted(Comparator.comparing(Transaction::getValue))
                                                           .collect(Collectors.toList());
        System.out.println(tr2011);

        //Query 2: What are all the unique cities where traders work?
        List<String> cities =
                ApplicationDataRepository.getTransactions().stream()
                                                           .map(transaction -> transaction.getTrader().getCity())
                                                           .distinct()
                                                           .collect(Collectors.toList());
        System.out.println(cities);

        //Query 3: Return a string of all trader names sorted alphabetically.
        String traderNames =
                ApplicationDataRepository.getTransactions().stream()
                                                           .map(transaction -> transaction.getTrader().getName())
                                                           .distinct()
                                                           .sorted()
                                                           .reduce("", (n1,n2) -> n1 + n2);
        System.out.println(traderNames);

        //Query 4: Find all traders from Cambridge and sort them by name
        List<Trader> traders =
                ApplicationDataRepository.getTransactions().stream()
                                                           .map(Transaction::getTrader)
                                                           .filter(trader -> trader.getCity().equals("Cambridge"))
                                                           .distinct()
                                                           .sorted(Comparator.comparing(Trader::getName))
                                                           .collect(Collectors.toList());
        System.out.println(traders);

        //Query 5: Are there any trader based in Milan?
        boolean milanBased =
                ApplicationDataRepository.getTransactions().stream()
                                                           .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        //Query 6: Update all transactions so that the traders from Milan are set to Cambridge
        ApplicationDataRepository.getTransactions().stream()
                                                   .map(Transaction::getTrader)
                                                   .filter(trader -> trader.getCity().equals("Milan"))
                                                   .forEach(trader -> trader.setCity("Cambridge"));

        //Query 7: What's the highest value in all transactions?
        int highestValue =
                ApplicationDataRepository.getTransactions().stream()
                                                           .map(Transaction::getValue)
                                                           .reduce(0, Integer::max);
        System.out.println(highestValue);







    }
}

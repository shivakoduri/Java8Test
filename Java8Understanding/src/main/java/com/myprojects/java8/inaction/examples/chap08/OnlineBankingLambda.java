package com.myprojects.java8.inaction.examples.chap08;

import java.util.function.Consumer;

public class OnlineBankingLambda {

    public static void main(String... args){
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello! "));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomeHappy){
        Customer c = Database.getCustomerWithId(id);
        makeCustomeHappy.accept(c);
    }

    static private class Customer{}

    static private class Database{
        static Customer getCustomerWithId(int id){
            return new Customer();
        }
    }

}

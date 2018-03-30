package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Item;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class SupplierDemo {

    public static void main(String... args){
        //BooleanSupplier
        booleanSupplierExample();

        //IntSupplier
        intSupplierExample();

        //LongSupplier
        longSupplier();

        //DoubleSupplier
        doubleSupplier();
    }

    private static void doubleSupplier(){
        Item item = new Item(true, 123);
        DoubleSupplier ds = item::getVal;
        System.out.println("Double Value:" + ds.getAsDouble());

    }

    private static void longSupplier(){
        Item item = new Item(true, 123);
        LongSupplier ls = item::getVal;
        System.out.println("Long Val:" + ls.getAsLong());
    }

    private static void intSupplierExample(){
        Item item = new Item(true, 123);
        IntSupplier is = item::getVal;
        System.out.println("Int Value:"+ is.getAsInt());
    }

    private static void booleanSupplierExample(){
        Item item = new Item(true, 123);
        BooleanSupplier bs = item::isStatus;
        System.out.println(bs.getAsBoolean());
    }
}

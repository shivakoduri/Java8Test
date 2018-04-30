package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Item;
import com.myprojects.java8.forums.examples.model.SupplierItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class SupplierDemo {

    public static void main(String... args) {
        //BooleanSupplier
        booleanSupplierExample();

        //IntSupplier
        intSupplierExample();

        //LongSupplier
        longSupplier();

        //DoubleSupplier
        doubleSupplier();

        //Supplier to return Object of a Class
        supplierReturnObject();

        //Supplier to Fetch Method of an Object
        supplierFetchMethod();

        //Supplier as an argument with Stream API
        supplierWithStream();

    }

    private static void supplierWithStream() {
        List<SupplierItem> list = new ArrayList<>();
        list.add(new SupplierItem("AA"));
        list.add(new SupplierItem("BB"));
        list.add(new SupplierItem("CC"));

        Stream<String> names = list.stream().map(SupplierItem::getName);
        names.forEach(n -> System.out.println(n));

    }

    private static void supplierFetchMethod() {
        Supplier<String> supplier = SupplierItem::getStaticVal;
        String val = supplier.get();
        System.out.println("Calling Method:" + val);
    }

    private static void supplierReturnObject() {
        Supplier<SupplierItem> supplier = SupplierItem::new;
        SupplierItem item = supplier.get();
        System.out.println(item.getMsg());
    }

    private static void doubleSupplier() {
        Item item = new Item(true, 123);
        DoubleSupplier ds = item::getVal;
        System.out.println("Double Value:" + ds.getAsDouble());

    }

    private static void longSupplier() {
        Item item = new Item(true, 123);
        LongSupplier ls = item::getVal;
        System.out.println("Long Val:" + ls.getAsLong());
    }

    private static void intSupplierExample() {
        Item item = new Item(true, 123);
        IntSupplier is = item::getVal;
        System.out.println("Int Value:" + is.getAsInt());
    }

    private static void booleanSupplierExample() {
        Item item = new Item(true, 123);
        BooleanSupplier bs = item::isStatus;
        System.out.println(bs.getAsBoolean());
    }
}

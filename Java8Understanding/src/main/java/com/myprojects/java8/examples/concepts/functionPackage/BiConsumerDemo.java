package com.myprojects.java8.examples.concepts.functionPackage;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class BiConsumerDemo {

   public static void main(String... args){
       BiConsumer<String, String> biConsumer = (x,y) ->{
           System.out.println(x);
           System.out.println(y);
       };
       biConsumer.accept("BiConsumer","Example");
   }


}

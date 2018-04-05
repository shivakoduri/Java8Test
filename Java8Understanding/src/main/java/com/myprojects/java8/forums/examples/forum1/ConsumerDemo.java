package com.myprojects.java8.forums.examples.forum1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class ConsumerDemo {

    public static void main(String... args){

        //BiConsumer
        biConsumerDemo();

        //BiFunction
        biFunctionDemo();

        //BiPredicate
        biPredicate();

    }

    private static void biPredicate(){
        //BiPredicate functional method is test(Object, Object)

        BiPredicate<Integer, String> condition = (i,s)->i>20&&s.startsWith("R");
        System.out.println(condition.test(10,"Ram"));
        System.out.println(condition.test(30,"Shyam"));
        System.out.println(condition.test(30,"Ram"));
    }

    private static void biFunctionDemo(){
        //BiFunction has function method as apply(T t, U u) which accepts two argument

        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:"+ (num1+num2);
        System.out.println(biFunction.apply(20,25));
    }

    private static void biConsumerDemo(){
        //BiConsumer functional method is accept(Object, Object)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        BiConsumer<Integer, String> biConsumer = (key, value) -> System.out.println("Key:"+key+"Value:"+value);
        map.forEach(biConsumer);
    }
}

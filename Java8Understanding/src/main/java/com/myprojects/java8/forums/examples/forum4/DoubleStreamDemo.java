package com.myprojects.java8.forums.examples.forum4;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class DoubleStreamDemo {

    public static void main(String... args){
        //Java8 Streams - DoubleStream methods examples

        allMatch();
        anyMatch();
        average();
        boxed();
        builder();
        collect();
        concat();
        count();
        distinct();
    }

    private static void distinct(){
        DoubleStream ds = DoubleStream.of(1.2, 1.3, 1.2, 1.4, 1.3, 1.4);
        DoubleStream ds2 = ds.distinct();
        ds2.forEach(System.out::println);
    }

    private static void count(){
        DoubleStream ds = DoubleStream.of(1.2, -1.3, 1.4, -1.5, -1.7);
        long count = ds.count();
        System.out.println(count);
    }

    private static void concat(){
        //static DoubleStream concat(DoubleStream a,
        //                           DoubleStream b)

        DoubleStream ds1 = DoubleStream.of(1.2, 1.3, 1.4);
        DoubleStream ds2 = DoubleStream.of(1.5, 1.6, 1.7);
        DoubleStream ds = DoubleStream.concat(ds1, ds2);
        System.out.println(Arrays.toString(ds.toArray()));
    }

    private static void collect(){
        //<R> R collect(Supplier<R> supplier,
        //              ObjDoubleConsumer<R> accumulator,
        //              BiConsumer<R,R> combiner)

        DoubleStream ds = DoubleStream.of(1.01, 1.2, 1.4, 1.6, 2.4, 2.7);
        //collect product of rounded doubles
        long result = ds.parallel()
                        .collect(
                                ()->new long[]{1},
                                (longs, value) -> longs[0]= Math.multiplyExact(longs[0], Math.round(value)),
                                (longs, longs2) -> longs[0]= Math.multiplyExact(longs[0], longs2[0]))[0];
        System.out.println(result);
    }

    private static void builder(){
        //static DoubleStream.Builder builder()
        DoubleStream.Builder builder = DoubleStream.builder();
        DoubleStream doubleStream = builder.add(1.1).add(1.5).add(2.0).build();
        doubleStream.forEach(System.out::println);
    }

    private static void boxed(){
        //Stream<Double> boxed()

        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.4, 1.5, 1.6);
        Stream<Double> boxed = doubleStream.boxed();

        Stream<String> stream = Stream.of("a","b");
        Stream<Object> concat = Stream.concat(boxed, stream);
        concat.forEach(System.out::println);

    }

    private static void average(){
        //OptionalDouble average()

        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.4, 1.5, 1.6);
        double d = doubleStream.average().orElse(-100);
        System.out.println(d);

        OptionalDouble average = DoubleStream.empty().average();
        System.out.println(average.isPresent());
        if(average.isPresent()){
            System.out.println(average.getAsDouble());
        }

        //If any element is a NaN or the sum is at any point a NaN then the average will be NaN.
//        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, Double.NaN);
//        OptionalDouble avg = ds.average();
//        if(avg.isPresent()){
//            System.out.println(avg.getAsDouble());
//        }

//        DoubleStream ds1 = DoubleStream.of(1.0, Double.MAX_VALUE, Double.MIN_VALUE);
//        OptionalDouble avg1 = ds.average();
//        if(avg1.isPresent()){
//            System.out.println(avg1.getAsDouble());
//        }

        DoubleStream ds2 = DoubleStream.of(1.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        OptionalDouble ag1 = ds2.average();
        if(ag1.isPresent()){
            System.out.println(ag1.getAsDouble());
        }
    }

    private static void anyMatch(){
        //boolean anyMatch(DoublePredicate predicate)
        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.0, 1.5, 1.6);
        boolean b = doubleStream.anyMatch(d->d>1.4 && d<1.5);
        System.out.println(b);

        DoubleStream doubleStream1 = DoubleStream.of(1.2, 1.3, 1.0, 1.5, 1.6);
        boolean b2 = doubleStream1.anyMatch(d->d%1 == 0);
        System.out.println(b2);

        DoubleStream doubleStream2 = DoubleStream.empty();
        boolean b3 = doubleStream2.anyMatch(d->true);
        System.out.println(b3);
    }

    private static void allMatch(){
        //boolean allMatch(DoublePredicate predicate)
        //This terminal-short-circuiting operation returns whether all elements match the provided predicate criteria.
        // It returns 'false' on finding the first mismatch hence short-circuiting the operation.

        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.4, 1.5, 1.6);
        boolean b = doubleStream.allMatch(value -> value < 2.0d);
        System.out.println(b);

        DoubleStream doubleStream1 = DoubleStream.of(1.2, 1.3, 1.4, 1.5, 2.0001);
        boolean b2 = doubleStream1.allMatch(value -> value <=2.0d);
        System.out.println(b2);

        DoubleStream doubleStream2 = DoubleStream.empty();
        boolean b3 = doubleStream2.allMatch(d->false);
        System.out.println(b3);

    }
}

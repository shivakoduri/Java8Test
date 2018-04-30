package com.myprojects.java8.forums.examples.forum4;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;

public class DoubleStreamDemo {

    public static void main(String... args) {
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
        empty();
        filter();
        findAny();
        findFirst();
        flatMap();
        forEach();
        forEachOrdered();
        generate();
        iterate();
        iterator();
        limit();
        map();
        mapToInt();
        mapTOLong();
        mapToObject();
        max();
        min();
        noneMatch();
        of();
        parallel();
        peek();
        reduce();
        sequential();
        skip();
        sorted();
        splitter();
        sum();
        summaraStatistics();
        toArray();
    }

    private static void toArray() {
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        double[] doubles = ds.toArray();
        System.out.println(Arrays.toString(doubles));
    }

    private static void summaraStatistics() {
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        DoubleSummaryStatistics s = ds.summaryStatistics();
        System.out.println(s);
    }

    private static void sum() {
        //sum
        double sum = DoubleStream.of(1.1, 1.5, 2.5, 5.4).sum();
        System.out.println(sum);

        //equivalaentReduce
        double sum1 = DoubleStream.of(1.1, 1.5, 2.5, 5.4)
                .reduce(0, Double::sum);
        System.out.println(sum1);

    }

    private static void splitter() {
        Spliterator.OfDouble s1 = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0)
                .spliterator();
        Spliterator.OfDouble s2 = s1.trySplit();

        DoubleStream stream1 = StreamSupport.doubleStream(s1, true);
        DoubleStream stream2 = StreamSupport.doubleStream(s2, true);

        System.out.println("-- first half --");
        double sum = stream1.peek(System.out::println).sum();
        System.out.println("sum: " + sum);

        System.out.println("-- second half --");
        sum = stream2.peek(System.out::println).sum();
        System.out.println("sum: " + sum);
    }

    private static void sorted() {
        DoubleStream.of(3.0, 1.2, 2.0, 1.4, 3.0)
                .sorted()
                .forEach(System.out::println);
    }

    private static void skip() {
        System.out.println("-- sequential --");
        DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0)
                .skip(2)
                .forEach(System.out::println);

        System.out.println("-- parallel --");
        DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0)
                .parallel()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("-- unordered parallel --");
        DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0)
                .unordered()
                .parallel()
                .skip(2)
                .forEach(System.out::println);
    }

    private static void sequential() {
        System.out.println("-- sequential --");
        DoubleStream ds2 = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds2.sequential()//redundant as stream was already sequential by default
                .forEach(System.out::println);

        System.out.println("-- parallel --");
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds.parallel()
                .forEach(System.out::println);
    }

    private static void reduce() {
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        double d = ds.reduce(1, (a, b) -> a * b);
        System.out.println(d);
    }

    private static void peek() {
        //DoubleStream peek(DoubleConsumer action)
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds.peek(d -> System.out.println("peek 1: " + d))
                .filter(d -> d > 1.5)
                .peek(d -> System.out.println("peek 2: " + d))
                .map(d -> d + 10)
                .forEach(System.out::println);
    }

    private static void parallel() {
        //DoubleStream parallel()
        System.out.println("-- parallel --");
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds.parallel()
                .forEach(System.out::println);

        System.out.println("-- sequential --");
        DoubleStream ds2 = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds2.forEach(System.out::println);
    }

    private static void of() {
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds.forEach(System.out::println);
    }

    private static void noneMatch() {
        //boolean noneMatch(DoublePredicate predicate)
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        boolean b = ds.noneMatch(d -> d == 2.5);
        System.out.println(b);

    }

    private static void min() {
        //OptionalDouble min()
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        double v = ds.min()
                .orElse(-1);
        System.out.println(v);
    }

    private static void max() {
        //OptionalDouble max()
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        OptionalDouble od = ds.max();
        if (od.isPresent()) {
            System.out.println(od.getAsDouble());
        }
    }

    private static void mapToObject() {
        //<U> Stream<U> mapToObj(DoubleFunction<? extends U> mapper)
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        Stream<BigDecimal> stream = ds.mapToObj(BigDecimal::valueOf);
        stream.map(bd -> bd.multiply(BigDecimal.TEN)).forEach(System.out::println);
    }

    private static void mapTOLong() {
        //LongStream mapToLong(DoubleToLongFunction mapper)
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        LongStream ls = ds.mapToLong(Math::round);
        ls.forEach(System.out::println);
    }

    private static void mapToInt() {
        //IntStream mapToInt(DoubleToIntFunction mapper)
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        IntStream intStream = ds.mapToInt(Math::getExponent);
        intStream.forEach(System.out::println);
    }

    private static void map() {
        //DoubleStream map(DoubleUnaryOperator mapper)
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        DoubleStream ds2 = ds.filter(d -> d > 2).map(d -> d + 2.5);
        ds2.forEach(System.out::println);

    }

    private static void limit() {
        //DoubleStream limit(long maxSize)
        System.out.println("--Sequential--");
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds.limit(3).forEach(System.out::println);

        System.out.println("--Parallel--");
        DoubleStream ds2 = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds2.parallel().limit(3).forEach(System.out::println);
    }

    private static void iterator() {
        //PrimitiveIterator.OfDouble iterator()

        DoubleStream ds = DoubleStream.of(1.2, 1.2, 2.0, 2.4, 3.0);
        PrimitiveIterator.OfDouble itr = ds.iterator();
        while (itr.hasNext()) {
            Double d = itr.nextDouble();
            System.out.println(d);
        }
    }

    private static void iterate() {
        //static DoubleStream iterate(double seed,
        //                            DoubleUnaryOperator f)

        DoubleStream.iterate(1, d -> d + 0.5).limit(5).forEach(System.out::println);
    }

    private static void generate() {
        //static DoubleStream generate(DoubleSupplier s)
        DoubleStream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    private static void forEachOrdered() {
        //void forEachOrdered(DoubleConsumer action)

        System.out.println("--Sequential--");
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds.forEachOrdered(System.out::println);

        System.out.println("--Parallel--");
        DoubleStream ds2 = DoubleStream.of(1.0, 1.2, 2.4, 3.0);
        ds2.parallel().forEachOrdered(System.out::println);

    }

    private static void forEach() {
        System.out.println("--Sequential--");
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds.forEach(System.out::println);

        System.out.println("--Parallel--");
        DoubleStream ds2 = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        ds2.parallel().forEach(System.out::println);
    }

    private static void flatMap() {
        //DoubleStream flatMap(DoubleFunction<? extends DoubleStream> mapper)

        DoubleStream ds = DoubleStream.of(1.1, 2.4, 3.2, 4.3);
        double[] doubles = ds.flatMap(value -> DoubleStream.of(value * 0.5, value)).toArray();

    }

    private static void findFirst() {
        //OptionalDouble findFirst()
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        double v = ds.findFirst().orElseThrow(IllegalArgumentException::new);
        System.out.println(v);

    }

    private static void findAny() {
        System.out.println("--Sequential--");
        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        OptionalDouble any = ds.findAny();
        System.out.println(any.orElse(-1));

        System.out.println("--Parallel--");
        DoubleStream ds2 = DoubleStream.of(1.0, 1.2, 2.4, 3.0);
        OptionalDouble any2 = ds2.parallel().findAny();
        System.out.println(any2.orElse(-1));
    }

    private static void filter() {
        //DoubleStream filter(DoublePredicate predicate)

        DoubleStream ds = DoubleStream.of(1.0, 1.2, 2.0, 2.4, 3.0);
        double[] doubles = ds.filter(d -> d % 1 == 0).toArray();
        System.out.println(Arrays.toString(doubles));
    }

    private static void empty() {
        DoubleStream ds = DoubleStream.empty();
        System.out.println(Arrays.toString(ds.toArray()));
    }

    private static void distinct() {
        DoubleStream ds = DoubleStream.of(1.2, 1.3, 1.2, 1.4, 1.3, 1.4);
        DoubleStream ds2 = ds.distinct();
        ds2.forEach(System.out::println);
    }

    private static void count() {
        DoubleStream ds = DoubleStream.of(1.2, -1.3, 1.4, -1.5, -1.7);
        long count = ds.count();
        System.out.println(count);
    }

    private static void concat() {
        //static DoubleStream concat(DoubleStream a,
        //                           DoubleStream b)

        DoubleStream ds1 = DoubleStream.of(1.2, 1.3, 1.4);
        DoubleStream ds2 = DoubleStream.of(1.5, 1.6, 1.7);
        DoubleStream ds = DoubleStream.concat(ds1, ds2);
        System.out.println(Arrays.toString(ds.toArray()));
    }

    private static void collect() {
        //<R> R collect(Supplier<R> supplier,
        //              ObjDoubleConsumer<R> accumulator,
        //              BiConsumer<R,R> combiner)

        DoubleStream ds = DoubleStream.of(1.01, 1.2, 1.4, 1.6, 2.4, 2.7);
        //collect product of rounded doubles
        long result = ds.parallel()
                .collect(
                        () -> new long[]{1},
                        (longs, value) -> longs[0] = Math.multiplyExact(longs[0], Math.round(value)),
                        (longs, longs2) -> longs[0] = Math.multiplyExact(longs[0], longs2[0]))[0];
        System.out.println(result);
    }

    private static void builder() {
        //static DoubleStream.Builder builder()
        DoubleStream.Builder builder = DoubleStream.builder();
        DoubleStream doubleStream = builder.add(1.1).add(1.5).add(2.0).build();
        doubleStream.forEach(System.out::println);
    }

    private static void boxed() {
        //Stream<Double> boxed()

        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.4, 1.5, 1.6);
        Stream<Double> boxed = doubleStream.boxed();

        Stream<String> stream = Stream.of("a", "b");
        Stream<Object> concat = Stream.concat(boxed, stream);
        concat.forEach(System.out::println);

    }

    private static void average() {
        //OptionalDouble average()

        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.4, 1.5, 1.6);
        double d = doubleStream.average().orElse(-100);
        System.out.println(d);

        OptionalDouble average = DoubleStream.empty().average();
        System.out.println(average.isPresent());
        if (average.isPresent()) {
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
        if (ag1.isPresent()) {
            System.out.println(ag1.getAsDouble());
        }
    }

    private static void anyMatch() {
        //boolean anyMatch(DoublePredicate predicate)
        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.0, 1.5, 1.6);
        boolean b = doubleStream.anyMatch(d -> d > 1.4 && d < 1.5);
        System.out.println(b);

        DoubleStream doubleStream1 = DoubleStream.of(1.2, 1.3, 1.0, 1.5, 1.6);
        boolean b2 = doubleStream1.anyMatch(d -> d % 1 == 0);
        System.out.println(b2);

        DoubleStream doubleStream2 = DoubleStream.empty();
        boolean b3 = doubleStream2.anyMatch(d -> true);
        System.out.println(b3);
    }

    private static void allMatch() {
        //boolean allMatch(DoublePredicate predicate)
        //This terminal-short-circuiting operation returns whether all elements match the provided predicate criteria.
        // It returns 'false' on finding the first mismatch hence short-circuiting the operation.

        DoubleStream doubleStream = DoubleStream.of(1.2, 1.3, 1.4, 1.5, 1.6);
        boolean b = doubleStream.allMatch(value -> value < 2.0d);
        System.out.println(b);

        DoubleStream doubleStream1 = DoubleStream.of(1.2, 1.3, 1.4, 1.5, 2.0001);
        boolean b2 = doubleStream1.allMatch(value -> value <= 2.0d);
        System.out.println(b2);

        DoubleStream doubleStream2 = DoubleStream.empty();
        boolean b3 = doubleStream2.allMatch(d -> false);
        System.out.println(b3);

    }
}

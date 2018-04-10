package com.myprojects.java8.forums.examples.forum4;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsDemo {

    public static void main(String... args){
        //Collectors methods

        averagingDouble();
        averagingInt();
        averagingLong();
        collectingAndThen();
        counting();
        filtering(); //Java 9 has filtering method
        flatMapping(); //Java 9 has flatMapping method
        groupingBy();
        groupingByConcurrent();
        joining();
        mapping();
        maxBy();
        minBy();
        partiontingBy();
        reducing();
        summarizingDouble();
        summarizingInt();
        summarizingLong();
        summingDouble();
        summingInt();
        summingLong();
        toCollection();
        toConcurrentMap();
        toList();
        toMap();
        toSet();
        toUnmodifiableList();  //Java 10
        toUnmodifiableMap();   //Java 10
        toUnmodifiableSet();   //Java 10
    }

    private static void toUnmodifiableSet(){
//        Set<Integer> set = IntStream.range(1, 5)
//                .boxed()
//                .collect(Collectors.toUnmodifiableSet());
//        System.out.println(set);
//        System.out.println(set.getClass().getTypeName());
    }

    private  static  void toUnmodifiableMap(){
        //public static <T,K,U> Collector<T,?,Map<K,U>> toUnmodifiableMap(Function<? super T,? extends K> keyMapper,
        //                                                                Function<? super T,? extends U> valueMapper)

//        Map<Integer, Double> map =
//                IntStream.range(1, 5)
//                        .boxed()
//                        .collect(Collectors.toUnmodifiableMap(
//                                i -> i,
//                                i -> Math.pow(i, 3))
//                        );
//        System.out.println(map);
//        System.out.println(map.getClass().getTypeName());

        //public static <T,K,U> Collector<T,?,Map<K,U>> toUnmodifiableMap(Function<? super T,? extends K> keyMapper,
        //                                                                Function<? super T,? extends U> valueMapper,
        //                                                                BinaryOperator<U> mergeFunction)


//        Map<Integer, List<String>> map =
//                Stream.of("rover", "joyful", "depth", "hunter")
//                        .collect(Collectors.toUnmodifiableMap(
//                                String::length,
//                                List::of,
//                                ToUnmodifiableMapExample2::mergeFunction)
//                        );
//        System.out.println(map);
    }

    private static List<String> mergeFunction(List<String> l1, List<String> l2) {
        List<String> list = new ArrayList<>();
        list.addAll(l1);
        list.addAll(l2);
        return list;
    }

    private static void toUnmodifiableList(){
//        List<Integer> list = IntStream.range(1, 5).boxed().collect(Collectors.toUnmodifiableList());
//        System.out.println(list);
//        System.out.println(list.getClass().getName());
    }

    private static void toSet(){
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        Set<BigDecimal> l = s.collect(Collectors.toSet());
        System.out.println(l);
    }

    private static void toMap(){
        //<T,K,U> Collector<T,?,Map<K,U>> toMap(
        //                                  Function<? super T,? extends K> keyMapper,
        //                                  Function<? super T,? extends U> valueMapper)

        Stream<String> s = Stream.of("apple", "banana", "orange");
        Map<Character, String> m = s.collect(Collectors.toMap(s1 -> s1.charAt(0), s1 ->s1));
        System.out.println(m);


        //<T,K,U> Collector<T,?,Map<K,U>> toMap(
        //                                  Function<? super T,? extends K> keyMapper,
        //                                  Function<? super T,? extends U> valueMapper,
        //                                  BinaryOperator<U> mergeFunction)
//        Stream<String> strm2 = Stream.of("apple", "banana", "apricot", "orange");
//        Map<Character, String> m2 = strm2.collect(Collectors.toMap(s1->s1.charAt(0), s1->s1));
//        System.out.println(m2);


        //<T,K,U,M extends Map<K,U>> Collector<T,?,M> toMap(
        //                                  Function<? super T,? extends K> keyMapper,
        //                                  Function<? super T,? extends U> valueMapper,
        //                                  BinaryOperator<U> mergeFunction,
        //                                  Supplier<M> mapSupplier)
        Stream<String> s3 = Stream.of("apple", "banana", "apricot", "orange", "apple");
        Map<Character, String> m3 = s3.collect(Collectors.toMap(s1 ->s1.charAt(0), s1->s1, (s1, s2)->s1+"|"+s2));
        System.out.println(m3);


        Stream<String> s4 = Stream.of("apple", "banana", "apricot", "orange", "apple");
        LinkedHashMap<Character, String> m4 = s4.collect(Collectors.toMap(s1 -> s1.charAt(0), s1 -> s1, (s1, s2) -> s1 + "|" + s2, LinkedHashMap::new));
        System.out.println(m4);

    }

    private static void toList(){
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        List<BigDecimal> l = s.collect(Collectors.toList());
        System.out.println(l);
    }

    private static void toConcurrentMap(){
        Stream<String> s = Stream.of("apple", "banana", "orange");
        ConcurrentMap<Character, String> m = s.collect(Collectors.toConcurrentMap(s1->s1.charAt(0), String::toUpperCase));
        System.out.println(m);

    }

    private static void toCollection(){
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        LinkedList<BigDecimal> l = s.collect(Collectors.toCollection(LinkedList::new));
        System.out.println(l);
    }

    private static void summingLong(){
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        long l = s.collect(Collectors.summingLong(BigDecimal::longValue));
        System.out.println("sum:"+l);
    }


    private static void summingInt(){
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        int i = s.collect(Collectors.summingInt(BigDecimal::intValue));
        System.out.println("sum:"+i);
    }

    private static void summingDouble(){
        Stream<BigDecimal> s = (Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10)).peek(System.out::println);
        double d = s.collect(Collectors.summingDouble(BigDecimal::doubleValue));
        System.out.println("sum:"+d);
    }

    private static void summarizingLong(){
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        LongSummaryStatistics l = s.collect(Collectors.summarizingLong(BigDecimal::longValue));
        System.out.println(l);
    }

    private static void summarizingInt(){
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        IntSummaryStatistics i = s.collect(Collectors.summarizingInt(BigDecimal::intValue));
        System.out.println(i);
    }

    private static void summarizingDouble(){
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        DoubleSummaryStatistics d = s.collect(Collectors.summarizingDouble(BigDecimal::doubleValue));
        System.out.println(d);
    }

    private static void reducing(){
        Stream<Integer> s = Stream.of(5,10,20,50);
        Integer i = s.collect(Collectors.reducing((integer1, integer2) -> integer1 - integer2)).orElse(-1);
        System.out.println(i);
    }

    private static void partiontingBy(){
        Map<Boolean, List<Long>> m = IntStream.range(1,10).mapToObj(Long::new).collect(Collectors.partitioningBy(i->i%2==0));
        System.out.println(m);
    }

    private static void minBy(){
        Stream<String> s = Stream.of("apple", "banana", "orange");
        Optional<String> o = s.collect(Collectors.minBy(String::compareTo));
        System.out.println(o.get());
    }

    private static void maxBy(){
        Stream<String> s = Stream.of("apple", "banana", "orange");
        Optional<String> o = s.collect(Collectors.maxBy(String::compareTo));
        System.out.println(o.get());
    }

    private static void mapping(){
        Stream<String> s = Stream.of("apple", "banana", "orange");
        List<String> list = s.collect(Collectors.mapping(s1 -> s1.substring(0,2), Collectors.toList()));
        System.out.println(list);
    }

    private static void joining(){
        Stream<String> s = Stream.of("what", "so", "ever");
        String str = s.collect(Collectors.joining());
        System.out.println("joining():" + str);

        str = Stream.of("what", "so", "ever").collect(Collectors.joining("|"));
        System.out.println("joining(CharSequence delimiter):" + str );

        str = Stream.of("what", "so", "ever").collect(Collectors.joining("|", "-", "!"));
        System.out.println("joining(CharSequence delimiter,CharSequence prefix,CharSequence suffix):" + str);
    }


    private static void groupingByConcurrent(){
        //This examples shows how to use method groupingByConcurrent(classifier) to collect stream element to a ConcurrentMap.
        // The keys of the map are populated per provided classifier function returned values.

        Stream<String> s = Stream.of("apple", "banana", "orange");
        Map<Integer, List<String>> map = s.collect(Collectors.groupingByConcurrent(String::length));
        System.out.println("map:" + map);
    }

    private static void groupingBy(){
        Stream<String> s = Stream.of("apple", "banana", "orange");
        Map<Integer, List<String>> map = s.collect(Collectors.groupingBy(String::length));
        System.out.println("map:" + map);
    }

    private static void flatMapping(){
//        List<Integer> list = Stream.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8))
//                .collect(
//                        Collectors.flatMapping(
//                                l -> l.stream()
//                                        .filter(i -> i % 2 == 0),
//                                Collectors.toList()
//                        )
//                );
    }

    private static void filtering(){
        List<Integer> list = IntStream.of(2,4,6,8,10,12).boxed().filter(i->i%4 ==0).collect(Collectors.toList());
//        List<Integer> list = IntStream.of(2,4,6,8,10,12).boxed().collect(Collectors.filtering(i->i%4==0, Collectors.toList()));  //Collectors.filtering Java 9
        System.out.println("list:" + list);
    }

    private static void counting(){
        //The method Collectors#counting collects the counts of the stream elements.

        Stream<String> s = Stream.of("apple", "banana", "orange");
        Long c = s.collect(Collectors.counting());
        System.out.println("count:"+c);
    }

    private static void collectingAndThen(){
        //The method Collectors#collectingAndThen collects each element per provided downStream collector and
        // converts the type R (which returned from the downstream collector) to a final resultant type RR.

        Stream<String> s = Stream.of("apple", "banana", "orange");
        List<String> synchronizedList = s.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::synchronizedList));
        System.out.println(synchronizedList);
    }

    private static void averagingLong(){
        //The method Collectors#averagingLong converts each stream elements to long per user provided
        // mapper function and returns the arithmetic mean of those long values.
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        Double d = s.collect(Collectors.averagingLong(BigDecimal::longValue));
        System.out.println("average:"+ d);
    }

    private static void averagingInt(){
        //The method Collectors#averagingInt converts each stream elements to int per user
        // provided mapper function and returns the arithmetic mean of those integers.
        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        Double d = s.collect(Collectors.averagingInt(BigDecimal::intValue));
        System.out.println("average:" + d);
    }

    private static void averagingDouble(){
        // The method Collectors#averagingDouble converts the stream elements to primitive double per user provided mapper
        //function and returns the arithmetic mean of those doubles.

        Stream<BigDecimal> s = Stream.iterate(BigDecimal.ONE, bigDecimal -> bigDecimal.add(BigDecimal.ONE)).limit(10).peek(System.out::println);
        Double d = s.collect(Collectors.averagingDouble(BigDecimal::doubleValue));
        System.out.println("average:" + d);

    }
}

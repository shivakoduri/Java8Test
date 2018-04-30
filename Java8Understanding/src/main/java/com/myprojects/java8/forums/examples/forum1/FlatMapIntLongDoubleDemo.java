package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.DoubleDemoPerson;
import com.myprojects.java8.forums.examples.model.IntDemoPerson;
import com.myprojects.java8.forums.examples.model.LongDemoPerson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FlatMapIntLongDoubleDemo {

    public static void main(String... args) {

        //flatMapToInt
        flatMapToIntDemo();

        //flatMapToLong
        flatMapToLongDemo();

        //flatMapToDouble
        flatMapToDouble();
    }

    private static void flatMapToDouble() {
        double[][] data = {{1.5, 2.4}, {3.2, 4.4}, {5.2, 6.8}};
        DoubleStream ds1 = Arrays.stream(data).flatMapToDouble(row -> Arrays.stream(row));
        System.out.println(ds1.average().getAsDouble());

        double[] d1 = {60.5, 58.9, 62.5};
        DoubleDemoPerson p1 = new DoubleDemoPerson("Ram", d1);
        double[] d2 = {70.5, 65.3, 67.4};
        DoubleDemoPerson p2 = new DoubleDemoPerson("Shyam", d2);
        List<DoubleDemoPerson> list = Arrays.asList(p1, p2);
        DoubleStream ds2 = list.stream().flatMapToDouble(row -> Arrays.stream(row.getWeightsInAYear()));
        System.out.println(ds2.min().getAsDouble());
    }

    private static void flatMapToLongDemo() {
        long[][] data = {{1L, 2L}, {3L, 4L}, {5L, 6L}};
        LongStream ls1 = Arrays.stream(data).flatMapToLong(row -> Arrays.stream(row));
        System.out.println(ls1.sum());

        long[] l1 = {41, 81, 91};
        LongDemoPerson p1 = new LongDemoPerson("Ram", l1);
        long[] l2 = {21, 71, 81};
        LongDemoPerson p2 = new LongDemoPerson("Shyam", l2);
        List<LongDemoPerson> list = Arrays.asList(p1, p2);

        LongStream ls2 = list.stream().flatMapToLong(row -> Arrays.stream(row.getLuckNum()));
        System.out.println(ls2.min().getAsLong());
    }

    private static void flatMapToIntDemo() {
        //used for primitive int data type. It returns IntStream.
        int[][] data = {{1, 2}, {3, 4}, {5, 6}};
        IntStream is1 = Arrays.stream(data).flatMapToInt(row -> Arrays.stream(row));
        System.out.println(is1.sum());

        int[] l1 = {4, 8, 9};
        IntDemoPerson p1 = new IntDemoPerson("Ram", l1);
        int[] l2 = {2, 7, 8};
        IntDemoPerson p2 = new IntDemoPerson("Shyam", l2);
        List<IntDemoPerson> list = Arrays.asList(p1, p2);
        IntStream is2 = list.stream().flatMapToInt(row -> Arrays.stream(row.getLuckyNum()));
        System.out.println(is2.max().getAsInt());
    }
}

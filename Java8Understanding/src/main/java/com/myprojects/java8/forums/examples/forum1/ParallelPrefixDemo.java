package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Floor;

import java.util.Arrays;
import java.util.function.*;

public class ParallelPrefixDemo {

    public static void main(String... args){

        //Arrays.parallelPrefix() with Array of Objects
        parallelPrefixDemo();

        //Arrays.parallelPrefix() with Array of Primitive Data Types
        parallelPrefixDemoWithPrimitiveData();
    }

    private static void parallelPrefixDemoWithPrimitiveData(){
        int[] intNum1 = {3,4,2,5,1,6,3};
        IntBinaryOperator intOpt = (i1, i2) -> i1 * i2;
        System.out.println("parallel prefix for complete array");
        Arrays.parallelPrefix(intNum1, intOpt);
        IntConsumer intCon = i-> System.out.println(i+" ");
        Arrays.stream(intNum1).forEach(intCon);

        System.out.println("\nparallel prefix for array from index 1 to 4");
        int[] intNum2 = {3,4,2,5,1,6,3};
        Arrays.parallelPrefix(intNum2, 1, 4, intOpt);
        Arrays.stream(intNum2).forEach(intCon);

        double[] dbNum1 = {3.2, 4.1, 2.2, 5.4, 1.2, 6.4, 3.2};
        DoubleBinaryOperator dbOpt = (d1, d2) -> d1 + d2;
        System.out.println("parallel prefix for complete array");
        Arrays.parallelPrefix(dbNum1, dbOpt);
        DoubleConsumer dbCon = d -> System.out.println(d + " ");
        Arrays.stream(dbNum1).forEach(dbCon);

        System.out.println("\nparallel prefix for array from index 1 to 4");
        double[] dbNum2 = {3.2, 4.1, 2.2, 5.4, 1.2, 6.4, 3.2};
        Arrays.parallelPrefix(dbNum2, 1, 4, dbOpt);
        Arrays.stream(dbNum2).forEach(dbCon);

    }

    private static void parallelPrefixDemo(){
        BinaryOperator<Floor> opt = (f1, f2) -> new Floor(f1.getLength() + f2.getLength(), f1.getWidth() + f2.getWidth());
        Floor[] floors = Floor.getFloorSizes();

        System.out.println("parallel prefix for complete array");
        Arrays.parallelPrefix(floors, opt);

        Consumer<Floor> print = f-> System.out.println(f.getLength()+", "+f.getWidth());
        Arrays.stream(floors).forEach(print);

        System.out.println("parallel prefix for array from index 1 to 4");
        floors = Floor.getFloorSizes();
        Arrays.parallelPrefix(floors, 1, 4, opt);
        Arrays.stream(floors).forEach(print);

    }
}

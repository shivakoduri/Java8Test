package com.myprojects.java8.forums.examples.forum1;

import java.util.function.*;

public class FunctionDemo {

    public static void main(String... args){

        //Function example
        functionExample();

        //Double Function
        doubleFucntion();

        //DoubleToIntFunction
        doubleToIntFunction();

        //DoubleToLongFunction
        doubleToLongFunction();

        //IntFunction
        intFunctionExample();

        //IntToDoubleFunction
        intToDoubleFunctioinExample();

        //IntToLongFunction
        intToLongFunctionExample();

        //LongFunction
        longFunctionExample();

        //LongToDoubleFunction
        longToDoubleFunction();

        //LongToIntFunction
        longToIntFunction();

        //ToDoubleBiFunction
        toDoubleBiFunctionExample();

        //ToDoubleFunction
        toDoubleFunctionExample();

        //ToIntBiFunction
        toIntBiFunctionExample();

        //ToIntFunction
        toIntFunctionExample();

        //ToLongBiFunction
        toLongBiFunction();

        //ToLongFunctionExample
        toLongFunctionExample();

    }

    private static void toLongFunctionExample(){
        ToLongFunction<Integer> ob = f1->f1+50;
        System.out.println(ob.applyAsLong(306));
    }

    private  static void toLongBiFunction(){
        ToLongBiFunction<Integer, Integer> ob = (f1, f2)->f1-f2;
        System.out.println(ob.applyAsLong(306, 405));
    }

    private static void toIntFunctionExample(){
        ToIntFunction<Integer> ob = f->f*123;
        System.out.println(ob.applyAsInt(306));
    }

    private static void toIntBiFunctionExample(){
        ToIntBiFunction<Integer, Integer> ob = (f1, f2)->f1+f2;
        System.out.println(ob.applyAsInt(102, 306));

    }

    private static void toDoubleFunctionExample(){
        ToDoubleFunction<Integer> ob = f1->f1*301;
        System.out.println(ob.applyAsDouble(102));
    }

    private static void toDoubleBiFunctionExample(){
        ToDoubleBiFunction<Integer, Integer> ob = (f1, f2) -> f1+f2;
        System.out.println(ob.applyAsDouble(102, 305));
    }

    private static void longToIntFunction(){
        LongToIntFunction ob = f-> (int)(f*f);
        System.out.println(ob.applyAsInt(43));
    }

    private static void longToDoubleFunction(){
        LongToDoubleFunction ob = f->f*f;
        System.out.println(ob.applyAsDouble(43));
    }

    private static void longFunctionExample(){
        LongFunction<String> ob = f-> String.valueOf(f*f);
        System.out.println(ob.apply(43));
    }

    private static void intToLongFunctionExample(){
        IntToLongFunction ob = f-> f*f;
        System.out.println(ob.applyAsLong(43));
    }

    private static void intToDoubleFunctioinExample(){
        IntToDoubleFunction ob = f-> f*f;
        System.out.println(ob.applyAsDouble(43));
    }

    private static void intFunctionExample(){
        IntFunction ob = f-> f*f;
        System.out.println(ob.apply(43));
    }

    private static void doubleToLongFunction(){
        DoubleToLongFunction ob = f-> new Double(f*4.8).longValue();
        System.out.println(ob.applyAsLong(43.7));
    }

    private static void doubleToIntFunction(){
        DoubleToIntFunction ob = f-> new Double(f*4.8).intValue();
        System.out.println(ob.applyAsInt(43.7));
    }


    private static void doubleFucntion(){
        DoubleFunction<String> df = d->String.valueOf(d*5.3);
        System.out.println(df.apply(43.7));
    }

    private static void functionExample(){
        Function<Integer, String> ob = f1->"Age:"+f1;
        System.out.println(ob.apply(20));
    }

}

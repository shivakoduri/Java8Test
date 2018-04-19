package com.myprojects.java8.examples.concepts.functionPackage;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.function.*;

public class MainDemo {

    public static void main(String... args){

        biConsumerDemo();              // - BiConsumer
        biFunctionDemo();              // - BiFunction
        binaryOperatorDemo();          // - BinaryOperator
        biPredicateDemo();             // - BiPredicate
        booleanSupplierDemo();         // - BooleanSupplier
        consumerDemo();                // - Consumer
        doubleBinaryOperatorDemo();    // - DoubleBinaryOperator
        doubleConsumerDemo();          // - DoubleConsumer
        doubleFunctionDemo();          // - DoubleFunction
        doublePredicateDemo();         // - DoublePredicate
        doubleSupplierDemo();          // - DoubleSupplier
        doubleToIntFunctionDemo();     // - DoubleToIntFunction
        doubleToLongFunctionDemo();    // - DoubleToLongFunction
        doubleUnaryOperatorDemo();     // - DoubleUnaryOperator
        functionDemo();                // - Function
        intBinaryOperatorDemo();       // - IntBinaryOperator
        intConsumerDemo();             // - IntConsumer
        intFunctionDemo();             // - IntFunction
        intPredicateDemo();            // - IntPredicate
        intSupplierDemo();             // - IntSupplier
        intToDoubleFunctionDemo();     // - IntToDoubleFunction
        intToLongFunctionDemo();       // - IntToLongFunction
        intUnaryOperatorDemo();        // - IntUnaryOperator
        longBinaryOperatorDemo();      // - LongBinaryOperator
        longConsumerDemo();            // - LongConsumer
        longFunctionDmeo();            // - LongFunction
        longPredicateDemo();           // - LongPredicate
        longSupplierDemo();            // - LongSupplier
        longToDoubleFunctionDemo();    // - LongToDoubleFunction
        longToIntFunctionDemo();       // - LongToIntFunction
        longUnaryOperatorDemo();       // - LongUnaryOperator
        objDoubleConsumerDemo();       // - ObjDoubleConsumer
        objIntConsumerDemo();          // - ObjIntConsumer
        objLongConsumerDemo();         // - ObjLongConsumer
        predicateDemo();               // - Predicate
        supplierDemo();                // - Supplier
        toDoubleBiFunctionDemo();      // - ToDoubleBiFunction
        toDoubleFunctionDemo();        // - ToDoubleFunction
        toIntBiFunctionDemo();         // - ToIntBiFunction
        toIntFunctionDemo();           // - ToIntFunction
        toLongBiFunctionDemo();        // - ToLongBiFunction
        toLongFunctionDemo();          // - ToLongFunction
        unaryOperatorDemo();           // - UnaryOperator
    }

    private static void unaryOperatorDemo(){
        //UnaryOperator represents an operation on a single operand that produces a result of the same type as its operand.
        // This is a specialization of Function for the case where the operand and result are of the same type.
        //
        //Method
        //UnaryOperator identity
        UnaryOperator<String> i  = (x)-> x.toUpperCase();

        System.out.println(i.apply("UnaryOperator demo"));
    }

    private static void toLongFunctionDemo(){
        //ToLongFunction represents a function that produces a long-valued result. This is the long-producing primitive specialization for Function.
        //
        //Method
        //ToLongFunction applyAsLong
        ToLongFunction<String> i  = (x)-> Long.parseLong(x);
        System.out.println(i.applyAsLong("2"));
    }

    private static void toLongBiFunctionDemo(){
        //ToLongBiFunction represents a function that accepts two arguments and produces a long-valued result.
        // This is the long-producing primitive specialization for BiFunction.
        //
        //Method
        //ToLongBiFunction applyAsLong
        ToLongBiFunction<String,String> i  = (x,y)-> Long.parseLong(x)+Long.parseLong(y);
        System.out.println(i.applyAsLong("2","2"));
    }

    private static void toIntFunctionDemo(){
        //ToIntFunction represents a function that produces an int-valued result. This is the int-producing primitive specialization for Function.
        //
        //Method
        //ToIntFunction applyAsInt
        ToIntFunction<String> i  = (x)-> Integer.parseInt(x);
        System.out.println(i.applyAsInt("2"));
    }

    private static void toIntBiFunctionDemo(){
        //ToIntBiFunction represents a function that accepts two arguments and produces an int-valued result.
        // This is the int-producing primitive specialization for BiFunction.
        //
        //Method
        //ToIntBiFunction applyAsInt
        ToIntBiFunction<String,String> i  = (x,y)-> Integer.parseInt(x) +Integer.parseInt(x);
        System.out.println(i.applyAsInt("2","3"));
    }

    private static void toDoubleFunctionDemo(){
        //ToDoubleFunction represents a function that produces a double-valued result.
        // This is the double-producing primitive specialization for Function.
        //
        //Method
        //ToDoubleFunction applyAsDouble
        ToDoubleFunction<Integer> i  = (x)-> Math.sin(x);
        System.out.println(i.applyAsDouble(Integer.MAX_VALUE));
    }

    private static void toDoubleBiFunctionDemo(){
        //ToDoubleBiFunction represents a function that accepts two arguments and produces a double-valued result.
        // This is the double-producing primitive specialization for BiFunction.
        //
        //Method
        //ToDoubleBiFunction applyAsDouble
        ToDoubleBiFunction<Integer,Long> i  = (x,y)-> Math.sin(x)+Math.sin(y);
        System.out.println(i.applyAsDouble(Integer.MAX_VALUE, Long.MAX_VALUE));
    }

    private static void supplierDemo(){
        //Supplier represents a supplier of results.
        //
        //Method
        //Supplier get
        Supplier<String> i  = ()-> "java2s.com";
        System.out.println(i.get());
    }

    private static void predicateDemo(){
        //Predicate represents a predicate, which is boolean-valued function, of one argument.
        //
        //Method
        //Predicate test
        //Predicate and
        //Predicate negate
        //Predicate or
        //Predicate isEqual
        Predicate<String> i  = (s)-> s.length() > 5;
        System.out.println(i.test("java2s.com "));
    }

    private static void objLongConsumerDemo(){
        //ObjLongConsumer represents an operation that accepts an object-valued and a long-valued argument, and returns no result.
        // This is the reference, long specialization of BiConsumer.
        //
        //Method
        //ObjLongConsumer accept
        ObjLongConsumer<String> i  = (s,d)->System.out.println(s+d);
        i.accept("java2s.com ",Long.MAX_VALUE);
    }

    private static void objIntConsumerDemo(){
        //ObjIntConsumer represents an operation that accepts an object-valued and a int-valued argument, and returns no result.
        // This is the reference, int specialization of BiConsumer.
        //
        //Method
        //ObjIntConsumer accept
        ObjIntConsumer<String> i  = (s,d)->System.out.println(s+d);
        i.accept("java2s.com ",234);
    }

    private static void objDoubleConsumerDemo(){
        //ObjDoubleConsumer represents an operation that accepts an object-valued and a double-valued argument, and returns no result.
        // This is the reference, double specialization of BiConsumer.
        //
        //Method
        //ObjDoubleConsumer accept
        ObjDoubleConsumer<String> i  = (s,d)->System.out.println(s+d);
        i.accept("java2s.com ",0.1234);
    }

    private static void longUnaryOperatorDemo(){
        //LongUnaryOperator represents an operation on a single long-valued operand that produces a long-valued result.
        // This is the primitive type specialization of UnaryOperator for long.
        //
        //Method
        //LongUnaryOperator applyAsLong
        //LongUnaryOperator compose
        //LongUnaryOperator andThen
        //LongUnaryOperator identity

        LongUnaryOperator i = (l) -> -l;

        System.out.println(i.applyAsLong(Long.MAX_VALUE));
    }

    private static void longToIntFunctionDemo(){
        //LongToIntFunction represents a function that accepts a long-valued argument and produces an int-valued result.
        // This is the long-to-int primitive specialization for Function.
        //
        //Method
        //LongToIntFunction applyAsInt
        LongToIntFunction i = (l) -> (int)l;

        System.out.println(i.applyAsInt(Long.MAX_VALUE));

    }

    private static void longToDoubleFunctionDemo(){
        //LongToDoubleFunction represents a function that accepts a long-valued argument and produces a double-valued result.
        // This is the long-to-double primitive specialization for Function.
        //
        //Method
        //LongToDoubleFunction applyAsDouble
        LongToDoubleFunction i = (l) -> Math.sin(l);

        System.out.println(i.applyAsDouble(Long.MAX_VALUE));
    }

    private static void longSupplierDemo(){
        //LongSupplier represents a supplier of long-valued results. This is the long-producing primitive specialization of Supplier.
        //
        //Method
        //LongSupplier getAsLong
        LongSupplier i = () -> Long.MAX_VALUE;

        System.out.println(i.getAsLong());
    }

    private static void longPredicateDemo(){
        //LongPredicate represents a predicate (boolean-valued function) of one long-valued argument.
        // This is the long-consuming primitive type specialization of Predicate.
        //
        //Method
        //LongPredicate test
        //LongPredicate and
        //LongPredicate negate
        //LongPredicate or

        LongPredicate i = (l) -> l>0;

        System.out.println(i.test(Long.MAX_VALUE));
    }

    private static void longFunctionDmeo(){
        //LongFunction represents a function that accepts a long-valued argument and produces a result.
        // This is the long-consuming primitive specialization for Function.

        // Method
        //LongFunction apply
        LongFunction<String> i = (l) -> Long.toString(l);

        System.out.println(i.apply(Long.MAX_VALUE));
    }

    private static void longConsumerDemo(){
        //LongConsumer represents an operation that accepts a single long-valued argument and returns no result.
        // This is the primitive type specialization of Consumer for long.

        // Method
        //LongConsumer accept
        //LongConsumer andThen
        LongConsumer i = (l) -> System.out.println(l);;
        i.accept(Long.MAX_VALUE);
    }

    private static  void longBinaryOperatorDemo(){
        //LongBinaryOperator represents an operation upon two long-valued operands and producing a long-valued result.
        // This is the primitive type specialization of BinaryOperator for long.

        // Method
        //LongBinaryOperator applyAsLong
        LongBinaryOperator i = (x,y) -> x/y;
        System.out.println(i.applyAsLong(Long.MAX_VALUE,Long.MAX_VALUE));
    }

    private static void intUnaryOperatorDemo(){
        //IntUnaryOperator represents an operation on a single int-valued operand that produces an int-valued result.
        // This is the primitive type specialization of UnaryOperator for int.

        // Method
        //IntUnaryOperator applyAsInt
        //IntUnaryOperator compose
        //IntUnaryOperator andThen
        //IntUnaryOperator identity

        IntUnaryOperator i = (x) -> x*x;
        System.out.println(i.applyAsInt(2));
    }

    private static  void intToLongFunctionDemo(){
        //IntToLongFunction represents a function that accepts an int-valued argument and produces a long-valued result.
        // This is the int-to-long primitive specialization for Function.

        //Method
        //IntToLongFunction applyAsLong
        IntToLongFunction i = (x) -> Long.MAX_VALUE-x;
        System.out.println(i.applyAsLong(2));
    }

    private static void intToDoubleFunctionDemo(){
        //IntToDoubleFunction represents a function that accepts an int-valued argument and produces a double-valued result.
        // This is the int-to-double primitive specialization for Function.

        //Method
        //IntToDoubleFunction applyAsDouble
        IntToDoubleFunction i = (x)->{return Math.sin(x);};
        System.out.println(i.applyAsDouble(2));
    }

    private static void intSupplierDemo(){
        //IntSupplier represents a supplier of int-valued results. This is the int-producing primitive specialization of Supplier.

        //Method
        //IntSupplier getAsInt

        IntSupplier i = ()->Integer.MAX_VALUE;
        System.out.println(i.getAsInt());
    }

    private static void intPredicateDemo(){
        //IntPredicate represents a predicate, which is a boolean-valued function, of one int-valued argument.
        // This is the int-consuming primitive type specialization of Predicate.

        // Method
        //IntPredicate test

        IntPredicate i = (x)->x<0;
        System.out.println(i.test(123));

        //IntPredicate and
        IntPredicate j = (x) -> x==0;
        System.out.println(i.and(j).test(123));

        //IntPredicate negate
        //default IntPredicate negate()
        System.out.println(i.negate().test(123));

        //IntPredicate or
        System.out.println(i.or(j).test(123));
    }

    private static void intFunctionDemo(){
        //IntFunction represents a function that accepts an int-valued argument and produces a result.
        // This is the int-consuming primitive specialization for Function.

        //Method
        //IntFunction apply
        IntFunction<String> i = (x)->Integer.toString(x);
        System.out.println(i.apply(3).length());

    }

    private static void intConsumerDemo(){
        //IntConsumer represents an operation that accepts a single int-valued argument and returns no result.
        // This is the primitive type specialization of Consumer for int.
        //
        //  Method
        //IntConsumer accept
        IntConsumer ic =(x)-> System.out.println(x);
        ic.accept(3);

        //IntConsumer andThen
        //Returns a composed IntConsumer that performs, in sequence, this operation followed by the after operation.
        // If performing either operation throws an exception, it is relayed to the caller of the composed operation. If performing this operation throws an exception, the after operation will not be performed.

        //  Syntax
        //andThen has the following syntax.
        //default IntConsumer andThen(IntConsumer after)
        ic.andThen(ic).accept(3);
    }

    private static void intBinaryOperatorDemo(){
        //IntBinaryOperator represents an operation upon two int-valued operands and producing an int-valued result.
        // This is the primitive type specialization of BinaryOperator for int.

        // Method
        //IntBinaryOperator applyAsInt
        IntBinaryOperator io = (x,y) -> x+y;
        System.out.println(io.applyAsInt(2,3));
    }

    private static void functionDemo(){
        //Function represents a function that accepts one argument and produces a result.

        // Method
        //Function apply
        //Function compose
        //Function andThen
        //Function identity

        Function<Integer, String> convertor = (i) -> Integer.toString(i);
        System.out.println(convertor.apply(3).length());
        System.out.println(convertor.apply(30).length());

        //Function compose returns a composed function that first applies the before function to its input, and then applies this function to the result.

        // Syntax
        //compose has the following syntax.

        //default <V> Function<V,R> compose(Function<? super V,? extends T> before)
        Function<String, Integer> reverse = (s)->Integer.parseInt(s);
        System.out.println(convertor.apply(3).length());
        System.out.println(convertor.compose(reverse).apply("30").length());


        // Function andThen returns a composed function that first applies this function to its input,
        // and then applies the after function to the result.

        // Syntax
        //andThen has the following syntax.

        //default <V> Function<T,V> andThen(Function<? super R,? extends V> after)
        System.out.println(convertor.andThen(reverse).apply(30).byteValue());

        //Function identity returns a function that always returns its input argument.

        // Syntax
        //identity has the following syntax.

        //static <T> Function<T,T> identity()
        Function<Integer, Integer> id = Function.identity();
        System.out.println(id.apply(3));
    }

    private static void doubleUnaryOperatorDemo(){
        //DoubleUnaryOperator represents an operation on a single double-valued operand that produces a double-valued result.
        // This is the primitive type specialization of UnaryOperator for double.

        // Method
        //DoubleUnaryOperator applyAsDouble
        //DoubleUnaryOperator compose
        //DoubleUnaryOperator andThen
        //DoubleUnaryOperator identity\

        DoubleUnaryOperator d1 = (x) -> {return x*x;};
        System.out.println(d1.applyAsDouble(3.14));

        DoubleUnaryOperator square = (x) -> {return x*x;};
        DoubleUnaryOperator doublValue = (x)->{return 2*x;};
        System.out.println(doublValue.compose(square).applyAsDouble(3.14));

        System.out.println(doublValue.andThen(square).applyAsDouble(3.14));

        DoubleUnaryOperator id = DoubleUnaryOperator.identity();
        System.out.println(id.applyAsDouble(3.14));
    }

    private static void doubleToLongFunctionDemo(){
        // DoubleToLongFunction represents a function that accepts a double-valued argument and produces a long-valued result.
        // This is the double-to-long primitive specialization for Function.
        //
        // Method
        //DoubleToLongFunction applyAsLong

        DoubleToLongFunction d1 = (x)->{return Long.MAX_VALUE - (long)x;};
        System.out.println(d1.applyAsLong(3.14));
    }

    private static void doubleToIntFunctionDemo(){
        // DoubleToIntFunction represents a function that accepts a double-valued argument and produces an int-valued result.
        // This is the double-to-int primitive specialization for Function.
        //
        //  Method
        //DoubleToIntFunction applyAsInt

        DoubleToIntFunction df = (x)->{return (int)x+2;};
        System.out.println(df.applyAsInt(3.14));
    }


    private static void doubleSupplierDemo(){
        //DoubleSupplier represents a supplier of double-valued results.
        // This is the double-producing primitive specialization of Supplier.

        //  Method
        //DoubleSupplier getAsDouble
        DoubleSupplier pi = ()-> {return 3.14d;};

        System.out.println(pi.getAsDouble());
    }

    private static void doublePredicateDemo(){
        //DoublePredicate represents a predicate, which is a boolean-valued function, of one double-valued argument.
        // This is the double-consuming primitive type specialization of Predicate.

        //  Method
        //DoublePredicate test
        //DoublePredicate and
        //DoublePredicate negate
        //DoublePredicate or

        DoublePredicate dp = (d) -> d>0;
        System.out.println(dp.test(0.5));
    }

    private static void doubleFunctionDemo(){
        //DoubleFunction represents a function that accepts a double-valued argument and produces a result.
        // This is the double-consuming primitive specialization for Function.

        //  Method
        //DoubleFunction apply
        DoubleFunction<String> df = (d) -> d+"is now a string";
        System.out.println(df.apply(0.5));
    }

    private static void doubleConsumerDemo(){
        //DoubleConsumer functional interface represents an operation that accepts a single double-valued
        // argument and returns no result. This is the primitive type specialization of Consumer for double.

    //   Method
    //DoubleConsumer accept
    //DoubleConsumer andThen

    DoubleConsumer d = (x)-> System.out.println(x*x);
        d.accept(0.23);
}

    private static void doubleBinaryOperatorDemo(){
        //DoubleBinaryOperator represents an operation on two double-valued operands and producing a double-valued result.

        //   Method
        //DoubleBinaryOperator applyAsDouble

        DoubleBinaryOperator d = (x,y) -> x *y;
        System.out.println(d.applyAsDouble(0.23, 0.45));
    }

    private static void consumerDemo(){
        //Consumer interface represents an operation that accepts a single input argument and returns no result.

        //  Method
        //Consumer accept
        //Consumer andThen

        Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
        c.accept("Consumer Demo");

        //create consumer with block statement.
        int x = 99;
        Consumer<Integer> myConsumer = (y) ->{
            System.out.println("x= "+x);   //Statement A
            System.out.println("y= "+y);
        };

        myConsumer.accept(x);
    }

    private static void booleanSupplierDemo(){
        //BooleanSupplier represents a supplier of boolean-valued results.

        // Method
        //BooleanSupplier getAsBoolean

        BooleanSupplier bs = ()->true;
        System.out.println(bs.getAsBoolean());

        int x=0,y=1;
        bs = ()->x>y;
        System.out.println(bs.getAsBoolean());

    }

    private static void biPredicateDemo(){
        //BiPredicate represents a predicate which is a boolean-valued function of two arguments.

        // Method
        //BiPredicate test
        //BiPredicate and
        //BiPredicate negate
        //BiPredicate or

        BiPredicate<Integer, Integer> bi = (x,y) -> x> y;
        System.out.println(bi.test(2, 3));

        //Below code show how to use BiPredicate as function parameter
        boolean result = compare((a,b)->a/2==b, 10, 5);
        System.out.println("Compare result:" + result);

    }

    private static void binaryOperatorDemo(){
        //BinaryOperator represents an operation upon two operands of the same type, producing a result of the same type.
        //Method
        //BinaryOperator minBy
        //BinaryOperator maxBy

        BinaryOperator<Integer> adder = (n1, n2) -> n1+n2;
        System.out.println(adder.apply(3,4));
    }

    private static void biConsumerDemo(){
        //BiConsumer represents an operation that accepts two input arguments and returns no result
        BiConsumer<String, String> biConsumer = (x, y) ->{
            System.out.println(x);
            System.out.println(y);
        };
        biConsumer.accept("BiConsumer","Example");
    }

    private static void biFunctionDemo(){
        //BiFunction represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function.

        //    Method
        //BiFunction apply
        //BiFunction andThen

        BiFunction<String, String, String> bi = (x, y) ->{
            return x+y;
        };
        System.out.println(bi.apply("testing", " biFunction"));
    }

    private static boolean compare(BiPredicate<Integer, Integer> bi, Integer i1, Integer i2){
        return bi.test(i1, i2);
    }
}

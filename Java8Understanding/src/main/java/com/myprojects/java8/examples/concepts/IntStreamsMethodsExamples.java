package com.myprojects.java8.examples.concepts;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class IntStreamsMethodsExamples {

	public static void main(String[] args) {
		//http://www.java2s.com/Tutorials/Java/java.util.stream/IntStream/index.htm
		
		//IntStream allMatch(IntPredicate predicate) returns whether all elements of this stream match the provided predicate.
		allMatchWith();
		
		//IntStream anyMatch(IntPredicate predicate) returns whether any elements of this stream match the provided predicate.
		anyMatchWith();
		
		//IntStream asDoubleStream() returns a DoubleStream consisting of the elements of this stream, converted to double. This is an intermediate operation
		asDoubleStream();
	}

	private static void asDoubleStream() {
		 IntStream i = IntStream.of(6,5,7,1, 2, 3, 4);
		 DoubleStream d = i.asDoubleStream();
		 d.forEach(System.out::println);
		
	}

	private static void anyMatchWith() {
		IntStream i = IntStream.of(6,5,7,1, 2, 3, 3);
	    boolean d = i.anyMatch(n-> n > 0 );
	    System.out.println(d);
	}

	private static void allMatchWith() {
		IntStream i = IntStream.concat(IntStream.of(6,5,7,1, 2, 3, 3),IntStream.of(9,8));
	    boolean d = i.allMatch(n-> n > 0 );
	    System.out.println(d);
		
	}

}

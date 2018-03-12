package com.myprojects.java8.examples.concepts.intStreams;

import java.util.stream.IntStream;

public class IntStreamExamples {

	public static void main(String[] args) {
		//IntStream allMatch(IntPredicate predicate)
		allMatchWithIntStream();
		
		//IntStream anyMatch(IntPredicate predicate) returns whether any elements of this stream match the provided predicate.
		anyMatchWithIntStream();
	}

	private static void anyMatchWithIntStream() {
		IntStream i = IntStream.of(6,5,7,1, 2, 3, 3);
	    boolean d = i.anyMatch(n-> n > 0 );
	    System.out.println(d);
	}

	private static void allMatchWithIntStream() {
		IntStream i = IntStream.concat(IntStream.of(6,5,7,1, 2, 3, 3),IntStream.of(9,8));
	    boolean d = i.allMatch(n-> n > 0 );
	    System.out.println(d);
		
	}

}

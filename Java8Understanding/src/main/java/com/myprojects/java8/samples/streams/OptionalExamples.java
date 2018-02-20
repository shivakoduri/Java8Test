package com.myprojects.java8.samples.streams;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExamples {
	
	static class Outer {
		Nested nested = new Nested();

		public Nested getNested() {
			return nested;
		}
	}

	static class Nested {
		Inner inner = new Inner();

		public Inner getInner() {
			return inner;
		}
	}

	static class Inner {
		String foo = "boo";

		public String getFoo() {
			return foo;
		}
	}

	
	public static void main(String[] args) {
		optionalExample1();
		
		test1();
		test2();
		test3();
	}
	
	private static void optionalExample1(){
		Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	}

	public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    private static void test3() {
        Outer outer = new Outer();
        resolve(() -> outer.getNested().getInner().getFoo())
                .ifPresent(System.out::println);
    }

    private static void test2() {
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);
    }

    private static void test1() {
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);
    }
}

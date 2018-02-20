package com.myprojects.java8.samples.streams;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExamples {

	public static final int MAX = 1000000;

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("d2", "a2", "b1", "b3", "c");

		streamsExample1();
		streamsExample2();

		sortSequential();
		sortParallel();

		streamsExample3();

		// test1(strings);
		// test2(strings);
		// test3(strings);
		// test4(strings);
		// test5(strings);
		// test6(strings);
		// test7(strings);
		test8(strings);

		test1();
		test2();
		test3();
		test4();

		// test11();
		test21();

		streamsExample4();
		streamsExample5();

		List<Person> persons = Arrays
				.asList(new Person("Max", 18), new Person("Peter", 23),
						new Person("Pamela", 23), new Person("David", 12));

		// test1_(persons);
		// test2_(persons);
		// test3_(persons);
		// test4_(persons);
		// test5_(persons);
		// test6_(persons);
		// test7_(persons);
		// test8_(persons);
		test9_(persons);

		// _test1(persons);
		// _test2(persons);
		// _test3(persons);
		// _test4(persons);
		// _test5(persons);
		_test6(persons);

		List<String> strings_ = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		// test_1();
		// test_2(strings);
		test_3(strings);
		// test_4();

		streamsExample6();

	}

	private static void streamsExample6() {
		SecureRandom secureRandom = new SecureRandom(new byte[] { 1, 3, 3, 7 });
		int[] randoms = IntStream.generate(secureRandom::nextInt)
				.filter(n -> n > 0).limit(10).toArray();
		System.out.println(Arrays.toString(randoms));

		int[] nums = IntStream.iterate(1, n -> n * 2).limit(11).toArray();
		System.out.println(Arrays.toString(nums));
	}

	private static void test_4() {
		List<String> values = new ArrayList<>(100);
		for (int i = 0; i < 100; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		// sequential

		long t0 = System.nanoTime();

		long count = values
				.parallelStream()
				.sorted((s1, s2) -> {
					System.out.format("sort:    %s <> %s [%s]\n", s1, s2,
							Thread.currentThread().getName());
					return s1.compareTo(s2);
				}).count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));
	}

	private static void test_3(List<String> strings) {
		strings.parallelStream()
				.filter(s -> {
					System.out.format("filter:  %s [%s]\n", s, Thread
							.currentThread().getName());
					return true;
				})
				.map(s -> {
					System.out.format("map:     %s [%s]\n", s, Thread
							.currentThread().getName());
					return s.toUpperCase();
				})
				.sorted((s1, s2) -> {
					System.out.format("sort:    %s <> %s [%s]\n", s1, s2,
							Thread.currentThread().getName());
					return s1.compareTo(s2);
				})
				.forEach(
						s -> System.out.format("forEach: %s [%s]\n", s, Thread
								.currentThread().getName()));
	}

	private static void test_2(List<String> strings) {
		strings.parallelStream()
				.filter(s -> {
					System.out.format("filter:  %s [%s]\n", s, Thread
							.currentThread().getName());
					return true;
				})
				.map(s -> {
					System.out.format("map:     %s [%s]\n", s, Thread
							.currentThread().getName());
					return s.toUpperCase();
				})
				.forEach(
						s -> System.out.format("forEach: %s [%s]\n", s, Thread
								.currentThread().getName()));
	}

	private static void test_1() {
		// -Djava.util.concurrent.ForkJoinPool.common.parallelism=5

		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());
	}

	private static void _test1(List<Person> persons) {
		persons.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
				.ifPresent(System.out::println); // Pamela
	}

	private static void _test2(List<Person> persons) {
		Person result = persons.stream().reduce(new Person("", 0),
				(p1, p2) -> {
					p1.age += p2.age;
					p1.name += p2.name;
					return p1;
				});

		System.out.format("name=%s; age=%s", result.name, result.age);
	}

	private static void _test3(List<Person> persons) {
		Integer ageSum = persons.stream().reduce(0, (sum, p) -> sum += p.age,
				(sum1, sum2) -> sum1 + sum2);

		System.out.println(ageSum);
	}

	private static void _test4(List<Person> persons) {
		Integer ageSum = persons.stream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			return sum += p.age;
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});

		System.out.println(ageSum);
	}

	private static void _test5(List<Person> persons) {
		Integer ageSum = persons.parallelStream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			return sum += p.age;
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});

		System.out.println(ageSum);
	}

	private static void _test6(List<Person> persons) {
		Integer ageSum = persons.parallelStream().reduce(
				0,
				(sum, p) -> {
					System.out.format(
							"accumulator: sum=%s; person=%s; thread=%s\n", sum,
							p, Thread.currentThread().getName());
					return sum += p.age;
				},
				(sum1, sum2) -> {
					System.out.format(
							"combiner: sum1=%s; sum2=%s; thread=%s\n", sum1,
							sum2, Thread.currentThread().getName());
					return sum1 + sum2;
				});

		System.out.println(ageSum);
	}

	private static void test1_(List<Person> persons) {
		List<Person> filtered = persons.stream()
				.filter(p -> p.name.startsWith("P"))
				.collect(Collectors.toList());

		System.out.println(filtered); // [Peter, Pamela]
	}

	private static void test2_(List<Person> persons) {
		Map<Integer, List<Person>> personsByAge = persons.stream().collect(
				Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age,
				p));

		// age 18: [Max]
		// age 23:[Peter, Pamela]
		// age 12:[David]
	}

	private static void test3_(List<Person> persons) {
		Double averageAge = persons.stream().collect(
				Collectors.averagingInt(p -> p.age));

		System.out.println(averageAge); // 19.0
	}

	private static void test4_(List<Person> persons) {
		IntSummaryStatistics ageSummary = persons.stream().collect(
				Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);
		// IntSummaryStatistics{count=4, sum=76, min=12, average=19,000000,
		// max=23}
	}

	private static void test5_(List<Person> persons) {
		String names = persons
				.stream()
				.filter(p -> p.age >= 18)
				.map(p -> p.name)
				.collect(
						Collectors.joining(" and ", "In Germany ",
								" are of legal age."));

		System.out.println(names);
		// In Germany Max and Peter and Pamela are of legal age.
	}

	private static void test6_(List<Person> persons) {
		Map<Integer, String> map = persons.stream().collect(
				Collectors.toMap(p -> p.age, p -> p.name,
						(name1, name2) -> name1 + ";" + name2));

		System.out.println(map);
		// {18=Max, 23=Peter;Pamela, 12=David}
	}

	private static void test7_(List<Person> persons) {
		Collector<Person, StringJoiner, String> personNameCollector = Collector
				.of(() -> new StringJoiner(" | "), // supplier
						(j, p) -> j.add(p.name.toUpperCase()), // accumulator
						(j1, j2) -> j1.merge(j2), // combiner
						StringJoiner::toString); // finisher

		String names = persons.stream().collect(personNameCollector);

		System.out.println(names); // MAX | PETER | PAMELA | DAVID
	}

	private static void test8_(List<Person> persons) {
		Collector<Person, StringJoiner, String> personNameCollector = Collector
				.of(() -> {
					System.out.println("supplier");
					return new StringJoiner(" | ");
				}, (j, p) -> {
					System.out.format("accumulator: p=%s; j=%s\n", p, j);
					j.add(p.name.toUpperCase());
				}, (j1, j2) -> {
					System.out.println("merge");
					return j1.merge(j2);
				}, j -> {
					System.out.println("finisher");
					return j.toString();
				});

		String names = persons.stream().collect(personNameCollector);

		System.out.println(names); // MAX | PETER | PAMELA | DAVID
	}

	private static void test9_(List<Person> persons) {
		Collector<Person, StringJoiner, String> personNameCollector = Collector
				.of(() -> {
					System.out.println("supplier");
					return new StringJoiner(" | ");
				}, (j, p) -> {
					System.out.format("accumulator: p=%s; j=%s\n", p, j);
					j.add(p.name.toUpperCase());
				}, (j1, j2) -> {
					System.out.println("merge");
					return j1.merge(j2);
				}, j -> {
					System.out.println("finisher");
					return j.toString();
				});

		String names = persons.parallelStream().collect(personNameCollector);

		System.out.println(names); // MAX | PETER | PAMELA | DAVID
	}

	static class Person {
		String name;
		int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	private static void streamsExample5() {
		Arrays.asList("a1", "a2", "b1", "c2", "c1").stream()
				.filter(s -> s.startsWith("c")).map(String::toUpperCase)
				.sorted().forEach(System.out::println);

		// C1
		// C2
	}

	private static void streamsExample4() {
		Arrays.asList("a1", "a2", "a3").stream().findFirst()
				.ifPresent(System.out::println);

		Stream.of("a1", "a2", "a3").map(s -> s.substring(1))
				.mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println);

		IntStream.range(1, 4).mapToObj(i -> "a" + i)
				.forEach(System.out::println);

		Arrays.stream(new int[] { 1, 2, 3 }).map(n -> 2 * n + 1).average()
				.ifPresent(System.out::println);

		Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue)
				.mapToObj(i -> "a" + i).forEach(System.out::println);

	}

	static void test21() {
		IntStream
				.range(1, 4)
				.mapToObj(num -> new Foo("Foo" + num))
				.peek(f -> IntStream
						.range(1, 4)
						.mapToObj(num -> new Bar("Bar" + num + " <- " + f.name))
						.forEach(f.bars::add)).flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));
	}

	static void test11() {
		List<Foo> foos = new ArrayList<>();

		IntStream.range(1, 4).forEach(num -> foos.add(new Foo("Foo" + num)));

		foos.forEach(f -> IntStream.range(1, 4).forEach(
				num -> f.bars.add(new Bar("Bar" + num + " <- " + f.name))));

		foos.stream().flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));
	}

	static class Foo {
		String name;
		List<Bar> bars = new ArrayList<>();

		Foo(String name) {
			this.name = name;
		}
	}

	static class Bar {
		String name;

		Bar(String name) {
			this.name = name;
		}
	}

	private static void test4() {
		Stream.of(new BigDecimal("1.2"), new BigDecimal("3.7"))
				.mapToDouble(BigDecimal::doubleValue).average()
				.ifPresent(System.out::println);
	}

	private static void test3() {
		IntStream.range(0, 10).average().ifPresent(System.out::println);
	}

	private static void test2() {
		IntStream.builder().add(1).add(3).add(5).add(7).add(11).build()
				.average().ifPresent(System.out::println);

	}

	private static void test1() {
		int[] ints = { 1, 3, 5, 7, 11 };
		Arrays.stream(ints).average().ifPresent(System.out::println);
	}

	private static void test8(List<String> stringCollection) {
		Supplier<Stream<String>> streamSupplier = () -> stringCollection
				.stream().filter(s -> s.startsWith("a"));

		streamSupplier.get().anyMatch(s -> true);
		streamSupplier.get().noneMatch(s -> true);
	}

	// stream has already been operated upon or closed
	private static void test7(List<String> stringCollection) {
		Stream<String> stream = stringCollection.stream().filter(
				s -> s.startsWith("a"));

		stream.anyMatch(s -> true);
		stream.noneMatch(s -> true);
	}

	// short-circuit
	private static void test6(List<String> stringCollection) {
		stringCollection.stream().map(s -> {
			System.out.println("map:      " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});
	}

	private static void test5(List<String> stringCollection) {
		stringCollection.stream().filter(s -> {
			System.out.println("filter:  " + s);
			return s.toLowerCase().startsWith("a");
		}).sorted((s1, s2) -> {
			System.out.printf("sort:    %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).map(s -> {
			System.out.println("map:     " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));
	}

	// sorted = horizontal
	private static void test4(List<String> stringCollection) {
		stringCollection.stream().sorted((s1, s2) -> {
			System.out.printf("sort:    %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).filter(s -> {
			System.out.println("filter:  " + s);
			return s.toLowerCase().startsWith("a");
		}).map(s -> {
			System.out.println("map:     " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));
	}

	private static void test3(List<String> stringCollection) {
		stringCollection.stream().filter(s -> {
			System.out.println("filter:  " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map:     " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));
	}

	private static void test2(List<String> stringCollection) {
		stringCollection.stream().map(s -> {
			System.out.println("map:     " + s);
			return s.toUpperCase();
		}).filter(s -> {
			System.out.println("filter:  " + s);
			return s.startsWith("A");
		}).forEach(s -> System.out.println("forEach: " + s));
	}

	private static void test1(List<String> stringCollection) {
		stringCollection.stream().filter(s -> {
			System.out.println("filter:  " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));
	}

	public static void streamsExample3() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}

		IntStream.range(0, 10).forEach(i -> {
			if (i % 2 == 1)
				System.out.println(i);
		});

		IntStream.range(0, 10).filter(i -> i % 2 == 1)
				.forEach(System.out::println);

		OptionalInt reduced1 = IntStream.range(0, 10).reduce((a, b) -> a + b);
		System.out.println(reduced1.getAsInt());

		int reduced2 = IntStream.range(0, 10).reduce(7, (a, b) -> a + b);
		System.out.println(reduced2);
	}

	public static void sortSequential() {
		List<String> values = new ArrayList<>(MAX);
		for (int i = 0; i < MAX; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		// sequential

		long t0 = System.nanoTime();

		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out
				.println(String.format("sequential sort took: %d ms", millis));
	}

	public static void sortParallel() {
		List<String> values = new ArrayList<>(MAX);
		for (int i = 0; i < MAX; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		// sequential

		long t0 = System.nanoTime();

		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));
	}

	private static void streamsExample2() {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		// sorting

		stringCollection.stream().sorted().forEach(System.out::println);

		System.out.println(stringCollection);
	}

	private static void streamsExample1() {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		// filtering

		stringCollection.stream().filter((s) -> s.startsWith("a"))
				.forEach(System.out::println);

		// "aaa2", "aaa1"

		// sorting

		stringCollection.stream().sorted().filter((s) -> s.startsWith("a"))
				.forEach(System.out::println);

		// "aaa1", "aaa2"

		// mapping

		stringCollection.stream().map(String::toUpperCase)
				.sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

		// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

		// matching

		boolean anyStartsWithA = stringCollection.stream().anyMatch(
				(s) -> s.startsWith("a"));

		System.out.println(anyStartsWithA); // true

		boolean allStartsWithA = stringCollection.stream().allMatch(
				(s) -> s.startsWith("a"));

		System.out.println(allStartsWithA); // false

		boolean noneStartsWithZ = stringCollection.stream().noneMatch(
				(s) -> s.startsWith("z"));

		System.out.println(noneStartsWithZ); // true

		// counting

		long startsWithB = stringCollection.stream()
				.filter((s) -> s.startsWith("b")).count();

		System.out.println(startsWithB); // 3

		// reducing

		Optional<String> reduced = stringCollection.stream().sorted()
				.reduce((s1, s2) -> s1 + "#" + s2);

		reduced.ifPresent(System.out::println);
		// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

	}
}

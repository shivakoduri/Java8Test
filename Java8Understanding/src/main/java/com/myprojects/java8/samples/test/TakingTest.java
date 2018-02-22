package com.myprojects.java8.samples.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TakingTest {

	public static void main(String[] args) {

		Q1();
		Q2();
		Q3();
		Q4();
		Q5();
		Q6();
		Q7();
		Q8();
		Q9();
		Q10();
		Q11();
		Q12();
		Q13();
		Q14();
		Q15();
		Q16();
	}

	private static void Q1() {
		// Ref
		// :https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html

		Optional<Integer> ops = Optional.ofNullable(null);
		System.out.println("Q1->" + ops);
	}

	private static void Q2() {
		// Ref:
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
		List<Integer> ins = new ArrayList<>();
		ins.add(12);
		ins.add(2);
		ins.add(10);
		ins.add(4);

		System.out.println("Q2./n");
		// int max = ins.stream().max(Integer::compare); //compile faile - max
		// method returns an optional integer with the max value of the stream.
		// //Assigning the optional integer to the int primitive results in
		// compilation failure.
		// System.out.println(max + int.stream().count());
	}

	private static void Q3() {
		// Ref:
		// https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
		Stream<Integer> ins = Stream.of(22, 2, 6, 4, 19);
		Map<Boolean, List<Integer>> map = ins.collect(Collectors
				.partitioningBy(in -> in % 2 != 0));
		System.out.println("Q3->" + map.get(true));
	}

	private static void Q4() {
		// Ref:https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html#laziness

		Stream<Integer> stream = Stream.of(1, 2, 3);
		System.out.println("Q4->"
				+ stream.peek(System.out::println).findAny().orElse(0));

	}

	private static void Q5() {
		// Ref:https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "threee");

		// Consumer<String> cons = System.out::println;
		// map.forEach(cons);
		// compilation fails, forEach method of map interface expects BiConsumer

	}

	private static void Q6() {

		// Ref: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.putIfAbsent("1", 0);
		// map.computeIfAbsent("3", (k,v)->v>3?v:null);
		// System.out.println(map.values());

		// Compilation fails: The computIfPresent method attempts to compute a
		// new mapping given the key and its current mapped value if the value
		// for the specified key is present
		// and non-null. If the function returns null, the mapping is removed.If
		// the function itself throws an unchecked exception, the exception is
		// rethrown, and the current mapping
		// is left unchanged.

	}

	private static void Q7() {

		// Ref:https://docs.oracle.com/javase/8/docs/api/java/util/List.html

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.replaceAll(in -> Integer.compare(2, in));
		System.out.println(list);

	}

	private static void Q8() {
		// Ref -
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html

		IntStream ins = IntStream.range(1, 6);
		System.out.println(ins.average());
	}

	private static void Q9() {
		// Ref -
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html

		IntStream ins = IntStream.of(1, 4, 5, 2);
		IntSummaryStatistics sumy = ins.summaryStatistics();
		sumy.accept(3);
		System.out.println(sumy.getSum());

	}

	class MyCal {
		public int calc(int x, int y) {
			return x * y;
		}
	}

	private static void Q10() {
		// MyCal my = new MyCal(){
		// public void print(){
		// System.out.println("MyCal");
		// }
		// }
		// System.out.println(my.println());
	}

	private static void Q11() {

		// Ref - https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html

		String strs[] = { "A", "B", "C" };
		Arrays.parallelPrefix(strs, String::concat);
		System.out.println(strs[2]);
	}

	private static void Q12() {
		// Ref - https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html

		Stream<Integer> stream = Stream.of(1, 2, 3, 4).parallel();
		stream.sequential();
		stream.forEach(System.out::println);

	}

	private static void Q13() {

		// Ref -
		// https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/mm/dd");
		LocalDateTime ldt = LocalDateTime.of(2015, 10, 10, 11, 22);
		System.out.println(dtf.format(ldt));

	}

	private static void Q14() {
		// Ref - https://docs.oracle.com/javase/8/docs/api/java/time/Year.html

		Year y = Year.of(2015);
		YearMonth ym = y.atMonth(12);
		LocalDate date = ym.atEndOfMonth();
		System.out.println(date.getDayOfYear());
	}

	private static void Q15() {

		// Ref -
		// https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html

		List<Integer> ins = new ArrayList<>();
		ins.add(3);
		ins.add(10);
		ins.add(11);
		ins.add(5);

		Predicate<Integer> p = i -> i > 5;
		Predicate<Integer> p2 = p.and(i -> i < 10);
		System.out.println(ins.removeIf(p2));

	}

	interface I {

		public default void print() {
			System.out.println("I");
		}

		static void method() {
			System.out.println("Static");
		}
	}

	private static void Q16() {

		// Ref -
		// https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html

		I i = new I() {
		};
		i.print();
		I.method();
	}

}

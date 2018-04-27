package com.myprojects.java8.forums.examples.forum6.collector;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollectors {

    private static final BinaryOperator NOOP_COMBINER = (l, r ) -> {
        throw new RuntimeException("Parallel execution not supported");
    };

    @SuppressWarnings("unchecked")
    public static <T, R> Collector<T, R, R> of(Supplier<R> container, BiConsumer<R, T> accumulator) {
        return Collector.of(container, accumulator, NOOP_COMBINER);
    }


}

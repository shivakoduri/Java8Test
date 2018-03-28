package com.myprojects.java8.forums.examples.forum1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String... args){

        //CompleteableFuture.join
        completableFutureOneExample();

        //CompleatableFuture.thenAccept
        completableFutureTwoExample();

        //CompletableFuture.whenComplete
        completableFutureThreeExample();

        //CompletableFuture.getNow
        completableFutureFourExample();

    }

    private static void completableFutureFourExample(){
        //getNow is a method that if calling completion stage is not completed then the value passed to getNow will be set to result.
        List<String> list = Arrays.asList("A","B","C","D");
        list.stream()
                .map(s->CompletableFuture.supplyAsync(()->s+s))
                .map(f->f.getNow("Not Done"))
                .forEach(s-> System.out.println(s));

    }

    private static void completableFutureThreeExample(){
        //whenComplete method uses BiConsumer as an argument.
        // Once the calling completion stage completes, whenComplete method applies completion stage
        // result on BiConsumer. BiConsumer takes first argument as result and second argument as error if any.

        List<String> list = Arrays.asList("A", "B", "C", "D");
        list.stream()
                .map(s->CompletableFuture.supplyAsync(() -> s+s))
                .map(f->f.whenComplete((result,error)-> System.out.println(result+" Error:"+error)))
                .count();

    }

    private static void completableFutureTwoExample(){
        //thenAccept method accepts Consumer as an argument. On the completion of any completion stage,
        // thenAccept method applies Consumer on the result and returns CompletableFuture.
        List<String> list = Arrays.asList("A", "B", "C", "D");
        list.stream()
                .map(data->CompletableFuture.supplyAsync(()->"Processing:"+data))
                .map(compFuture -> compFuture.thenAccept(s-> System.out.println(s)))
                .map(t->t.join())
                .count();
    }

    private static void completableFutureOneExample(){
        //join method returns the result after completion or throws CompletionException.
        // This method waits for the completion of calling completion stage.
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        list.stream()
                .map(data -> CompletableFuture.supplyAsync(()-> getNumber(data)))
                .map(compFuture -> compFuture.thenApply(n->n*n))
                .map(t->t.join())
                .forEach(s-> System.out.println(s));
    }



    private static int getNumber(int a){
        return a*a;
    }
}


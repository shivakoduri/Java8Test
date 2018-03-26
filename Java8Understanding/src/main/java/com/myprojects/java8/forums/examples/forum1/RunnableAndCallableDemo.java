package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.RunnableDemoBook;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class RunnableAndCallableDemo {

    public static void main(String... args){

        //Runnable Demo
        runnableDemo();

        //Runnable Executor
        runnableExecutor();

        //Java8 Callable Lambda Example with Argument
        callalableDemo();
    }

    private static void callalableDemo(){
        final List<Integer> integers = Arrays.asList(1,2,3,4,5);
        Callable<Integer> callableObj = () -> {
                int result  = integers.stream().mapToInt(i -> i.intValue()).sum();
                return result;
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callableObj);
        Integer result = 0;

        try{
            result = future.get();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        System.out.println("Sum=" + result);
      }

    private static void runnableExecutor(){
        final List<RunnableDemoBook> list = Arrays.asList(new RunnableDemoBook(1, "Ramayan"), new RunnableDemoBook(2, "Mahabharat"));
        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable r1 = () -> list.forEach(RunnableDemoBook::print);
        service.execute(r1);

        Runnable r2 = ()->{
            Consumer<RunnableDemoBook> style = (RunnableDemoBook rb) -> System.out.println("Book Id:" +rb.getId()+", Book Name:" + rb.getName());
            list.forEach(style);
        };
        service.execute(r2);
    }

    private static void runnableDemo(){
        final List<RunnableDemoBook> list = Arrays.asList(
                new RunnableDemoBook(1, "Ramayana"),
                new RunnableDemoBook(2, "Mahabharath"));

        Runnable r1 = () -> list.forEach(RunnableDemoBook::print);
        Thread th1 = new Thread(r1);
        th1.start();

        Runnable r2 = () -> {
            Consumer<RunnableDemoBook>   style = (RunnableDemoBook rb) -> System.out.println("Book Id:" + rb.getId()+", Book Name:" + rb.getName());
            list.forEach(style);
        };

        Thread th2 = new Thread(r2);
        th2.start();
    }
}

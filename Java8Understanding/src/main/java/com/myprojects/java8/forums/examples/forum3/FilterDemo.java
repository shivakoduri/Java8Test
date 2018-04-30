package com.myprojects.java8.forums.examples.forum3;

import com.myprojects.java8.forums.examples.forum3.model.Employee;

public class FilterDemo {

    public static void main(String... args) {
        //use a stream of employees and filters in only females.
        Employee.persons().stream().filter(Employee::isMale).map(Employee::getName).forEach(System.out::println);
    }
}

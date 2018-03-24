package com.myprojects.java8.forums.examples.model;

import java.util.ArrayList;
import java.util.List;

public class Person3 {

    private String name;
    private int age;

    public Person3(String name, int age){
        this.name = name;
        this.age =age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static List<Person3> getList(){
        List<Person3> list = new ArrayList<>();
        list.add(new Person3("Ram", 23));
        list.add(new Person3("Shyam", 20));
        list.add(new Person3("Shiv", 25));
        list.add(new Person3("Mahesh", 30));

        return list;
    }
}

package com.myprojects.java8.forums.examples.model;

import java.util.ArrayList;
import java.util.List;

public class User1 {

    private int id;
    private String name;
    private int age;

    public User1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<User1> getUsers(){
        List<User1> list = new ArrayList<>();
        list.add(new User1(1, "Dinesh", 20));
        list.add(new User1(2, "Kamal", 15));
        list.add(new User1(3, "Vijay", 25));
        list.add(new User1(4, "Ramesh", 30));
        list.add(new User1(5, "Mahes", 18));

        return list;
    }
}

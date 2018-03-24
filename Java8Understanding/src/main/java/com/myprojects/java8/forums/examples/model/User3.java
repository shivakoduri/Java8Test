package com.myprojects.java8.forums.examples.model;

public class User3 implements Comparable<User3> {

    private String name;
    private int age;

    public User3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int compareTo(User3 o) {
        return name.compareTo(o.name);
    }

    public static User3[] getUsers(){
        User3[] users = new User3[6];
        users[0] = new User3 ("Ram", 25);
        users[1] = new User3 ("Shyam", 22);
        users[2] = new User3 ("Mohan", 21);
        users[3] = new User3 ("Suresh", 30);
        users[4] = new User3 ("Ramesh", 20);
        users[5] = new User3 ("Dinesh", 27);
        return users;

    }


}

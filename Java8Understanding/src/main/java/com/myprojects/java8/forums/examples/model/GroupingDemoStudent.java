package com.myprojects.java8.forums.examples.model;

public class GroupingDemoStudent {

    private String name;
    private int age;
    private String className;

    public GroupingDemoStudent(String name, int age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }
}

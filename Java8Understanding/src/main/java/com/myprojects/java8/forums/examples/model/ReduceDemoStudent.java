package com.myprojects.java8.forums.examples.model;

public class ReduceDemoStudent {

    private String name;
    private Integer age;
    private String className;

    public ReduceDemoStudent(String name, Integer age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }
}

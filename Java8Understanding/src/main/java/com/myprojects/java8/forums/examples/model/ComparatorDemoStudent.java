package com.myprojects.java8.forums.examples.model;

import java.util.Arrays;
import java.util.List;

public class ComparatorDemoStudent {

    private String name;
    private int age;

    public ComparatorDemoStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static List<ComparatorDemoStudent> getStudentList(){
        ComparatorDemoStudent s1 = new ComparatorDemoStudent("Ram", 18);
        ComparatorDemoStudent s2 = new ComparatorDemoStudent("Shyam", 22);
        ComparatorDemoStudent s3 = new ComparatorDemoStudent("Mohan", 19);
        ComparatorDemoStudent s4 = new ComparatorDemoStudent("Mahesh", 20);
        ComparatorDemoStudent s5 = new ComparatorDemoStudent("Krishna", 21);

        List<ComparatorDemoStudent> list = Arrays.asList(s1, s2, s3, s4, s5);
        return list;
    }
}

package com.myprojects.java8.forums.examples.comparator;

import com.myprojects.java8.forums.examples.model.AnotherPerson;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<AnotherPerson> {


    @Override
    public int compare(AnotherPerson o1, AnotherPerson o2) {
       return o1.getName().compareTo(o2.getName());
    }
}

package com.myprojects.java8.forums.examples.comparator;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {


    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1>=o2){
            return 1;
        }else{
            return -1;
        }

    }
}

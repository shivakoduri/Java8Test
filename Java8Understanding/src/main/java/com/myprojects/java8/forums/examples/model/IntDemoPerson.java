package com.myprojects.java8.forums.examples.model;

public class IntDemoPerson {

    private String name;
    private int[] luckyNum;

    public IntDemoPerson(String name, int[] luckyNum) {
        this.name = name;
        this.luckyNum = luckyNum;
    }

    public String getName() {
        return name;
    }

    public int[] getLuckyNum() {
        return luckyNum;
    }
}

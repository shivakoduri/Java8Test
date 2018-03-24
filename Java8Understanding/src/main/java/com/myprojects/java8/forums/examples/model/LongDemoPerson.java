package com.myprojects.java8.forums.examples.model;

public class LongDemoPerson {

    private String name;
    private long[] luckNum;

    public LongDemoPerson(String name, long[] luckNum) {
        this.name = name;
        this.luckNum = luckNum;
    }

    public String getName() {
        return name;
    }

    public long[] getLuckNum() {
        return luckNum;
    }
}

package com.myprojects.java8.forums.examples.model;

public class Floor {

    private int length;
    private int width;

    public Floor(int length, int width){
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public static Floor[] getFloorSizes(){
        Floor[] floors = new Floor[6];
        floors[0] = new Floor(2 ,3 );
        floors[1] = new Floor(4 ,5 );
        floors[2] = new Floor(3 ,6 );
        floors[3] = new Floor(2 ,1 );
        floors[4] = new Floor(1 ,7 );
        floors[5] = new Floor(4 ,3 );

        return  floors;
    }
}

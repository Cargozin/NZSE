package com.example.cwspace.Datenklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RoomsArray {
    private static final ArrayList<Room> Arraylist = new ArrayList<Room>();

    private RoomsArray() {
        System.out.println("Objekt gebildet...");
    }

    public static ArrayList<Room> getInstance() {
        return Arraylist;
    }

    public static void sortByName(){
        Collections.sort(RoomsArray.getInstance(), new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void sortByPopularity(){
        Collections.sort(RoomsArray.getInstance(), new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return Integer.compare(o2.getBookings(),o1.getBookings());
            }
        });
    }

}
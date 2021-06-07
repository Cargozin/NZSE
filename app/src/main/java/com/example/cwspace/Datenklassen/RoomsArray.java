package com.example.cwspace.Datenklassen;

import java.util.ArrayList;

public class RoomsArray {
    private static final ArrayList<Room> Arraylist = new ArrayList<Room>();

    private RoomsArray() {
        System.out.println("Objekt gebildet...");
    }

    public static ArrayList<Room> getInstance() {
        return Arraylist;
    }
}
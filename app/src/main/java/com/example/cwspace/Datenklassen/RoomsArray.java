package com.example.cwspace.Datenklassen;

import java.util.ArrayList;

public class RoomsArray {
    private static final ArrayList<Raum> Arraylist = new ArrayList<Raum>();

    private RoomsArray() {
        System.out.println("Objekt gebildet...");
    }

    public static ArrayList<Raum> getInstance() {
        return Arraylist;
    }
}
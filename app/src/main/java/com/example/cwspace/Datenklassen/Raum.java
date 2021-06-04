package com.example.cwspace.Datenklassen;

import com.example.cwspace.Datenklassen.Gebauede;

import java.util.Vector;

public class Raum {
    String name;
    int numSeats;
    boolean belegt;
    Gebauede gebauede;
    Vector<String> ausstattungVector;
    void setBelegt(){
        belegt=true;
    }
    void setNichtBelegt(){
        belegt=false;
    }

    public String getName() {
        return name;
    }
    public String getNumSeats(){
        return String.valueOf(numSeats);
    }
    public Raum(String newName,int newNumSeats){
        name=newName;
        numSeats=newNumSeats;
    }
}

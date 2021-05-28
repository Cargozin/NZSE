package com.example.cwspace.Datenklassen;

import com.example.cwspace.Datenklassen.Gebauede;

import java.util.Vector;

public class Raum {
    String name;
    int anzahlPlätze;
    boolean belegt;
    Gebauede gebauede;
    Vector<String> ausstattungVector;
    void setBelegt(){
        belegt=true;
    }
    void setNichtBelegt(){
        belegt=false;
    }
}

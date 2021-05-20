package com.example.cwspace;

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

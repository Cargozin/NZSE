package com.example.cwspace.Datenklassen;

public class Room {
    String name;
    int numSeats;
    boolean belegt;
    int bookings;
    //Gebauede gebauede;
    //Vector<String> ausstattungVector;
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
    public int getBookings(){return bookings;}
    public Room(String newName, int newNumSeats){
        name=newName;
        numSeats=newNumSeats;
        belegt=false;
        bookings = 0;
    }
}

package com.example.cwspace.Datenklassen;

import org.json.JSONObject;

public class Room {
    String name;
    int numSeats;
    boolean belegt,fav;
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
    public Room (JSONObject jsonObject)
    {
        try {
            name = jsonObject.getString("name");
            numSeats = jsonObject.getInt("numseats");
            bookings = jsonObject.getInt("bookings");
        }
        catch (Exception e)
        {
            name = "Fail";
            numSeats = 0;
            bookings = 0;
        }
    }

    public JSONObject store() {
        JSONObject object = new JSONObject();
        try {
            object.put("name", this.name);
            object.put("numSeats", this.numSeats);
            object.put("isBooked", this.belegt);
            object.put("isFavorite",this.fav);
            object.put("bookings",this.bookings);
        } catch (Exception e) {
            System.out.println ( e.getMessage());
        }
        return object;
    }
}

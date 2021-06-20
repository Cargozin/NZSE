package com.example.cwspace.Datenklassen;

import org.json.JSONObject;

public class Room {
    String name;
    int numSeats;
    boolean belegt,fav;
    int bookings;

    public void toggleBelegt(){
        if(belegt){
            belegt = false;
        }else{
            belegt = true;
        }
    }

    public void toggleFav(){
        if(fav){
            fav = false;
        }else{
            fav = true;
        }
    }

    public boolean getBelegt(){return belegt;}
    public boolean getFav(){return fav;}

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
            numSeats = jsonObject.getInt("numSeats");
            bookings = jsonObject.getInt("bookings");
            belegt= jsonObject.getBoolean("isBooked");
            fav = jsonObject.getBoolean("isFavorite");
        }
        catch (Exception e)
        {
            name = "Fail";
            numSeats = 0;
            bookings = 0;
            belegt = false;
            fav = false;
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

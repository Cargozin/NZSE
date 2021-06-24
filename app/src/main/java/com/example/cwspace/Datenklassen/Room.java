package com.example.cwspace.Datenklassen;

import android.location.Address;

import org.json.JSONObject;

public class Room {
    String name,address;
    int numSeats;
    boolean occupied,fav;
    int bookings,imageFile;



    public void toggleFav(){
        if(fav){
            fav = false;
        }else{
            fav = true;
        }
    }

    public boolean getOccupied(){return occupied;}
    public boolean getFav(){return fav;}
    public String getName() {
        return name;
    }
    public String getNumSeats(){
        return String.valueOf(numSeats);
    }
    public String getBookings(){return String.valueOf(bookings);}
    public String getAddress() {
        return address;
    }
    public int getImageFile(){return imageFile;}

    public void setName(String name) {
        this.name = name;
    }
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    public void setOccupied(){
        occupied = true;
        bookings=bookings+1;
    }
    public void setUnOccupied(){
        occupied = false;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public void setImageFile(int newImageFile){imageFile = newImageFile;}

    public Room(String newName, int newNumSeats, String newAddress,int newImageFile){
        name=newName;
        numSeats=newNumSeats;
        address = newAddress;
        occupied =false;
        bookings = 0;
        imageFile = newImageFile;
    }
    public Room (JSONObject jsonObject) {
        try {
            name = jsonObject.getString("name");
            address = jsonObject.getString("address");
            numSeats = jsonObject.getInt("numSeats");
            bookings = jsonObject.getInt("bookings");
            occupied = jsonObject.getBoolean("isBooked");
            fav = jsonObject.getBoolean("isFavorite");
            imageFile = jsonObject.getInt("imageFile");
        }
        catch (Exception e)
        {
            name = "Fail";
            address = "Bakdad Fischmarkt";
            numSeats = 0;
            bookings = 0;
            occupied = false;
            fav = false;
            imageFile = 0;
        }
    }

    public JSONObject store() {
        JSONObject object = new JSONObject();
        try {
            object.put("name", this.name);
            object.put("address",this.address);
            object.put("numSeats", this.numSeats);
            object.put("isBooked", this.occupied);
            object.put("isFavorite",this.fav);
            object.put("bookings",this.bookings);
            object.put("imageFile",this.imageFile);
        } catch (Exception e) {
            System.out.println ( e.getMessage());
        }
        return object;
    }
}

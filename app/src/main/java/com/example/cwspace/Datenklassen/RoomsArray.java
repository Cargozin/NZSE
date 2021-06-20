package com.example.cwspace.Datenklassen;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class RoomsArray {
    private static final ArrayList<Room> Arraylist = new ArrayList<>();

    private RoomsArray() {
        System.out.println("Objekt gebildet...");
    }

    public static ArrayList<Room> getInstance() {
        return Arraylist;
    }

    public static void sortByName(){
        RoomsArray.getInstance().sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
    public static void sortByPopularity(){
        RoomsArray.getInstance().sort((o1, o2) -> Integer.compare(o2.getBookings(), o1.getBookings()));
    }

    public static void store (Context c) {
        String fname="storedrooms.json";
        try {
            File myFile = new File( c.getApplicationContext().getExternalFilesDir("cwspace").getPath() +"/"+ fname);
            System.out.println ("*** Store:" + myFile.toString());
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            JSONArray jsonarray = new JSONArray();
            for (Room p: RoomsArray.getInstance()) // Schleife über alle Elemente
            {
                JSONObject object;
                object = p.store();
                jsonarray.put(object);
            }
            myOutWriter.append(jsonarray.toString());
            myOutWriter.close();
            fOut.close();
            Toast.makeText(c, RoomsArray.getInstance().size() + " werden gespeichert!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(c, e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    } // store

    public static void load(Context c) {

        String fname = "storedrooms.json";
        RoomsArray.getInstance().clear();
        StringBuilder alleausgaben = new StringBuilder();
        try {
            File myFile = new File( c.getApplicationContext().getExternalFilesDir("cwspace").getPath() +"/"+ fname);
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn, StandardCharsets.UTF_8.name()));
            String line;
            while ((line = myReader.readLine()) != null) {
                alleausgaben.append(line);
            }
            JSONArray jsonArray = new JSONArray(alleausgaben.toString());
            Toast.makeText(c, "Anzahl Räume: " + jsonArray.length(), Toast.LENGTH_LONG).show();

            Room room;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                room = new Room(jsonObject);
                RoomsArray.getInstance().add(room);
            }
        }
        catch (Exception e) {
            Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace(); }
    } // load

}
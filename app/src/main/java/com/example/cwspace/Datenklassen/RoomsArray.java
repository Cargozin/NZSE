package com.example.cwspace.Datenklassen;

import android.content.Context;
import android.widget.Toast;

import com.example.cwspace.R;

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
        System.out.println("Object created...");
    }

    public static ArrayList<Room> getInstance() {
        return Arraylist;
    }

    public static void sortByName(){
        RoomsArray.getInstance().sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
    public static void sortByPopularity(){
        RoomsArray.getInstance().sort((o1, o2) -> Integer.compare(Integer.parseInt(o2.getBookings()), Integer.parseInt(o1.getBookings())));
    }

    public static void store (Context c) {
        String fileName="storedRooms.json";
        try {
            File myFile = new File( c.getApplicationContext().getExternalFilesDir("cwspace").getPath() +"/"+ fileName);
            System.out.println ("*** Store:" + myFile.toString());
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            JSONArray jsonarray = new JSONArray();
            for (Room p: RoomsArray.getInstance()) // Loop over all Elements
            {
                JSONObject object;
                object = p.store();
                jsonarray.put(object);
            }
            myOutWriter.append(jsonarray.toString());
            myOutWriter.close();
            fOut.close();
            Toast.makeText(c, RoomsArray.getInstance().size() +" "+ c.getString(R.string.MessageArraySavedText), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(c, e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    } // store

    public static void load(Context c) {

        String fileName = "storedRooms.json";
        RoomsArray.getInstance().clear();
        StringBuilder allOutputs = new StringBuilder();
        try {
            File myFile = new File( c.getApplicationContext().getExternalFilesDir("cwspace").getPath() +"/"+ fileName);
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn, StandardCharsets.UTF_8.name()));
            String line;
            while ((line = myReader.readLine()) != null) {
                allOutputs.append(line);
            }
            JSONArray jsonArray = new JSONArray(allOutputs.toString());
            Toast.makeText(c, c.getString(R.string.NumberOfRoomsText) + ": " + jsonArray.length(), Toast.LENGTH_LONG).show();

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
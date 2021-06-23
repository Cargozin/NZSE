package com.example.cwspace.ui.CoWorkerPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

public class CwInfoRoom extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Room room = RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1));
        setContentView(R.layout.activity_inforoom);
        TextView showed_room_name = findViewById(R.id.showed_room_name);
        TextView showed_room_numSeats = findViewById(R.id.showed_room_numSeats);
        TextView showed_room_address = findViewById(R.id.showed_room_address);
        TextView showed_availability = findViewById(R.id.showed_room_availability);
        showed_room_name.setText(room.getName());
        showed_room_numSeats.setText(room.getNumSeats());
        showed_room_address.setText(room.getAddress());
        if(room.getOccupied()){
            showed_availability.setText("belegt");
            showed_availability.setTextColor(Color.RED);
        }else{
            showed_availability.setText("Verfügbar");
            showed_availability.setTextColor(Color.GREEN);
        }
    }

    public void bookClicked(View view){
        if (RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).getOccupied()){
            Toast.makeText(getApplicationContext(),"Raum bereits belegt",Toast.LENGTH_SHORT).show();
        }else{
            RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).setOccupied();
            Toast.makeText(getApplicationContext(), "Raum ist jezt gebucht", Toast.LENGTH_SHORT).show();
            RoomsArray.store(getApplicationContext());
        }
    }
    public void unbookClicked(View view){
        if (RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).getOccupied()){
            RoomsArray.getInstance().get(getIntent().getIntExtra("Position", -1)).setUnOccupied();
            Toast.makeText(getApplicationContext()," Raum wieder verfügbar", Toast.LENGTH_SHORT).show();
            RoomsArray.store(getApplicationContext());
        }else{
            Toast.makeText(getApplicationContext(),"Raum bereits frei",Toast.LENGTH_SHORT).show();
        }
    }
}
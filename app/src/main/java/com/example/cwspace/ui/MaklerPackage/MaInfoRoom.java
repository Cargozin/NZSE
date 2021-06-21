package com.example.cwspace.ui.MaklerPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

public class MaInfoRoom extends AppCompatActivity {
    TextView showed_room_name;
    TextView showed_room_numSeats;
    TextView showed_room_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_inforoom);
        Room room = RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1));
        showed_room_name = findViewById(R.id.showed_room_name);
        showed_room_numSeats = findViewById(R.id.showed_room_numSeats);
        showed_room_address = findViewById(R.id.showed_room_address);
        showed_room_name.setText(room.getName());
        showed_room_numSeats.setText(room.getNumSeats());
    }

    public void deleteClicked(View view){
        RoomsArray.getInstance().remove(getIntent().getIntExtra("Position",-1));
        Toast.makeText(getApplicationContext(), "Raum wurde gelöscht", Toast.LENGTH_SHORT).show();
    }
    public void editClicked(View view){
        RoomsArray.getInstance().get(getIntent().getIntExtra("Position", -1)).toggleBelegt();
        Toast.makeText(getApplicationContext()," Raum wieder verfügbar", Toast.LENGTH_SHORT).show();
    }
}
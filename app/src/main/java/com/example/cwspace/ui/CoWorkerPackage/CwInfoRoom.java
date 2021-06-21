package com.example.cwspace.ui.CoWorkerPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

public class CwInfoRoom extends AppCompatActivity {
    TextView showed_room_name;
    TextView showed_room_numSeats;
    TextView showed_room_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inforoom);
        showed_room_name = findViewById(R.id.showed_room_name);
        showed_room_numSeats = findViewById(R.id.showed_room_numSeats);
        showed_room_address = findViewById(R.id.showed_room_address);
        showed_room_name.setText(RoomsArray.getInstance().get(getIntent().getIntExtra("Position",0)).getName());
        showed_room_numSeats.setText(RoomsArray.getInstance().get(getIntent().getIntExtra("Position",0)).getNumSeats());
    }

    public void bookClicked(View view){
        RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).toggleBelegt();
        Toast.makeText(getApplicationContext(), "Raum ist jezt gebucht", Toast.LENGTH_SHORT).show();
    }
    public void unbookClicked(View view){
        RoomsArray.getInstance().get(getIntent().getIntExtra("Position", -1)).toggleBelegt();
        Toast.makeText(getApplicationContext()," Raum wieder verfügbar", Toast.LENGTH_SHORT).show();
    }
}
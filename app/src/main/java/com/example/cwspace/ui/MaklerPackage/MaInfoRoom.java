package com.example.cwspace.ui.MaklerPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;
import com.example.cwspace.ui.activities.Makler;

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
        ViewSwitcher viewSwitcherName = findViewById(R.id.switchEditInfo);
        viewSwitcherName.showNext();
        ConstraintLayout constraintLayout = viewSwitcherName.findViewById(R.id.maInfoTexts);
        EditText name=findViewById(R.id.edit_room_name),numSeats=findViewById(R.id.edit_room_numSeats),address=findViewById(R.id.edit_room_adress);
        name.setText(RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).getName());
        numSeats.setText(RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).getNumSeats());
        Toast.makeText(getApplicationContext(),"bearbeiten...", Toast.LENGTH_SHORT).show();
    }
    public void saveClicked(View view){
        EditText editName = findViewById(R.id.edit_room_name);
        EditText editNumseats = findViewById(R.id.edit_room_numSeats);
        EditText editAddress = findViewById(R.id.edit_room_adress);
        RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).setName(editName.getText().toString());
        RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).setNumSeats(Integer.parseInt(editNumseats.getText().toString()));
    }
}
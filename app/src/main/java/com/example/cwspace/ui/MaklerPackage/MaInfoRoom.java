package com.example.cwspace.ui.MaklerPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;
import com.example.cwspace.ui.activities.Makler;

public class MaInfoRoom extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_inforoom);
        Room room = RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1));
        TextView showed_room_name = findViewById(R.id.showed_room_name);
        TextView showed_room_numSeats = findViewById(R.id.showed_room_numSeats);
        TextView showed_room_address = findViewById(R.id.showed_room_address);
        TextView showed_room_availability = findViewById(R.id.showed_room_availability);
        ImageView showed_room_image = findViewById(R.id.showed_room_images);
        showed_room_name.setText(room.getName());
        showed_room_numSeats.setText(room.getNumSeats());
        showed_room_address.setText(room.getAddress());
        if(room.getImageFile()==1){
            showed_room_image.setImageResource(R.drawable.roomsimage01);
        }else  if(room.getImageFile()==2){
            showed_room_image.setImageResource(R.drawable.roomsimage02);
        }else if(room.getImageFile()==3){
            showed_room_image.setImageResource(R.drawable.roomsimage03);
        }
        if(room.getOccupied()){
            showed_room_availability.setText("belegt");
            showed_room_availability.setTextColor(Color.RED);
        }else{
            showed_room_availability.setText("Verfügbar");
            showed_room_availability.setTextColor(Color.GREEN);
        }
    }

    public void deleteClicked(View view){
        RoomsArray.getInstance().remove(getIntent().getIntExtra("Position",-1));
        Toast.makeText(getApplicationContext(), "Raum wurde gelöscht", Toast.LENGTH_SHORT).show();
        RoomsArray.store(getApplicationContext());
        startActivity(new Intent(getApplicationContext(),Makler.class));
    }
    public void editClicked(View view){
        ViewSwitcher viewSwitcherName = findViewById(R.id.switchEditInfo);
        viewSwitcherName.showNext();
        Room room = RoomsArray.getInstance().get(getIntent().getIntExtra("Position", -1));
        ConstraintLayout constraintLayout = viewSwitcherName.findViewById(R.id.maInfoTexts);
        EditText name=findViewById(R.id.edit_room_name),numSeats=findViewById(R.id.edit_room_numSeats),address=findViewById(R.id.edit_room_adress);
        TextView editAvailability = findViewById(R.id.edit_room_availability);
        name.setText(room.getName());
        numSeats.setText(room.getNumSeats());
        address.setText(room.getAddress());
        ImageView image = findViewById(R.id.edit_room_images);
        if(room.getImageFile()==1){
            image.setImageResource(R.drawable.roomsimage01);
        }else  if(room.getImageFile()==2){
            image.setImageResource(R.drawable.roomsimage02);
        }else if(room.getImageFile()==3){
            image.setImageResource(R.drawable.roomsimage03);
        }
        if(room.getOccupied()){
            editAvailability.setText("belegt");
            editAvailability.setTextColor(Color.RED);
        }else{
            editAvailability.setText("Verfügbar");
            editAvailability.setTextColor(Color.GREEN);
        }
        Toast.makeText(getApplicationContext(),"bearbeiten...", Toast.LENGTH_SHORT).show();
    }
    public void saveClicked(View view){
        EditText editName = findViewById(R.id.edit_room_name);
        EditText editNumSeats = findViewById(R.id.edit_room_numSeats);
        EditText editAddress = findViewById(R.id.edit_room_adress);
        RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).setName(editName.getText().toString());
        RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).setNumSeats(Integer.parseInt(editNumSeats.getText().toString()));
        RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).setAddress(editAddress.getText().toString());
        Toast.makeText(getApplicationContext(),"gespeichert",Toast.LENGTH_SHORT).show();
        RoomsArray.store(getApplicationContext());
        startActivity(new Intent(getApplicationContext(),Makler.class));
    }
}
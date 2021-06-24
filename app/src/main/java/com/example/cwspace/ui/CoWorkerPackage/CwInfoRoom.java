package com.example.cwspace.ui.CoWorkerPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
        ImageView showed_room_image = findViewById(R.id.showed_room_images);
        if(room.getImageFile()==1){
            showed_room_image.setImageResource(R.drawable.roomsimage01);
        }else  if(room.getImageFile()==2){
            showed_room_image.setImageResource(R.drawable.roomsimage02);
        }else if(room.getImageFile()==3){
            showed_room_image.setImageResource(R.drawable.roomsimage03);
        }
        showed_room_name.setText(room.getName());
        showed_room_numSeats.setText(room.getNumSeats());
        showed_room_address.setText(room.getAddress());
        if(room.getOccupied()){
            showed_availability.setText(R.string.OccupiedText);
            showed_availability.setTextColor(Color.RED);
        }else{
            showed_availability.setText(R.string.AvailableText);
            showed_availability.setTextColor(Color.GREEN);
        }
    }

    public void bookClicked(View view){
        if (RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).getOccupied()){
            Toast.makeText(getApplicationContext(),R.string.ErrorRoomOccupiedText,Toast.LENGTH_SHORT).show();
        }else{
            RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).setOccupied();
            Toast.makeText(getApplicationContext(), R.string.MessageRoomNowOccupiedText, Toast.LENGTH_SHORT).show();
            RoomsArray.store(getApplicationContext());
            Intent intent = new Intent(getApplicationContext(), CwInfoRoom.class);
            intent.putExtra("Position",getIntent().getIntExtra("Position",-1));
            startActivity(intent);
        }
    }
    public void unbookClicked(View view){
        if (RoomsArray.getInstance().get(getIntent().getIntExtra("Position",-1)).getOccupied()){
            RoomsArray.getInstance().get(getIntent().getIntExtra("Position", -1)).setUnOccupied();
            Toast.makeText(getApplicationContext(),R.string.MessageRoomNowFree, Toast.LENGTH_SHORT).show();
            RoomsArray.store(getApplicationContext());
            Intent intent = new Intent(getApplicationContext(), CwInfoRoom.class);
            intent.putExtra("Position",getIntent().getIntExtra("Position",-1));
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),R.string.ErrorRoomFree,Toast.LENGTH_SHORT).show();
        }
    }
}
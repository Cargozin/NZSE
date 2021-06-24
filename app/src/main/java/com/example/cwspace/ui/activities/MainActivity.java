package com.example.cwspace.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cwspace.Datenklassen.RoomsArray;

import com.example.cwspace.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoomsArray.load(getApplicationContext());
    }

    public void cwClicked(View view){
        Intent intent = new Intent(this, CoWorker.class);
        startActivity(intent);
    }
    public void maClicked(View view){
        Intent intent = new Intent(this, Makler.class);
        startActivity(intent);
    }

}
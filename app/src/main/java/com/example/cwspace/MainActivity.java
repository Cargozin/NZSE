package com.example.cwspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cwClicked(View view){
        Intent intent = new Intent(this, CoWorker.class);
        startActivity(intent);
    }
    public void maClicked(View view){
        //Intent intent = new Intent(this, makler.class);
        //startActivity(intent);
    }

}
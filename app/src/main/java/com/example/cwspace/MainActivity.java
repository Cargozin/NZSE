package com.example.cwspace;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    private Button coworkerB;
    private Button maklerB;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coworkerB = findViewById(R.id.buttonCoworker);
        coworkerB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Code here executes after pressing button
                setContentView(R.layout.activity_cw_nav);
            }
        });

        maklerB = findViewById(R.id.buttonMakler);
        maklerB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Code here executes after pressing button
                //setContentView(R.layout.makler);
            }
        });

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.buttonMakler, R.id.buttonCoworker).build();
    }

}
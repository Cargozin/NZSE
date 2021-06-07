package com.example.cwspace.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;
import com.example.cwspace.ui.MaklerPackage.MaAddFragment;
import com.example.cwspace.ui.MaklerPackage.MaHomeFragment;
import com.example.cwspace.ui.MaklerPackage.MaStatsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Makler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makler);

        BottomNavigationView bottomNavigationView = findViewById(R.id.ma_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.ma_fragment_container,new MaHomeFragment()).commit();
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            item -> {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.nav_ma_home:
                        selectedFragment = new MaHomeFragment();
                        break;
                    case R.id.nav_ma_add:
                        selectedFragment = new MaAddFragment();
                        break;
                    case R.id.nav_ma_stats:
                        selectedFragment = new MaStatsFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.ma_fragment_container,selectedFragment).commit();
                return true;
            };

    public void maSaveClicked(View view) {
        EditText nameEdit = view.findViewById(R.id.new_room_name);
        String name="lol";
        try {
            name = String.valueOf(nameEdit.getText());
        }catch (Exception e){
            Toast toast = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
            toast.show();
        }

        EditText numSeatsEdit = view.findViewById(R.id.editTextNumberSeats);
        int numSeats=0;
        try {
            numSeats=Integer.parseInt(numSeatsEdit.getText().toString());
        }catch (Exception e){
            Toast toast = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
            toast.show();
        }

        RoomsArray.getInstance().add(new Room(name,numSeats));

        Toast toast1 = Toast.makeText(this, "Saved", Toast.LENGTH_SHORT);
        toast1.show();
    }
}
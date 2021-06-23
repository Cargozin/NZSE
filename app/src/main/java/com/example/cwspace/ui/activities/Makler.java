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
                        RoomsArray.sortByPopularity();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.ma_fragment_container,selectedFragment).commit();
                return true;
            };

    public void maSaveClicked(View view) {
        EditText editName=findViewById(R.id.new_room_name);
        EditText editNumSeats=findViewById(R.id.editTextNumberSeats);
        EditText editAddress = findViewById(R.id.edit_address);
        if (editName.getText().toString().length()==0){
            Toast.makeText(this,"Name is Empty",Toast.LENGTH_SHORT).show();
        }
        if (editAddress.getText().toString().length()==0){
            Toast.makeText(this,"Address is Empty",Toast.LENGTH_SHORT).show();
        }
        if (editNumSeats.getText().toString().length()==0){
            Toast.makeText(this, "NumSeats is Empty", Toast.LENGTH_SHORT).show();
        }else{
            RoomsArray.getInstance().add(new Room(editName.getText().toString(),Integer.parseInt(editNumSeats.getText().toString()),editAddress.getText().toString()));
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }

    }
}
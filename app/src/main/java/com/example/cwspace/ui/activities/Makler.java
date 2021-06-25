package com.example.cwspace.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        RadioGroup imageOptions = findViewById(R.id.imageSwitchMaAdd);
        RadioButton selectedImageButton = findViewById(imageOptions.getCheckedRadioButtonId());
        int imageId=0;
        if (selectedImageButton == findViewById(R.id.radioButtonImage01)){
            imageId = 1;
        }else if(selectedImageButton == findViewById(R.id.radioButtonImage02)){
            imageId = 2;
        }else if(selectedImageButton == findViewById(R.id.radioButtonImage03)){
            imageId = 3;
        }

        if (editName.getText().toString().equals("")){
            Toast.makeText(this,R.string.ErrorNoNameText,Toast.LENGTH_SHORT).show();
        } else if (editAddress.getText().toString().equals("")){
            Toast.makeText(this,R.string.ErrorNoAddress,Toast.LENGTH_SHORT).show();
        } else if (imageId==0){
            Toast.makeText(getApplicationContext(),R.string.ErrorNoPicture,Toast.LENGTH_SHORT).show();
        } else if (editNumSeats.getText().toString().length()==0){
            Toast.makeText(this, R.string.ErrorNoNumSeats, Toast.LENGTH_SHORT).show();
        }else{
            RoomsArray.getInstance().add(new Room(editName.getText().toString(),Integer.parseInt(editNumSeats.getText().toString()),editAddress.getText().toString(),imageId));
            Toast.makeText(this, R.string.SavedText, Toast.LENGTH_SHORT).show();
            RoomsArray.store(getApplicationContext());
            startActivity(new Intent(getApplicationContext(),Makler.class));
        }
    }
}
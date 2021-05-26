package com.example.cwspace.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.cwspace.Menu.MaHomeFragment;
import com.example.cwspace.Menu.AddFragment;
import com.example.cwspace.Menu.MaStatsFragment;
import com.example.cwspace.R;
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
                        selectedFragment = new AddFragment();
                        break;
                    case R.id.nav_ma_stats:
                        selectedFragment = new MaStatsFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.ma_fragment_container,selectedFragment).commit();
                return true;
            };
}
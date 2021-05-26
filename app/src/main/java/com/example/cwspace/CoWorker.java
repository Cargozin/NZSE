package com.example.cwspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class CoWorker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_worker);

        BottomNavigationView bottomNavigationView = findViewById(R.id.cw_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.cw_fragment_container,new HomeFragment()).commit();
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            item -> {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.nav_cw_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_cw_search:
                        selectedFragment = new SearchFragment();
                        break;
                    case R.id.nav_cw_stats:
                        selectedFragment = new StatisticsFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.cw_fragment_container,selectedFragment).commit();
                return true;
            };
}
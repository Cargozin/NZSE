package com.example.cwspace.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.cwspace.R;
import com.example.cwspace.ui.CoWorkerPackage.CwHomeFragment;
import com.example.cwspace.ui.CoWorkerPackage.CwSearchFragment;
import com.example.cwspace.ui.CoWorkerPackage.CwStatisticsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CoWorker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_worker);

        BottomNavigationView bottomNavigationView = findViewById(R.id.cw_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.cw_fragment_container,new CwHomeFragment()).commit();
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            item -> {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.nav_cw_home:
                        selectedFragment = new CwHomeFragment();
                        break;
                    case R.id.nav_cw_search:
                        selectedFragment = new CwSearchFragment();
                        break;
                    case R.id.nav_cw_stats:
                        selectedFragment = new CwStatisticsFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.cw_fragment_container,selectedFragment).commit();
                return true;
            };
}
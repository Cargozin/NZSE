package com.example.cwspace;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cwspace.databinding.ActivityCwNavBinding;

public class cw_nav extends AppCompatActivity {

    private ActivityCwNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCwNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView cwNavView = findViewById(R.id.cw_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_cwhome, R.id.navigation_cwsearch, R.id.navigation_cwstats)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_cw_nav);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.cwNavView, navController);
    }

}
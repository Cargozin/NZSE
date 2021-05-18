package com.example.cwspace;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cwspace.databinding.ActivityMaNavBinding;

public class ma_nav extends AppCompatActivity {

    private ActivityMaNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView maNavView = findViewById(R.id.ma_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_mahome, R.id.navigation_maroom, R.id.navigation_mastats)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_ma_nav);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.maNavView, navController);
    }

}
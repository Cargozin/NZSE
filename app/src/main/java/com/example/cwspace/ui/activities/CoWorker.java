package com.example.cwspace.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;       //searchbar
import android.view.MenuItem;           //searchbar
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import com.example.cwspace.Adapter.RecyclerviewRoomsAdapter;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;
import com.example.cwspace.ui.CoWorkerPackage.CwHomeFragment;
import com.example.cwspace.ui.CoWorkerPackage.CwSearchFragment;
import com.example.cwspace.ui.CoWorkerPackage.CwStatisticsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CoWorker extends AppCompatActivity {

    private RecyclerviewRoomsAdapter adapter;

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
                        RoomsArray.sortByName();
                        break;
                    case R.id.nav_cw_search:
                        selectedFragment = new CwSearchFragment();
                        break;
                    case R.id.nav_cw_stats:
                        selectedFragment = new CwStatisticsFragment();
                        RoomsArray.sortByName();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.cw_fragment_container,selectedFragment).commit();
                return true;
            };

    /*
    //Searchbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cw_searchbar, menu);

        MenuItem searchItem = menu.findItem(R.id.searchRequest);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
     */


}
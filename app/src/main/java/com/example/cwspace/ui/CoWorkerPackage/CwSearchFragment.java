package com.example.cwspace.ui.CoWorkerPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cwspace.Adapter.RecyclerviewRoomsAdapter;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

public class CwSearchFragment extends Fragment {
    View root;
    RecyclerView recyclerView;
    ImageButton searchButton;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_cw_search,container,false);
        recyclerView = root.findViewById(R.id.show_searched_roomlist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerviewRoomsAdapter adapter = new RecyclerviewRoomsAdapter(getContext(),RoomsArray.getInstance());
        recyclerView.setAdapter(adapter);
        return root;
    }

    public void searchClicked(View view){
        
    }
}

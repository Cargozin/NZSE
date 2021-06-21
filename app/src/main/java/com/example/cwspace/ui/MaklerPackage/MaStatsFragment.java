package com.example.cwspace.ui.MaklerPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cwspace.Adapter.RecyclerviewCWRoomsAdapter;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

public class MaStatsFragment extends Fragment {
    View root;
    RecyclerView recyclerView;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_ma_stats,container,false);
        recyclerView = root.findViewById(R.id.show_mastats_roomlist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerviewCWRoomsAdapter adapter = new RecyclerviewCWRoomsAdapter(getContext(), RoomsArray.getInstance());
        recyclerView.setAdapter(adapter);
        return root;
    }
}
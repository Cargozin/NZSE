package com.example.cwspace.ui.CoWorkerPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cwspace.Adapter.RecyclerviewBookedRoomsAdapter;
import com.example.cwspace.Adapter.RecyclerviewFavRoomsAdapter;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

public class CwStatisticsFragment extends Fragment {
    View root;
    RecyclerView recyclerView1,recyclerView2;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_cw_statistic,container,false);
        recyclerView1 = root.findViewById(R.id.show_booked_roomlist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager);
        RecyclerviewBookedRoomsAdapter adapter = new RecyclerviewBookedRoomsAdapter(getContext(),RoomsArray.getInstance());
        recyclerView1.setAdapter(adapter);
        recyclerView2 = root.findViewById(R.id.show_fav_roomlist);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(layoutManager1);
        RecyclerviewFavRoomsAdapter adapter1 = new RecyclerviewFavRoomsAdapter(getContext(),RoomsArray.getInstance());
        recyclerView2.setAdapter(adapter1);
        return root;
    }
}

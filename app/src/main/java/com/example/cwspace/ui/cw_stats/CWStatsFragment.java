package com.example.cwspace.ui.cw_stats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cwspace.databinding.FragmentCwstatsBinding;

public class CWStatsFragment extends Fragment {

    private CWStatsViewModel statsViewModel;
    private FragmentCwstatsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statsViewModel =
                new ViewModelProvider(this).get(CWStatsViewModel.class);

        binding = FragmentCwstatsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCwstats;
        statsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
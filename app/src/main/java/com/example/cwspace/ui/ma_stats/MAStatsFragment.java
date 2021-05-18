package com.example.cwspace.ui.ma_stats;

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

import com.example.cwspace.databinding.FragmentMastatsBinding;

public class MAStatsFragment extends Fragment {

    private MAStatsViewModel statsViewModel;
    private FragmentMastatsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        statsViewModel =
                new ViewModelProvider(this).get(MAStatsViewModel.class);

    binding = FragmentMastatsBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textMastats;
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
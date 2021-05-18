package com.example.cwspace.ui.ma_home;

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

import com.example.cwspace.databinding.FragmentMahomeBinding;

public class MAHomeFragment extends Fragment {

    private MAHomeViewModel homeViewModel;
    private FragmentMahomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(MAHomeViewModel.class);

    binding = FragmentMahomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textMahome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
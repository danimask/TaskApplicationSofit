package com.allfile.viewer.free.taskapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allfile.viewer.free.taskapplication.databinding.FragmentServicesBinding;


public class ServicesFragment extends Fragment {
    private FragmentServicesBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentServicesBinding.inflate(getLayoutInflater());
        View rootview = binding.getRoot();
        return rootview;
    }
}

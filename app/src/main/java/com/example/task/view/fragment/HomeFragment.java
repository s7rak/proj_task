package com.example.task.view.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task.R;
import com.example.task.databinding.FragmentHomeBinding;
import com.example.task.view_model.HomeViewModel;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);

        

        binding.setLifecycleOwner(getViewLifecycleOwner());

        HomeViewModel mViewModel = new HomeViewModel();

        binding.setHomeViewModel(mViewModel);

        mViewModel.getHajjiDate();

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
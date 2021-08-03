package com.example.task.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task.R;
import com.example.task.databinding.FragmentHomeBinding;
import com.example.task.view.activity.MainActivity;
import com.example.task.view.dialog.AddEventDialog;
import com.example.task.view_model.HomeViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private MainActivity mainActivity;
    private FragmentHomeBinding binding;
    private HomeViewModel mViewModel;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        mainActivity = (MainActivity) getActivity(); // parent fragment

        binding.setLifecycleOwner(getViewLifecycleOwner()); // listen to all live data in this view model

        mViewModel = new HomeViewModel();

        binding.setHomeViewModel(mViewModel); // set view model to Home fragment

        binding.btnConvert.setOnClickListener(this);

        binding.btnAddEvent.setOnClickListener(this);

        binding.btnAllEvent.setOnClickListener(this);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {

        final int id = view.getId();

        if (id == binding.btnConvert.getId()) {
            if(binding.etDate.getText().toString().matches("\\d{2}-\\d{2}-\\d{4}")){
                mViewModel.getHajjiDate(Objects.requireNonNull(binding.etDate.getText()).toString(), 0);

                binding.btnAddEvent.setVisibility(View.VISIBLE);
            }
            else
            {
                binding.etDate.setError("DD-MM-yyyy");
            }

        } else if (id == binding.btnAddEvent.getId()) {

            new AddEventDialog(requireActivity(),
                    Objects.requireNonNull(binding.etDate.getText()).toString(),
                    mViewModel.getHajjiLiveData().getValue()).show();
        } else if (id == binding.btnAllEvent.getId())
            mainActivity.navController.navigate(R.id.eventsFragment);

    }


}


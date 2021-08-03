package com.example.task.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.task.Utility.room_db.DatabaseClient;
import com.example.task.databinding.FragmentEventsBinding;
import com.example.task.model.Event;
import com.example.task.view.adapter.AdapterEvents;
import com.example.task.view.adapter.OnEditListener;
import com.example.task.view.adapter.OnRemoveListener;
import com.example.task.view.dialog.DialogEditEvent;
import com.example.task.view_model.EventsViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;


public class EventsFragment extends Fragment implements OnRemoveListener, OnEditListener, OnFinishListener {

    private AdapterEvents adapterEvents;

    private EventsViewModel viewModel;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentEventsBinding binding = FragmentEventsBinding.inflate(inflater, container, false);

        viewModel = new EventsViewModel();

        adapterEvents = new AdapterEvents();
        adapterEvents.setOnEditListener(this);
        adapterEvents.setOnRemoveListener(this);

        binding.recEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recEvent.setAdapter(adapterEvents);

        viewModel.getEventsLiveData(getContext()).observe(getViewLifecycleOwner(), events -> adapterEvents.setList(events));


        return binding.getRoot();
    }

    /**
     *
     * when click to button edi event this method called
     * */
    @Override
    public void onEdit(Event event) {

        new DialogEditEvent(requireContext(), event, this).show(); // open dialog edit event

    }

    /**
     *
     * when click to button delete event this method called
     * */
    @Override
    public void onRemove(Event event) {

        Executors.newSingleThreadExecutor().execute(() -> {

            DatabaseClient
                    .getInstance(getContext())
                    .getAppDatabase()
                    .eventDao().delete(event);

            viewModel.getEventsLiveData(getContext()); // refresh list events
        });

    }

    /**
     * when task updated  this method called
     * */
    @Override
    public void onFinishUpdate() {
        viewModel.getEventsLiveData(getContext()); // refresh list events
    }
}
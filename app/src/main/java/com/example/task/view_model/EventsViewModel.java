package com.example.task.view_model;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.task.Utility.room_db.DatabaseClient;
import com.example.task.model.Event;

import java.util.List;
import java.util.concurrent.Executors;

public class EventsViewModel extends ViewModel {


    private final MutableLiveData<List<Event>> eventsLiveData = new MutableLiveData<>();

   public MutableLiveData<List<Event>> getEventsLiveData(Context context){

       Executors.newSingleThreadExecutor().execute(() -> {
           eventsLiveData.postValue(DatabaseClient.getInstance(context)
                   .getAppDatabase().eventDao().getAll());
       });

       return  eventsLiveData;
    }
}

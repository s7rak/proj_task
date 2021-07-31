package com.example.task.Utility.room_db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.task.Utility.room_db.dao.EventDao;
import com.example.task.model.Event;

@Database(entities = { Event.class }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

}
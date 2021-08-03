package com.example.task.Utility.room_db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.task.model.Event;

import java.util.List;

@Dao
public interface EventDao {

    @Query("SELECT * FROM events")
    List<Event> getAll();

    @Insert
    void insert(Event event);

    @Delete
    void delete(Event event);


    @Update
    void update(Event event);

}

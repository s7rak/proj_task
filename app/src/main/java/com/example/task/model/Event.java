package com.example.task.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@SuppressWarnings("unused")
@Entity(tableName = "events")
public class Event implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "event_name")
    private String eventName;

    @ColumnInfo(name = "event_description")
    private String eventDescription ;

    @ColumnInfo(name = "Gregorian_date")
    private String GregorianDate ;

    @ColumnInfo(name = "Hijri_date")
    private String HijriDate ;

    @ColumnInfo(name = "server_datetime")
    private String serverDatetime ;


    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getGregorianDate() {
        return GregorianDate;
    }

    public String getHijriDate() {
        return HijriDate;
    }

    public String getServerDatetime() {
        return serverDatetime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setGregorianDate(String gregorianDate) {
        GregorianDate = gregorianDate;
    }

    public void setHijriDate(String hijriDate) {
        HijriDate = hijriDate;
    }

    public void setServerDatetime(String serverDatetime) {
        this.serverDatetime = serverDatetime;
    }
}

package com.androidapp.mcs.student_info_room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.provider.SyncStateContract;
//This class must return an object of the Dao
//This class represents database

@Database(entities ={User.class},version = 1, exportSchema = false)

public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}

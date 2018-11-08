package com.androidapp.mcs.student_info_room;

import android.arch.persistence.room.Dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert    //Database insertion operation
    public void addUser(User user);

    @Query("select * from users") //Data access operation
    public List<User> getUsers();

}

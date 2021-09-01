package com.example.livedataapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    long insert(User user);

    @Query("delete from user where userName=:userName")
    int deleteByUserName(String  userName);

    @Query("delete from user")
    void deleteAll();

    @Update
    void update(User newUser);


    @Query("select * from user")
    LiveData<List<User>> loadAllUser();


}

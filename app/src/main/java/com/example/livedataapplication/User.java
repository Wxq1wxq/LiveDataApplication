package com.example.livedataapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {


    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int userId;

    @ColumnInfo(name="userName")
    @NonNull
    private  String userName;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public User(@NonNull String userName) {

        this.userName = userName;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }
}

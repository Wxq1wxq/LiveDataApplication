package com.example.livedataapplication;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities =User.class,version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    abstract UserDao dao();
    private static  UserDatabase INSTANCE = null;
    public static final ExecutorService userService= Executors.newFixedThreadPool(4);


   public static UserDatabase getInstance(Application application){
       if (INSTANCE==null){
           synchronized (UserDatabase.class){
               if (INSTANCE==null){
                   INSTANCE= Room.databaseBuilder(application,UserDatabase.class,"userDatabase").build();
               }
           }
       }
       return INSTANCE;
   }




}

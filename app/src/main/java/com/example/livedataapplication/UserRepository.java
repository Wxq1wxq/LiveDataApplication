package com.example.livedataapplication;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao dao;
    private LiveData<List<User>> users;

    public UserRepository(Application application) {
        UserDatabase db=UserDatabase.getInstance(application);
        dao=db.dao();
        users=dao.loadAllUser();
    }

    public LiveData<List<User>> getUsers(){
        return users;
    }

    void insert(User user ){
        UserDatabase.userService.execute(()->{
            dao.insert(user);
        });
    }

    void deleteByUserName(String userName){
        UserDatabase.userService.execute(()->{
            dao.deleteByUserName(userName);
        });
    }
    void deleteAll(){
        UserDatabase.userService.execute(()->{
            dao.deleteAll();
        });
    }
}

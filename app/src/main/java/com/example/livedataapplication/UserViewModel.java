package com.example.livedataapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class UserViewModel extends ViewModel {
   private LiveData<List<User>> users;
   private UserRepository repository;

    public UserViewModel(Application application) {
        repository=new UserRepository(application);
        users=repository.getUsers();
    }
    public LiveData<List<User>> getUsers(){
        return users;
    }

    public void insert(User user){
        repository.insert(user);
        Log.d("wxq", "viewModel insert成功: "+user.getUserName());
    }
    public void deleteAll(){
        repository.deleteAll();
    }

}

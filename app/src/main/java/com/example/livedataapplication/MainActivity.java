package com.example.livedataapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rv;
FloatingActionButton floatBtn;
UserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button delete_btn=findViewById(R.id.delete_btn);
        rv=findViewById(R.id.main_rv);
        floatBtn=findViewById(R.id.floatBtn);
        MyAdapter adapter=new MyAdapter(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        viewModel=new ViewModelProvider(this, new MainViewModelFactory(getApplication())).get(UserViewModel.class);
        viewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setmUsers(users);
                for (User user:users){
                    Log.d("wxq", "数据改变onChanged: "+user.getUserName());
                }

            }
        });
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,1);
            }
        });



        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteAll();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            User user=new User(name);
            viewModel.insert(user);
            Log.d("wxq", "main: "+name);
        }else{
            Toast.makeText(this, "没有输入name", Toast.LENGTH_SHORT).show();
        }
    }
    class MainViewModelFactory implements ViewModelProvider.Factory {
        Application application;

        public MainViewModelFactory(Application application) {
            this.application = application;
        }
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull  Class<T> modelClass) {
           UserViewModel viewModel= new UserViewModel(application);
            return (T)viewModel;
        }
    }
}
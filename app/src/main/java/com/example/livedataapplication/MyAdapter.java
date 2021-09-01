package com.example.livedataapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
Context context;

List<User> mUsers=null;

    public MyAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {
        Log.d("wxq", "onbind");

        if (mUsers!=null){
                User user=mUsers.get(position);
                holder.name_tv.setText(user.getUserName());
            }else{
                holder.name_tv.setText("NO User");
            }
    }


    public void setmUsers(List<User> list){
        mUsers=list;
        notifyDataSetChanged();
        Log.d("wxq", "setmUsers:notifyDataSetChanged ");
    }

    @Override
    public int getItemCount() {
        Log.d("wxq", "getitems");
        if (mUsers==null){
            return 0;
        }else{
            return mUsers.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name_tv;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            name_tv=itemView.findViewById(R.id.userName);
        }
    }



}

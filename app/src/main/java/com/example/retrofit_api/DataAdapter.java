package com.example.retrofit_api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    List<hero> heroList;
    public DataAdapter(ArrayList<hero> list) {
this.heroList=list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userid.setText(heroList.get(position).getUserid());
        holder.id.setText(heroList.get(position).getId());
        holder.title.setText(heroList.get(position).getTitle());
        holder.body.setText(heroList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userid,id,title,body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        userid=itemView.findViewById(R.id.userid);
        id=itemView.findViewById(R.id.id);
        title=itemView.findViewById(R.id.title);
        body=itemView.findViewById(R.id.body);
        }
    }
}

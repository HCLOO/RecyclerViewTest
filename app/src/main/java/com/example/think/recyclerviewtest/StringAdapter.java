package com.example.think.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Think on 2018/3/19.
 */

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.ViewHolder> {

    List<DataType> mdatas;

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        View clickView;

        public ViewHolder(View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.textView);
            clickView=itemView;
        }
    }

    public StringAdapter(List<DataType> datas) {
        mdatas=datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.child_title,parent,false);
        final ViewHolder holder=new ViewHolder(view);

        //几乎可以为任意控件注册点击事件
        holder.clickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                DataType data=mdatas.get(position);
                Toast.makeText(view.getContext(),"YOU CLICKED view: "+data.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataType data=mdatas.get(position);
        holder.text.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }
}

package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterclass extends RecyclerView.Adapter<adapterclass.MyViewHolder> {

    Context context;
    private List<dataclass> PropertyList;

    public adapterclass (List<dataclass>PropertyList, Context context){ this .PropertyList=PropertyList;
    this.context=context;}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.page_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int profile= PropertyList.get(position).getImageview1();
        String username= PropertyList.get(position).getTextview();
        String location= PropertyList.get(position).getTextview2();
        String property= PropertyList.get(position).getTextview3();
        String mobile= PropertyList.get(position).getTextview4();

         holder.updateui(profile,username,location,property,mobile);

    }

    @Override
    public int getItemCount() {
        return PropertyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
         ImageView imageView;
         TextView textView;
         TextView textView2;
         TextView textView3;
         TextView textView4;

        public MyViewHolder(@NonNull View view) {
            super(view);

            imageView= view.findViewById(R.id.imageview1);
            textView= view.findViewById(R.id.textView);
            textView2= view.findViewById(R.id.textView2);
            textView3= view.findViewById(R.id.textView3);
            textView4= view.findViewById(R.id.textView4);
        }

        public void updateui(int profile, String username, String location, String property, String mobile) {
            imageView.setImageResource(profile);
            textView.setText(username);
            textView2.setText(location);
            textView3.setText(property);
            textView4.setText(mobile);
        }
    }
}

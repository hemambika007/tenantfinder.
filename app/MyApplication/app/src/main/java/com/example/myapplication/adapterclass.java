package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterclass extends RecyclerView.Adapter<adapterclass.MyViewHolder> {

    private List<dataclass> PropertyList;

    public adapterclass (List<dataclass>PropertyList){ this .PropertyList=PropertyList; }

    public static void notifyDataSetchanged() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.page_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int profile= PropertyList.get(position).getImageview1();
        String username= PropertyList.get(position).getTextview();
        String location= PropertyList.get(position).getTextview2();
        String property= PropertyList.get(position).getTextview3();
        String mobile= PropertyList.get(position).getTextview4();
        String divider= PropertyList.get(position).getDivider();

         holder.updateui(profile,username,location,property,mobile,divider);

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
         TextView divider;

        public MyViewHolder(@NonNull View view) {
            super(view);

            imageView= view.findViewById(R.id.imageview1);
            textView= view.findViewById(R.id.textView);
            textView2= view.findViewById(R.id.textView2);
            textView3= view.findViewById(R.id.textView3);
            textView4= view.findViewById(R.id.textView4);
            divider= view.findViewById(R.id.divider);
        }

        public void updateui(int profile, String username, String location, String property, String mobile, String divider) {
            imageView.setImageResource(profile);
            textView.setText(username);
            textView2.setText(location);
            textView3.setText(property);
            textView4.setText(mobile);
            

        }
    }
}

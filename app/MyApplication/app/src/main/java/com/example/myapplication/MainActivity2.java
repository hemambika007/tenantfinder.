package com.example.myapplication;

import android.database.DataSetObserver;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityMain2Binding;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<dataclass>PropertyList;
    adapterclass adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

    recyclerView=findViewById(R.id.recyclerView);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        initdata();
        initRecyclerView();
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                binding.fab.setOnClickListener(new View.OnClickListener() {  .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();

    }

    private void initdata() {

        PropertyList = new ArrayList<>();

        PropertyList.add(new dataclass(R.drawable.im1,"Ramesh","Hyderabad,Telangana.","Four storeyed building","Call for details:978xxxxx67","-----------------------------------------------------------------"));

        PropertyList.add(new dataclass(R.drawable.im2,"Aditya","Mumbai,Maharashtra.","Residential villa","Call for details:956xxxxx92","-----------------------------------------------------------------"));

        PropertyList.add(new dataclass(R.drawable.im3,"Divya","kolkata,West Bengal.","6 storeyed building ","Call for details:786xxxxx27","-----------------------------------------------------------------"));

        PropertyList.add(new dataclass(R.drawable.im4,"Vijay Prakash","Sangareddy,Telangana.","plot available in commercial building ","Call for details:732xxxxx54","-----------------------------------------------------------------"));

        PropertyList.add(new dataclass(R.drawable.im5,"Nivetha","Mangalore,Karnataka.","6 acres of agricultural land ","Call for details:895xxxxx27","-----------------------------------------------------------------"));

        PropertyList.add(new dataclass(R.drawable.im6,"Anmol","Indore,Madhya pradesh.","Duplex home in trinath ventures.","Call for details:996xxxxx61","-----------------------------------------------------------------"));

    }

    private void initRecyclerView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapterclass(PropertyList,this);
        recyclerView.setAdapter(adapter);
//        recyclerView.notifyDataSetchanged();

        }
    }


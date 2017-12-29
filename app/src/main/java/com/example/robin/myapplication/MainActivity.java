package com.example.robin.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Communicator{
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment1 fragment1 = new Fragment1();
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_activity,fragment1,"post");
        fragmentTransaction.commit();
    }


    /* @Override
    public void show(ArrayList<String> x) {


       Bundle bundle = new Bundle();
        bundle.putStringArrayList("comment",x);
        fragment2.setArguments(bundle);
        //fragment2.onActivityCreated(x);
        fragmentTransaction.commit();
     */
    }


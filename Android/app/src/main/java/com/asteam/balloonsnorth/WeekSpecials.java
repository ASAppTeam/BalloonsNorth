package com.asteam.balloonsnorth;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Data.Sale;
import Util.RVAdapter;

public class WeekSpecials extends AppCompatActivity {


    private List<Sale> Sales;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_specials);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        initialize();
    }

    private void initialize() {

        // Create action bar - START//
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        View view = getSupportActionBar().getCustomView();
        // Create action bar - END //

    }

    private void initializeData() {
        Sales = new ArrayList<>();
        Sales.add(new Sale("שם מבצע 1", "תיאור מבצע 1", R.mipmap.splash_img));
        Sales.add(new Sale("שם מבצע 2", "תיאור מבצע 2", R.mipmap.splash_img));
        Sales.add(new Sale("שם מבצע 3", "תיאור מבצע 3", R.mipmap.splash_img));
        Sales.add(new Sale("שם מבצע 4", "תיאור מבצע 4", R.mipmap.splash_img));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(Sales);
        rv.setAdapter(adapter);
    }
}
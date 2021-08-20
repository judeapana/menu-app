package com.application.menuapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.menuapp.models.Menu;
import com.application.menuapp.utils.CardAdapter;
import com.application.menuapp.utils.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);
        recyclerView = findViewById(R.id.recyclerView);
        Connection connection = new Connection(this);
        try {
            ArrayList<Menu> menuArrayList = (ArrayList<Menu>) connection.operation().queryForAll();
            CardAdapter cardAdapter = new CardAdapter(this, menuArrayList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(cardAdapter);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
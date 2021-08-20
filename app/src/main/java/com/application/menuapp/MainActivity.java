package com.application.menuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void intent_add_menu(View view) {
        startActivity(new Intent(MainActivity.this, AddMenuActivity.class));
    }

    public void intent_details_activity(View view) {
        startActivity(new Intent(this, MenuDetailsActivity.class));
    }
}
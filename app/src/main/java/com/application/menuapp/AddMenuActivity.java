package com.application.menuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.application.menuapp.models.Menu;
import com.application.menuapp.utils.Connection;

import java.sql.SQLException;

public class AddMenuActivity extends AppCompatActivity {

    private EditText dishName;
    private EditText tribeName;
    private EditText howPrepare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);
    }


    public void addMenu(View view) throws SQLException {
        dishName = findViewById(R.id.dishName);
        tribeName = findViewById(R.id.tribeName);
        howPrepare = findViewById(R.id.howToPrepare);
        String _dishName = dishName.getText().toString();
        String _tribeName = tribeName.getText().toString();
        String _howPrepare = howPrepare.getText().toString();

        if (_dishName.isEmpty()) {
            Toast toast = Toast.makeText(this, "Please Enter Name Of Dish", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            return;
        }

        if (_howPrepare.isEmpty()) {
            Toast toast = Toast.makeText(this, "Please Enter 'how to prepare'", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            return;
        }

        Menu menu = new Menu(_dishName, _tribeName, _howPrepare);
        Connection connection = new Connection(this);
        if (connection.operation().create(menu) != 1) {
            Toast.makeText(this, "An Error Occurred", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Menu item created", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MenuDetailsActivity.class));
            finish();
        }
    }


}
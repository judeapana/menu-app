package com.application.menuapp.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.menuapp.ChangeMenuActivity;
import com.application.menuapp.MainActivity;
import com.application.menuapp.R;
import com.application.menuapp.models.Menu;

import java.sql.SQLException;
import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.Viewholder> {

    private final Context context;
    private final ArrayList<Menu> menus;
    private Button edit_btn;
    private Button delete_btn;
    private Connection connection;

    public CardAdapter(Context context, ArrayList<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.Viewholder holder, int position) {
        Menu menu = menus.get(position);
        holder.dishName.setText(menu.getFoodName());
        holder.tribeName.setText(menu.getTribeName());
        holder.howToPrepare.setText(menu.getHowToPrepare());

        edit_btn = holder.itemView.findViewById(R.id._edit);
        edit_btn.setOnClickListener(v -> {
            Intent intent = new Intent(context.getApplicationContext(), ChangeMenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("menu", menu);
            context.getApplicationContext().startActivity(intent);

        });
        delete_btn = holder.itemView.findViewById(R.id._delete);
        delete_btn.setOnClickListener(v -> {
            connection = new Connection(context);
            try {
                connection.operation().delete(menu);
                Toast.makeText(context, "Item Delete", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context.getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                Toast.makeText(context, "Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView dishName;
        public TextView tribeName;
        public TextView howToPrepare;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            dishName = itemView.findViewById(R.id._dishName);
            tribeName = itemView.findViewById(R.id._tribeName);
            howToPrepare = itemView.findViewById(R.id._howToPrepare);
        }
    }


}
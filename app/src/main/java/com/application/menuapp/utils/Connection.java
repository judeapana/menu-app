package com.application.menuapp.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.application.menuapp.models.Menu;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Connection extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_URL = "diet_menu_app";
    private static final int VERSION = 2;
    public Dao<Menu, Long> _connection_;

    public Connection(Context context) {
        super(context, Connection.DATABASE_URL, null, Connection.VERSION);
        getWritableDatabase();
    }

    public Dao<Menu, Long> operation() {
        if (_connection_ == null) {
            try {
                _connection_ = getDao(Menu.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return _connection_;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Menu.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Menu.class, false);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

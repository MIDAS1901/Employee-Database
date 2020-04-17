package com.example.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataRepo {


    private DatabaseHelper dbHelper;

    public DataRepo(Context context) {
        dbHelper = new DatabaseHelper(context);
    }





}

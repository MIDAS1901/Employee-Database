package com.example.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "EmployeeDatabase";

    public DatabaseHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Data.TABLE  + "("
                + Data.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Data.KEY_name + " TEXT, "
                + Data.KEY_address + " TEXT, "
                + Data.KEY_pan + " TEXT )";

        db.execSQL(CREATE_TABLE_STUDENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Data.TABLE);

        onCreate(db);

    }
}


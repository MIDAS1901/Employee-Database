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

    public void insert(Data data) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Data.KEY_name, data.name);
        values.put(Data.KEY_address,data.address);
        values.put(Data.KEY_pan, data.pan);

        // Inserting Row
        db.insert(Data.TABLE, null, values);
        db.close(); // Closing database connection
    }

    public Cursor  getEmployeeList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                Data.KEY_ROWID + "," +
                Data.KEY_ID + "," +
                Data.KEY_name + "," +
                Data.KEY_address+ "," +
                Data.KEY_pan +
                " FROM " + Data.TABLE;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }





}

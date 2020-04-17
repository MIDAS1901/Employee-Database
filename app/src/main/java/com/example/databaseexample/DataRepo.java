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



    public Cursor  getEmployeeListByKeyword(String search) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                Data.KEY_ROWID + "," +
                Data.KEY_ID + "," +
                Data.KEY_name + "," +
                Data.KEY_address + "," +
                Data.KEY_pan +
                " FROM " + Data.TABLE +
                " WHERE " +  Data.KEY_name + "  LIKE  '%" +search + "%' "
                ;


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

    public Data getEmployeeById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT " +
                Data.KEY_ID + "," +
                Data.KEY_name + "," +
                Data.KEY_address + "," +
                Data.KEY_pan+
                " FROM " + Data.TABLE
                + " WHERE " +
                Data.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Data data = new Data();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                data.id =cursor.getInt(cursor.getColumnIndex(Data.KEY_ID));
                data.name =cursor.getString(cursor.getColumnIndex(Data.KEY_name));
                data.address  =cursor.getString(cursor.getColumnIndex(Data.KEY_address));
                data.pan =cursor.getString(cursor.getColumnIndex(Data.KEY_pan));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return data;
    }


}

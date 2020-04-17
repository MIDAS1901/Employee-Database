package com.example.databaseexample;

import java.io.Serializable;

public class Data implements Serializable {
    // Labels table name
    public static final String TABLE = "Employee";

    // Labels Table Columns names
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_address = "address";
    public static final String KEY_pan = "pan";

    // property help us to keep data
    public int id;
    public String name;
    public String address;
    public String pan;
}



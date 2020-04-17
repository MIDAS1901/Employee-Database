package com.example.databaseexample;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class EmployeeDataAdapter extends CursorAdapter {
    private LayoutInflater mInflater;
    TextView txtId,txtName,txtEmail;



    public EmployeeDataAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {



    }


}

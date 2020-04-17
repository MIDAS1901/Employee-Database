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
        View   view    =    mInflater.inflate(R.layout.activity_view_record, parent, false);
        ViewHolder holder  =   new ViewHolder();

        holder.txtName  = view.findViewById(R.id.name);
        holder.txtAddress  = view.findViewById(R.id.address);
        holder.txtPan  = view.findViewById(R.id.pan);

        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        ViewHolder holder  =   (ViewHolder)    view.getTag();
        holder.txtName.setText(cursor.getString(cursor.getColumnIndex("name")));
        holder.txtAddress.setText(cursor.getString(cursor.getColumnIndex("address")));
        holder.txtPan.setText(cursor.getString(cursor.getColumnIndex("pan")));

    }


    static class ViewHolder {
        TextView txtName;
        TextView txtAddress;
        TextView txtPan;
    }
}

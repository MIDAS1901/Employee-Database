package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private EmployeeDataAdapter employeeDataAdapter;
    ListView listView;
    Cursor cursor;
    DataRepo studentRepo ;
    private final static String TAG= MainActivity.class.getName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);
        studentRepo = new DataRepo(this);
        cursor=studentRepo.getEmployeeList();
        employeeDataAdapter = new EmployeeDataAdapter(MainActivity.this,  cursor, 0);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(employeeDataAdapter);

    }



    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String s) {
                    Log.d(TAG, "onQueryTextSubmit ");
                    cursor=studentRepo.getEmployeeListByKeyword(s);
                    if (cursor==null){
                        Toast.makeText(MainActivity.this,"No records found!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this, cursor.getCount() + " records found!",Toast.LENGTH_LONG).show();
                    }
                    employeeDataAdapter.swapCursor(cursor);

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.d(TAG, "onQueryTextChange ");
                    cursor=studentRepo.getEmployeeListByKeyword(s);
                    if (cursor!=null){
                        employeeDataAdapter.swapCursor(cursor);
                    }
                    return false;
                }

            });

        }

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       if(item.getItemId() == R.id.add_record){
           Intent intent = new Intent(this, AddEmployeeActivty.class);
           startActivity(intent);
       }

        return super.onOptionsItemSelected(item);
    }
}

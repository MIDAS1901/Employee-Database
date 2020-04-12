package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddEmployeeActivty extends AppCompatActivity {

    private EditText nameEditText;
    private EditText addressEditText;
    private EditText panEditText;

    private DatabaseHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        nameEditText = (EditText) findViewById(R.id.name_edittext);
        addressEditText = (EditText) findViewById(R.id.address_edittext);
        panEditText = (EditText) findViewById(R.id.pan_edittext);


        myHelper = new DatabaseHelper(this);
        myHelper.open();
    }

    public void addButtonPressed(View view) {
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String pan = panEditText.getText().toString();

        myHelper.add(name, address, pan);

        Intent main = new Intent(this, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        startActivity(main);
    }
}

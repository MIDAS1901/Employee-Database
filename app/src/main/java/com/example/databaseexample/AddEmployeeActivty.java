package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEmployeeActivty extends AppCompatActivity {


    private EditText nameEditText;
    private EditText addressEditText;
    private EditText panEditText;


    private DataRepo dataRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        dataRepo = new DataRepo(this);
        nameEditText = (EditText) findViewById(R.id.name_edittext);
        addressEditText = (EditText) findViewById(R.id.address_edittext);
        panEditText = (EditText) findViewById(R.id.pan_edittext);

        Button addButton = findViewById(R.id.add_record);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Data data= new Data();


                data.name = nameEditText.getText().toString();
                data.address = addressEditText.getText().toString();
                data.pan = panEditText.getText().toString();


                dataRepo.insert(data);
                dataRepo.insert(data);

                Intent main = new Intent(getApplicationContext(), MainActivity.class);


                startActivity(main);
            }
        });


    }




}

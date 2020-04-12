package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ModifyEmployeeActivity extends AppCompatActivity {

    private EditText nameText;
    private EditText addressText;
    private EditText panText;

    private long _id;

    private DatabaseHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_employee);

        myHelper = new DatabaseHelper(this);
        myHelper.open();

        nameText = (EditText) findViewById(R.id.name_edittext);
        addressText = (EditText) findViewById(R.id.address_edittext);
        panText = (EditText) findViewById(R.id.pan_edittext);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("address");
        String pant = intent.getStringExtra("pan");

        _id = Long.parseLong(id);

        nameText.setText(name);
        addressText.setText(desc);
        panText.setText(pant);

    }

    private void returnToMainActivity(){
        Intent home_intent = new Intent(getApplicationContext(), MainActivity .class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }

    public void updateButtonPressed(View view) {
        String name = nameText.getText().toString();
        String address = addressText.getText().toString();
        String pan = panText.getText().toString();

        myHelper.update(_id, name, address, pan);
        returnToMainActivity();
    }

    public void deleteButtonPressed(View view) {
        myHelper.delete(_id);
        returnToMainActivity();
    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Datapackage.databaseHelper;
import com.example.myapplication.model.Users;

public class newnote extends AppCompatActivity {
    databaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newnote);
        EditText inputnotes= findViewById(R.id.enterNote);
        Button saveButtopn = findViewById(R.id.button2);
        db= new databaseHelper(this);
        String notesToinput = inputnotes.getText().toString();

        saveButtopn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputnotes.getText().toString();

                addData(input);



            }
        });


    }

    public void addData(String note)
    {

        boolean insertData = db.insertUser(note);
        if(insertData)
        {
            Toast.makeText(newnote.this, "YAY", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(newnote.this,"Does not exist",Toast.LENGTH_SHORT).show();
    }
    }

}
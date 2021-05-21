package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Datapackage.databaseHelper;

public class editnotes extends AppCompatActivity {
    databaseHelper mDatabaseHelper;
    Button save, delete;
    EditText textToedit;
    String currenttext;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnotes);

        mDatabaseHelper = new databaseHelper(this);
        save = findViewById(R.id.saveNew);
        delete = findViewById(R.id.delete);
        textToedit = findViewById(R.id.enterNoteAgain);


        Intent intent = getIntent();
        currenttext = intent.getStringExtra("notes");
        id = intent.getIntExtra("id",-1);
        textToedit.setText(currenttext);






        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               String editedtext = textToedit.getText().toString();
               if(!editedtext.equals(""))
               {
                   mDatabaseHelper.updateUser(editedtext,id,currenttext);
                   Toast.makeText(editnotes.this, "YAY", Toast.LENGTH_SHORT).show();
                   Intent newIntent = new Intent(editnotes.this,shownotes.class);
                   startActivity(newIntent);
               }
               else {
                   Toast.makeText(editnotes.this, "Data not updated", Toast.LENGTH_SHORT).show();

                            }





            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor data = mDatabaseHelper.fetchNotes();

                while (data.moveToNext()) {
                    Integer deleteRows = mDatabaseHelper.deleteNotes(textToedit.getText().toString());
                    Intent newIntent = new Intent(editnotes.this,shownotes.class);
                    startActivity(newIntent);
                    if (deleteRows > 0) {
                        Toast.makeText(editnotes.this, "data deleted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editnotes.this, "Data not deleted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }






}
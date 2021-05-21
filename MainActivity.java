package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button CreateNote, OpenNote;
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateNote = findViewById(R.id.newNoteButton2);
        OpenNote= findViewById(R.id.showNoteButton);
        pic = findViewById(R.id.imageView);
    }


    public void createNote(View view)
    {
        Intent intent = new Intent(this,newnote.class);
        startActivity(intent);
    }

    public void openNotes(View view)
    {
        Intent intent = new Intent(this,shownotes.class);
        startActivity(intent);
    }
}
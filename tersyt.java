package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.myapplication.Datapackage.databaseHelper;

import java.util.ArrayList;

public class tersyt extends AppCompatActivity {
    databaseHelper mDatabaseHelper;
    ListView mListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tersyt);

        mDatabaseHelper = new databaseHelper(this);
        mListview = findViewById(R.id.testlist);

        Cursor data = mDatabaseHelper.fetchNotes();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(data.getString(1));
            ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
            mListview.setAdapter(adapter);
        }
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Datapackage.databaseHelper;

import java.util.ArrayList;

public class shownotes extends AppCompatActivity {

    databaseHelper mDatabaseHelper;
    ListView mListview;
    private static final String TAG = "ListDataActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownotes);
        mDatabaseHelper = new databaseHelper(this);
        mListview=findViewById(R.id.listview);
        showNotes();



    }
    public  void showNotes () {

        Cursor data = mDatabaseHelper.fetchNotes();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(data.getString(1));
            ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
            mListview.setAdapter(adapter);


            mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String notesinputed = parent.getItemAtPosition(position).toString();
                        Cursor data = mDatabaseHelper.getItem(notesinputed);
                        int itemID = -1;
                        while (data.moveToNext())
                        {
                            itemID = data.getInt(0);
                        }
                        if(itemID>-1)
                        {
                            Intent intent = new Intent(shownotes.this,editnotes.class);
                            intent.putExtra("notes",notesinputed);
                            intent.putExtra("id",itemID);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(shownotes.this, "Didnotgenerate", Toast.LENGTH_SHORT).show();
                        }




                }
            });

        }

        }




}
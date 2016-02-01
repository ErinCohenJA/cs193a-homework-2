package com.erincohen.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener{

    private ArrayList<String> arraylist = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView taskList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskList = (ListView) findViewById(R.id.list);
        taskList.setOnItemLongClickListener(this);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylist);
        taskList.setAdapter(adapter);
    }

    public void add(View view) {
        EditText item = (EditText)findViewById(R.id.keyboard);
        String editItem = item.getText().toString();
        arraylist.add(editItem);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> list, View row, int index, long rowID){
        arraylist.remove(index);
        adapter.notifyDataSetChanged();
        return true;
    }
}

package com.erincohen.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> arraylist = new ArrayList<>();
    private ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylist);
    ListView list = (ListView) findViewById(R.id.list);
    implements AdapterView.OnItemClickListener{
        list.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.setAdapter(adapter)
    }

    public void add(View view) {
        String item = (EditText)findViewById(R.id.keyboard).toString();
        arraylist.add(item);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<android.widget.Adapter> list, View row, int index, long rowID){
        list.removeViewAt(index);
        arraylist.remove(index);
        adapter.notifyDataSetChanged();
    }
}

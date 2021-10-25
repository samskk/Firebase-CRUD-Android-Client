package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    static ArrayList<String> items;
    static ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.list_item);
        items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Orange");
        items.add("Strawberry");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name =items.get(i);
                makeTost(name);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                makeTost("removed"+items.get(i));
                removeItem(i);
                return false;
            }
        });

        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,items);
        listView.setAdapter(adapter);

    }
    Toast t;
    private void makeTost(String s){
        if (t != null) t.cancel();
        t =Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT);
        t.show();
    }
    public static void  removeItem(int remove){
        items.remove(remove);
        adapter.notifyDataSetChanged();
    }
}
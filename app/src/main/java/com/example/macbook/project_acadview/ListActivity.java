package com.example.macbook.project_acadview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.widget.ListView;
import android.view.*;
import android.widget.*;




import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    static ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView list=findViewById(R.id.list);
         arrayList = (ArrayList<String>) getIntent().getSerializableExtra("list_passed");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);
         list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),showToast.class);
                intent.putExtra("name", arrayList.get(position));
                startActivity(intent);
            }
        });



    }




    }

package com.example.macbook.project_acadview;

import android.content.Intent;
import android.net.Uri;
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

                final String text = (String) parent.getItemAtPosition(position);
                if ("dialerpad".compareTo(text) == 0) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("tel:9728080928"));
                    startActivity(intent);

                }
                else if ("browser".compareTo(text) == 0) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.google.com"));
                    startActivity(intent);

                }
                else if ("camera".compareTo(text) == 0) {

                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 1888);

                }
                else if ("map".compareTo(text) == 0) {

                    Uri location = Uri.parse("geo:29.149188, 75.721653");
                    Intent i = new Intent(Intent.ACTION_VIEW, location);
                    startActivity(i);

                }
                else if ("gmail".compareTo(text) == 0) {

                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                    startActivity(intent);

                } else {


                    Intent intent = new Intent(getApplicationContext(),showToast.class);
                intent.putExtra("name", arrayList.get(position));
                startActivity(intent);
            }}
        });



    }




    }

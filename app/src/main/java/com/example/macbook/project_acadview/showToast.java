package com.example.macbook.project_acadview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.*;
import android.util.Log;
import android.view.*;
import android.widget.*;



public class showToast extends AppCompatActivity {

    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        TextView text=findViewById(R.id.textView);
         Bundle bundle=getIntent().getExtras();
        text.setText(bundle.getString("name"));

    }
}

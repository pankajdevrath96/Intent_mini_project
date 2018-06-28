package com.example.macbook.project_acadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;
import android.content.*;
import android.widget.EditText;
import android.net.Uri;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> myList = new ArrayList<>();
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        }

    public void click(View v) {
        EditText text = findViewById(R.id.editText);
        myList.add(text.getText().toString());
        if ("dialerpad".compareTo(text.getText().toString()) == 0) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("tel:9728080928"));
            startActivity(intent);

        }
        else if ("browser".compareTo(text.getText().toString()) == 0) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.google.com"));
            startActivity(intent);

        }
        else if ("camera".compareTo(text.getText().toString()) == 0) {

            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, 1888);

        }
        else if ("map".compareTo(text.getText().toString()) == 0) {

            Uri location = Uri.parse("geo:29.149188, 75.721653");
            Intent i = new Intent(Intent.ACTION_VIEW, location);
            startActivity(i);

        }
        else if ("gmail".compareTo(text.getText().toString()) == 0) {

            Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
            startActivity(intent);

        } else {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("list_passed", myList);

            startActivity(intent);

    }
    }
}

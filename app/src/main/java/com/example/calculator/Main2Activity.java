package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    static final String KEY_RESULT = "key_result";
    MainAdapter adapter;
    ArrayList<String> list;
    String s;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView recyclerView = findViewById(R.id.recrw);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        list = new ArrayList<>();


        Intent intent = getIntent();
        if (intent != null) {
            list = intent.getStringArrayListExtra(KEY_RESULT);
            Log.e("ololo", "list " + list);
            adapter.data.add(String.valueOf(list));


            Button button1 = findViewById(R.id.share);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, list);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            });
        }

        Button button = findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
closeActivity();
            }

        });
    }

    private void closeActivity() {

        this.finish();
    }
}



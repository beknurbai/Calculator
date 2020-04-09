package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
static final String KEY_RESULT="key_result";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView textView = findViewById(R.id.textResult);
        Intent intent = getIntent();
        if (intent!=null){
            final String s=intent.getStringExtra(KEY_RESULT);
            textView.setText(s);
            Button button1=findViewById(R.id.share);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setAction(intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,s);
                    if (intent.resolveActivity(getPackageManager())!=null){
                        startActivity(intent);
                    }
                }
            });
}




        Button button=findViewById(R.id.start);
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
    }}


package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class seeAll extends AppCompatActivity {
    private ImageView backBtn;
    private TextView name1,advance,react,javaBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        backBtn = (ImageView) findViewById(R.id.back2Btn);
        name1 = (TextView)findViewById(R.id.unId);
        advance=(TextView) findViewById(R.id.advanceBtn);
        react=(TextView) findViewById(R.id.reactBtn);
        javaBtn=(TextView) findViewById(R.id.javaBtn);

        //String uname = getIntent().getStringExtra("keyname");
        //name1.setText(uname);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(seeAll.this,StudentHome.class));
            }
        });
        advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(seeAll.this,courseDetails.class));
            }
        });

        react.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(seeAll.this,courseDetails.class));
            }
        });
        javaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(seeAll.this,courseDetails.class));
            }
        });


    }
}
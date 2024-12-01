package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class stuNotice extends AppCompatActivity {
    private ImageView back5Btn;
    private TextView name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_notice);

        back5Btn = (ImageView) findViewById(R.id.back5Btn);
        name = (TextView) findViewById(R.id.uname2Id);

        String uname = getIntent().getStringExtra("keyname");
        name.setText(uname);

        back5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(stuNotice.this,StudentHome.class));
            }
        });

    }
}
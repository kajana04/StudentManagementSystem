package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class login extends AppCompatActivity {
    private ImageView back;
    private Button stuBtn, teachBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        back=(ImageView) findViewById(R.id.back1Id);
        stuBtn=(Button)findViewById(R.id.stuId);
        teachBtn=(Button)findViewById(R.id.tecId);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this,MainActivity.class);
                startActivity(intent);
            }
        });

        stuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,student.class);
                startActivity(intent);
            }
        });
        teachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,teacher.class);
                startActivity(intent);
            }
        });

    }
}
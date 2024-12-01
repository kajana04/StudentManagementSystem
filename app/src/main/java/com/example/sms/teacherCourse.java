package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class teacherCourse extends AppCompatActivity {
    private ImageView back5;
    private TextView subject;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_course);

        back5 =(ImageView) findViewById(R.id.teback5Id);
        subject = (TextView) findViewById(R.id.tesubNameId);

        String sub = getIntent().getStringExtra("keyname1");
        subject.setText(sub);

        back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(teacherCourse.this, teacherHome.class));
            }
        });
    }
}
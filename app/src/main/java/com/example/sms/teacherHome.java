package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class teacherHome extends AppCompatActivity {
    private TextView name,subject,courseManage,stuAt;
    private ImageView publish;
    private Button logout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        name =(TextView) findViewById(R.id.teNameId);
        subject = (TextView) findViewById(R.id.teSubId);
        courseManage = (TextView) findViewById(R.id.manageId);
        stuAt = (TextView) findViewById(R.id.stAttId);
        publish = (ImageView) findViewById(R.id.publishId);
        logout=(Button) findViewById(R.id.teLogoutBtn);

        String uname = getIntent().getStringExtra("keyname2");
        name.setText(uname);

        String sub = getIntent().getStringExtra("keyname1");
        subject.setText(sub);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(teacherHome.this, MainActivity.class));
            }
        });

        courseManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(teacherHome.this, teacherCourse.class));
            }
        });

        stuAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(teacherHome.this, teacherStuAttendance.class));
            }
        });

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(teacherHome.this, teacherPublishInformation.class));
            }
        });

    }
}
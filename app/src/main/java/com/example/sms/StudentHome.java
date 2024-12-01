package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentHome extends AppCompatActivity {
    private TextView nameText, seeAll;
    private ImageView python, java,ux,react;
    private Button checkAtt, checkNotice,logout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        nameText = (TextView) findViewById(R.id.stdNameId);
        seeAll=(TextView) findViewById(R.id.seeCourseBtn);
        python=(ImageView) findViewById(R.id.pyId);
        java=(ImageView) findViewById(R.id.javaId);
        ux=(ImageView) findViewById(R.id.uxId);
        react=(ImageView) findViewById(R.id.reactId);
        checkAtt=(Button) findViewById(R.id.checkAtStBtn);
        checkNotice=(Button) findViewById(R.id.checkNotBtn);
        logout=(Button) findViewById(R.id.logoutBtn);


        String uname = getIntent().getStringExtra("keyname");
        nameText.setText(uname);

        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,seeAll.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,MainActivity.class));
            }
        });
        checkAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,stuAttendance.class));
            }
        });
        checkNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,stuNotice.class));
            }
        });
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,courseDetails.class));
            }
        });
        react.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,courseDetails.class));
            }
        });
        ux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,courseDetails.class));
            }
        });
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,courseDetails.class));
            }
        });


    }
}
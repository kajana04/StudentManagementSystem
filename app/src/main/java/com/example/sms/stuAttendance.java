package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class stuAttendance extends AppCompatActivity {
    private ImageView back4Btn;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_attendance);

        back4Btn=(ImageView) findViewById(R.id.back4Btn);
        name=(TextView) findViewById(R.id.unameId);

        String uname = getIntent().getStringExtra("keyname");
        name.setText(uname);

        back4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(stuAttendance.this,StudentHome.class));
            }
        });
    }
}
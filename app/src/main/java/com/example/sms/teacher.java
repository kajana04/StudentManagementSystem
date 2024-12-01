package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class teacher extends AppCompatActivity {
    private EditText email, password;
    private ImageButton loginBtn;
    private TextView regLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        email = (EditText) findViewById(R.id.emailTeach);
        password=(EditText) findViewById(R.id.passTeach);
        loginBtn=(ImageButton) findViewById(R.id.logBtnTeach);
        regLink = (TextView) findViewById(R.id.regTeach);

        Database db = new Database(getApplicationContext(),"sms",null,1);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                if (email1.length() == 0 || password1.length()==0){
                    Toast.makeText(teacher.this, "Plz fill all Details", Toast.LENGTH_SHORT).show();
                }

                else {
                    if (db.Login(email1,password1)==true){
                        Toast.makeText(teacher.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email",email1);
                        editor.apply();

                        Intent intent = new Intent(teacher.this,teacherHome.class);
                        intent.putExtra("keyname2",email1);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(teacher.this, "Invalid Email and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        regLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(teacher.this, teacherReg.class);
                startActivity(intent);
            }
        });



    }
}
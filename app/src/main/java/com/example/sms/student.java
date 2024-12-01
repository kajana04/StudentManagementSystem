package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class student extends AppCompatActivity {
    private EditText email, password;
    private ImageView loginBtn;
    private TextView regLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        email = (EditText) findViewById(R.id.emailSt);
        password=(EditText) findViewById(R.id.passStu);
        loginBtn=(ImageView)findViewById(R.id.logBtnSt);
        regLink=(TextView)findViewById(R.id.regSt);

        Database db = new Database(getApplicationContext(),"sms",null,1);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                if (email1.length() == 0 || password1.length()==0){
                    Toast.makeText(student.this, "Plz fill all Details", Toast.LENGTH_SHORT).show();
                }

                else {
                    if (db.Login(email1,password1)==true){
                        Toast.makeText(student.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email",email1);
                        editor.apply();

                        Intent intent = new Intent(student.this,StudentHome.class);
                        intent.putExtra("keyname",email1);
                        startActivity(intent);
                        //startActivity(new Intent(student.this,StudentHome.class));
                    }
                    else {
                        Toast.makeText(student.this, "Invalid Email and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        regLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(student.this,studentReg.class));

            }
        });

    }
}
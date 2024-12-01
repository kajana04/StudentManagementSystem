package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class teacherReg extends AppCompatActivity {
    private EditText fName, mail, department, pass, conPass;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reg);

        fName = (EditText) findViewById(R.id.nameteText);
        mail = (EditText) findViewById(R.id.mailteText);
        department = (EditText) findViewById(R.id.depteText);
        pass = (EditText) findViewById(R.id.passteText);
        conPass = (EditText) findViewById(R.id.conPassteText);
        regBtn = (Button) findViewById(R.id.regtechBtn);

        Database db = new Database(getApplicationContext(), "sms", null, 1);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = fName.getText().toString();
                String email = mail.getText().toString();
                String dep = department.getText().toString();
                String password = pass.getText().toString();
                String confirmPassword = conPass.getText().toString();


                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || dep.length() == 0 || confirmPassword.length() == 0) {
                    Toast.makeText(teacherReg.this, "Plz Fill all Details", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(teacherReg.this, "Passwords equal to or greater than 8", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirmPassword) == 0) {
                        if (isValid(password)) {
                            db.register(email, password);
                            Intent intent = new Intent(teacherReg.this,teacher.class);
                            intent.putExtra("keyname1",dep);
                            startActivity(intent);
                            Toast.makeText(teacherReg.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(teacherReg.this, "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
    public static boolean isValid(String Passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (Passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < Passwordhere.length(); p++) {
                if (Character.isLetter(Passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int q = 0; q < Passwordhere.length(); q++) {
                if (Character.isDigit(Passwordhere.charAt(q))) {
                    f2 = 1;
                }
            }
            for (int r = 0; r < Passwordhere.length(); r++) {
                char c = Passwordhere.charAt(r);
                if (c > 33 && c < 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f2 == 1 && f1 == 1 && f3 == 1) {
                return true;
            }
            return false;
        }
    }

}
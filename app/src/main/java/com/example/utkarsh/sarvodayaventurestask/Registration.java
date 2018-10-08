package com.example.utkarsh.sarvodayaventurestask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utkarsh.sarvodayaventurestask.model.Users;

public class Registration extends AppCompatActivity {

    EditText edname,edemail,edphone,edpass,edconfpass,edgender;
    Button btnregister;
    String name_str,email_str,phone_str,pass_str,confpas_str,gender_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        //Component Initialising
        edname = findViewById(R.id.editText8);
        edemail = findViewById(R.id.editText9);
        edphone = findViewById(R.id.editText10);
        edpass = findViewById(R.id.editText11);
        edconfpass = findViewById(R.id.editText12);
        edgender = findViewById(R.id.editText13);
        btnregister= findViewById(R.id.button4);



        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_str = edname.getText().toString();
                email_str = edemail.getText().toString();
                phone_str = edphone.getText().toString();
                pass_str = edpass.getText().toString();
                confpas_str = edconfpass.getText().toString();
                gender_str = edgender.getText().toString();


                if (name_str.trim().equals("")) {
                    edname.setError("Emtpy Name");
                    edname.requestFocus();
                    return;
                } else if (email_str.equals("")) {
                    edemail.setError("Empty Email");
                    edemail.requestFocus();
                    return;
                } else if (phone_str.equals("")) {
                    edphone.setError("Empty Phone");
                    edphone.requestFocus();
                    return;
                } else if (pass_str.equals("")) {
                    edpass.setError("Empty Password");
                    edpass.requestFocus();
                    return;
                }
                else if (confpas_str.equals("")) {
                    edconfpass.setError("Empty Confirm Password");
                    edconfpass.requestFocus();
                    return;
                }

                else if (gender_str.equals("")) {
                    edgender.setError("Empty Gender");
                    edgender.requestFocus();
                    return;
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(email_str).matches()) {
                    edemail.setError("Please enter a valid email");
                    edemail.requestFocus();
                    return;
                }
                else if (edpass.length() < 6) {
                    edpass.setError("Minimum lenght of password should be 6");
                    edpass.requestFocus();
                    return;
                }

                else if (edconfpass.length() < 6) {
                    edconfpass.setError("Minimum lenght of password should be 6");
                    edconfpass.requestFocus();
                    return;
                }

                else if(!(pass_str.trim().equals(confpas_str.trim())))
                {
                    edconfpass.setError("Invalid");
                    edconfpass.requestFocus();
                    Toast.makeText(Registration.this, "Confirm Password Wrong", Toast.LENGTH_SHORT).show();
                    return;
                }

                else
                {
                    Toast.makeText(Registration.this, "testt"+email_str + name_str+phone_str+gender_str+pass_str, Toast.LENGTH_SHORT).show();
                    Users users = new Users();
                    users.setEmail(email_str);
                    users.setName(name_str);
                    users.setPhone(phone_str);
                    users.setGender(gender_str);
                    users.setPassword(pass_str);

                    DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                    databaseHelper.insertRecord(users);
                    edname.setText("");
                    edemail.setText("");
                    edpass.setText("");
                    edgender.setText("");
                    edphone.setText("");
                    edconfpass.setText("");

                }

            }
        });
    }



}

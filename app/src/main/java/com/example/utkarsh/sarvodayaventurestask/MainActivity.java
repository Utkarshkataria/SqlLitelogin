package com.example.utkarsh.sarvodayaventurestask;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utkarsh.sarvodayaventurestask.model.Users;
import com.example.utkarsh.sarvodayaventurestask.model.UsersDetails;

public class MainActivity extends AppCompatActivity {

    EditText eduserid,edpass;
    ImageView imageView;
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eduserid = findViewById(R.id.ed_ID);
        edpass = findViewById(R.id.ed_pass);
        imageView = findViewById(R.id.imageView3);
        txtRegister = findViewById(R.id.textView14);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 2);
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CONTACTS}, 2);
        }

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Registration.class));
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid;
                String userpass;

                userid = eduserid.getText().toString();
                userpass = edpass.getText().toString();
              /*  if(userid.equals("1") && userpass.equals("123456"))
                {
                    startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                    return;
                }*/

                if(eduserid.getText().toString().equals("")){
                    eduserid.setError("ID empty");
                    return;
                }
                if(edpass.getText().toString().equals(""))
                {
                    edpass.setError("password empty");
                    return;
                }


                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                //String id = eduserid.getText().toString();
                Users users = databaseHelper.getRecord(userid);
                Toast.makeText(MainActivity.this,""+users.getName(), Toast.LENGTH_SHORT).show();

                if((userid.equals(users.getEmail()) || userid.equals(users.getPhone()) && userpass.equals(users.getPassword())))
                {
                    UsersDetails.getInstance().setEmail(userid);
                    startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                }
            }
        });


    }
}

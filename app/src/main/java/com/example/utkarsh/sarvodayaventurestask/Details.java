package com.example.utkarsh.sarvodayaventurestask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utkarsh.sarvodayaventurestask.model.Users;
import com.example.utkarsh.sarvodayaventurestask.model.UsersDetails;

public class Details extends AppCompatActivity {


    EditText edName,edEmail,edPhone,edpass,edgender;
    String id;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

       edName = findViewById(R.id.editText2);
       edEmail = findViewById(R.id.editText3);
       edgender = findViewById(R.id.editText5);
       edpass = findViewById(R.id.editText6);
       edPhone = findViewById(R.id.editText4);
       btnSave = findViewById(R.id.button5);

       id = UsersDetails.getInstance().getEmail();

       final DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
       final Users users = databaseHelper.getRecord(id);

       edName.setText(users.getName());
       edEmail.setText(users.getEmail());
       edPhone.setText(users.getPhone());
       edgender.setText(users.getGender());
       edpass.setText(users.getPassword());


       btnSave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Users users1 = new Users(edEmail.getText().toString(),edName.getText().toString(),edgender.getText().toString(),edPhone.getText().toString(),edpass.getText().toString());

               databaseHelper.updateRecord(users1);
               Toast.makeText(Details.this, "Details saved", Toast.LENGTH_SHORT).show();
           }
       });





    }
}

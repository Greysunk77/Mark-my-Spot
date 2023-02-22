package com.example.markmyspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Register extends AppCompatActivity {
    EditText name;
    EditText surname;
    EditText RUsername;
    EditText RPassword;
    Button btnregister;


    //string attributes
    String savedName;
    String savedSurname;
    String savedUsername;
    String savedPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        try {

            name=(EditText) findViewById(R.id.name);
            surname=(EditText) findViewById(R.id.surname);
            RUsername=(EditText) findViewById(R.id.Rusername);
            RPassword=(EditText) findViewById(R.id.Rpassword);
            btnregister =(Button) findViewById(R.id.btnRegister);


            //register button
            btnregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (name.length()==0){
                        Snackbar.make(findViewById(android.R.id.content),"Please enter Your Name", Snackbar.LENGTH_LONG).show();
                    }else  if (surname.length()==0){
                        Snackbar.make(findViewById(android.R.id.content),"Please enter Your surname", Snackbar.LENGTH_LONG).show();
                    }else  if (RUsername.length()==0){
                        Snackbar.make(findViewById(android.R.id.content),"Please enter Your Email", Snackbar.LENGTH_LONG).show();
                    }else  if (RPassword.length()==0){
                        Snackbar.make(findViewById(android.R.id.content),"Please enter Your Password", Snackbar.LENGTH_LONG).show();
                    }else{
                        //registered
                        savedName = name.getText().toString();
                        savedSurname = surname.getText().toString();
                        savedUsername = RUsername.getText().toString();
                        savedPassword = RPassword.getText().toString();
                        //go to

                       // Snackbar.make(findViewById(android.R.id.content),"Successfully created account", Snackbar.LENGTH_LONG).show();
                        openIntent(Register.this,RUsername.getText().toString(),RPassword.getText().toString(),Login.class);
                    }

                }
            });
        }catch (Exception e){
            Toast.makeText(Register.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    } public  void openIntent(Context cont, String username, String Password, Class next){
        Intent inte = new Intent(cont,next);
        inte.putExtra("username",username);
        inte.putExtra("Password",Password);
        cont.startActivity(inte);
    }
    public String getSavedPassword() {
        return savedPassword;
    };

    public String getSavedEmail() {
        return savedUsername;
    }
    public String getSavedName() {
        return savedName;
    }

    public String getSavedSurname() {
        return savedSurname;
    }
}

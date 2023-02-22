package com.example.markmyspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {
EditText username;
EditText password;
String username2;
String AdminEmail="admin";
String password2;
String AdminPassword="123";
TextView noAcc;

Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle bundle = getIntent().getExtras();

        if (bundle !=null){
            username2 = bundle.getString("username");
            password2 = bundle.getString("Password");
        }
        //initialisation
        username = findViewById(R.id.Loginusername);
        password = findViewById(R.id.Loginpassword);
        noAcc = findViewById(R.id.NoAcc);
        //direct to register activity
        noAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
                finish();
            }
        });

        login =(Button)findViewById(R.id.btnLogin);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                       // startActivity(new Intent(Login.this,MainActivity.class));
                      //  finish();
                         loginAuthentication();

                    }catch (NullPointerException rig){
                        Snackbar.make(findViewById(android.R.id.content),"You do not have an account yet\nPlease create an account", Snackbar.LENGTH_LONG).show();
                       }catch (Exception e){
                        Snackbar.make(findViewById(android.R.id.content),""+e.getMessage(), Snackbar.LENGTH_LONG).show();
                    }
                }
            });

    }
    private void loginAuthentication() {
        try {
            Register myobj = new Register();

            if (username.length()==0 || password.length()==0){
                Snackbar.make(findViewById(android.R.id.content),"Enter Username and Password", Snackbar.LENGTH_LONG).show();
            }else if (username.getText().toString().equals(AdminEmail) && password.getText().toString().equals(AdminPassword)||
                    username.getText().toString().equals(username2) && password.getText().toString().equals(password2)){

                Snackbar.make(findViewById(android.R.id.content),"Logged IN", Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(Login.this,MainActivity.class));
                finish();
            }else{
                Snackbar.make(findViewById(android.R.id.content),"Invalid credentials:"+password2, Snackbar.LENGTH_LONG).show();
            }
        }catch(Exception err){
           // Snackbar.make(findViewById(android.R.id.content),"Error\n"+err.getMessage(), Snackbar.LENGTH_LONG).show();
            Toast.makeText(this, "Error\n"+err.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}